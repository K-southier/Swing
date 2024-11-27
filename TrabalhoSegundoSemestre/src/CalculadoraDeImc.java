import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraDeImc {
    private JPanel mainPanel;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton bntCalcular;
    private JLabel lblCategoria;
    private JLabel lblValorImc;


    public CalculadoraDeImc() {

            bntCalcular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double peso = Double.valueOf(txtPeso.getText());
                        double altura = Double.valueOf(txtAltura.getText());

                        if (peso <= 0 || altura <= 0) {
                            lblValorImc.setText("Peso e altura devem ser maiores que zero.");
                            return;
                        }
                        double imc = peso / (altura * altura);

                        if (imc < 18.5) {
                            lblCategoria.setText("Baixo peso");
                        } else if (imc < 24.9) {
                            lblCategoria.setText("Peso normal");
                        } else if (imc < 29.9) {
                            lblCategoria.setText("Sobrepeso");
                        } else {
                            lblCategoria.setText("Obesidade");
                        }

                        lblValorImc.setText("IMC: " + String.format("%.2f", imc));
                    } catch (NumberFormatException ex) {
                        lblValorImc.setText("Insira valores numéricos válidos.");
                    }
                }
            });
        }
        public static void main(String[] args) {
            JFrame tela = new JFrame("Calculadora IMC");
            tela.setContentPane(new CalculadoraDeImc().mainPanel);
            tela.setVisible(true);
            tela.setSize(300,259);

}}
