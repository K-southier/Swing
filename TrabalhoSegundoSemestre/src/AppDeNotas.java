import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppDeNotas {
    private JButton btnAdd;
    private JButton btnCalcularMedia;
    private ArrayList<Double> notas;
    private JPanel panelMain;
    private JTextField txtNota;
    private JTextArea txtLista;
    private JLabel lblResultado;

    public AppDeNotas() {
        notas = new ArrayList<>();

        // Inicializando os componentes da interface gráfica
        txtNota = new JTextField(10); // Campo para inserir a nota
        btnAdd = new JButton("Adicionar Nota"); // Botão para adicionar a nota
        btnCalcularMedia = new JButton("Calcular Média"); // Botão para calcular a média
        txtLista = new JTextArea(10, 30); // Área de texto para listar as notas
        lblResultado = new JLabel("Média: 0.0"); // Rótulo que exibirá a média
        panelMain = new JPanel(); // Painel principal

        // Tornando a área de texto somente leitura
        txtLista.setEditable(false);
        txtLista.setLineWrap(true);
        txtLista.setWrapStyleWord(true);

        // Adicionando componentes ao painel principal
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(new JLabel("Insira a nota:"));
        panelMain.add(txtNota);
        panelMain.add(btnAdd);
        panelMain.add(btnCalcularMedia);
        panelMain.add(new JScrollPane(txtLista));
        panelMain.add(lblResultado);

        // Adicionando ação ao botão "Adicionar Nota"
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(txtNota.getText()); // Tenta converter para double
                    notas.add(nota); // Adiciona a nota à lista
                    txtNota.setText(""); // Limpa o campo de texto
                    atualizarListaNotas(); // Atualiza a lista de notas
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a nota.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionando ação ao botão "Calcular Média"
        btnCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
    }

    private void atualizarListaNotas() {
        StringBuilder sb = new StringBuilder();
        for (Double nota : notas) {
            sb.append(nota).append("\n"); // Adiciona cada nota em uma nova linha
        }
        txtLista.setText(sb.toString()); // Atualiza a área de texto com a lista de notas
    }

    private void calcularMedia() {
        if (notas.size() > 0) {
            double soma = 0;
            for (Double nota : notas) {
                soma += nota; // Soma todas as notas
            }
            double media = soma / notas.size(); // Calcula a média
            String status = media >= 7.0 ? "Aprovado" : "Reprovado"; // Verifica o status de aprovação
            lblResultado.setText("Média: " + String.format("%.2f", media) + " - " + status);

            JOptionPane.showMessageDialog(null, status + " com média " + String.format("%.2f", media), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lblResultado.setText("Média: 0.0"); // Caso não haja notas, exibe média 0.0
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AppDeNotas().panelMain);
        frame.setVisible(true);
}
}