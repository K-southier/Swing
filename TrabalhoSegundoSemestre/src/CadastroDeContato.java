import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeContato {
    private JPanel mainPanel;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton bntAdd;
    private JList listContatos;
    private DefaultListModel<String> listModel;
    private JButton bntRemover;
    

        public void CadastrodeContato() {
            listModel = new DefaultListModel<>();
            listContatos.setModel(listModel);

            // Adiciona funcionalidade ao botão 'Adicionar'
            bntAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = txtNome.getText();
                    String telefone = txtTelefone.getText();
                    String email = txtEmail.getText();

                    if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String contato = "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
                    listModel.addElement(contato);

                    txtNome.setText("");
                    txtTelefone.setText("");
                    txtEmail.setText("");
                }
            });

            // Adiciona funcionalidade ao botão 'Remover'
            bntRemover.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = listContatos.getSelectedIndex();
                    if (selectedIndex != -1) {
                        listModel.remove(selectedIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um contato para remover.", "Erro de Seleção", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Cadastro de Contatos");
            frame.setContentPane(new CadastroDeContato().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
    }

}
