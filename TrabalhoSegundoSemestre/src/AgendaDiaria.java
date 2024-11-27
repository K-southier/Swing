import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AgendaDiaria {
    private JPanel mainPanel;
    private JTextField txtCompromisso;
    private JSpinner sphora;
    private JButton bntAdd;
    private JButton bntRemover;
    private JTable table1;

        public AgendaDiaria() {

            JFrame frame = new JFrame();
            frame.setTitle("Agenda Diária");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2, 5, 5));

            panel.add(new JLabel("Compromisso"));
            txtCompromisso = new JTextField();
            panel.add(txtCompromisso);

            panel.add(new JLabel("Data/Hora"));
            sphora = new JSpinner(new SpinnerDateModel());
            JSpinner.DateEditor editor = new JSpinner.DateEditor(sphora, "dd/MM/yyyy HH:mm");
            sphora.setEditor(editor);
            panel.add(sphora);

            bntAdd = new JButton("Adicionar");
            bntRemover = new JButton("Remover");
            panel.add(bntAdd);
            panel.add(bntRemover);

            frame.add(panel, BorderLayout.NORTH);

            table1 = new JTable();
            table1.setModel(new DefaultTableModel(new Object[]{"Data/Hora", "Descrição"}, 0));
            JScrollPane scrollPane = new JScrollPane(table1);
            frame.add(scrollPane, BorderLayout.CENTER);

            bntAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String descricao = txtCompromisso.getText();
                    if (descricao.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira um compromisso");
                        return;
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String datahora = sdf.format(sphora.getValue());
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.addRow(new Object[]{datahora, descricao});
                    txtCompromisso.setText("");
                }
            });

            bntRemover.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int linhaselecionada = table1.getSelectedRow();
                    if (linhaselecionada == -1) {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um compromisso");
                    } else {
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.removeRow(linhaselecionada);
                    }
                }
            });
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new AgendaDiaria());
    }

}
