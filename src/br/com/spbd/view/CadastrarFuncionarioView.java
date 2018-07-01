package br.com.spbd.view;

import br.com.spbd.bean.FuncionarioBean;
import br.com.spbd.dao.FuncionarioDao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class CadastrarFuncionarioView extends JFrame {
    
    public static void main(String[] args) {
        CadastrarFuncionarioView a = new CadastrarFuncionarioView();
        a.setVisible(true);
    }

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    // -----------------------------------------------------------------------------------------------------
    public CadastrarFuncionarioView() {
        setResizable(false);
        setTitle("Cadastrar funcionarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 435, 353);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // -----------------------------------------------------------------------------------------------------
        textField = new JTextField();
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField.setBounds(20, 36, 163, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        // -----------------------------------------------------------------------------------------------------
        JLabel lblNewLabel = new JLabel("Nome");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel.setBounds(10, 11, 46, 14);
        contentPane.add(lblNewLabel);

        // -----------------------------------------------------------------------------------------------------
        JLabel lblNewLabel_1 = new JLabel("Idade");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(10, 67, 46, 14);
        contentPane.add(lblNewLabel_1);

        // -----------------------------------------------------------------------------------------------------
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField_1.setBounds(20, 90, 163, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        // -----------------------------------------------------------------------------------------------------
        JLabel lblNewLabel_2 = new JLabel("Sobrenome");
        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel_2.setBounds(232, 11, 72, 14);
        contentPane.add(lblNewLabel_2);

        // -----------------------------------------------------------------------------------------------------
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField_2.setBounds(246, 36, 163, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        // -----------------------------------------------------------------------------------------------------
        // JLabel Sexo
        JLabel lblSexo = new JLabel("Sexo");
        lblSexo.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblSexo.setBounds(10, 121, 64, 14);
        contentPane.add(lblSexo);

        // -----------------------------------------------------------------------------------------------------
        // JComboBox Sexo
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        comboBox.setBounds(20, 146, 163, 22);
        contentPane.add(comboBox);

        // Adicionar valores ao JComboBox
        comboBox.addItem("Masculino");
        comboBox.addItem("Feminino");
        comboBox.addItem("Outro");

        // -----------------------------------------------------------------------------------------------------
        // JLabel Estado natal
        JLabel lblNewLabel_3 = new JLabel("Naturalidade");
        lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel_3.setBounds(232, 121, 109, 14);
        contentPane.add(lblNewLabel_3);

        // -----------------------------------------------------------------------------------------------------
        // JComboBox Naturalidade
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        comboBox_1.setBounds(246, 146, 163, 22);
        contentPane.add(comboBox_1);

        // Adicionar valores ao JComboBox
        comboBox_1.addItem("Acre");
        comboBox_1.addItem("Alagoas");
        comboBox_1.addItem("Amap�");
        comboBox_1.addItem("Amazonas");
        comboBox_1.addItem("Bahia");
        comboBox_1.addItem("Cear�");
        comboBox_1.addItem("Distrito Federal");
        comboBox_1.addItem("Esp�rito Santo");
        comboBox_1.addItem("Goi�s");
        comboBox_1.addItem("Maranh�o");
        comboBox_1.addItem("Mato Grosso");
        comboBox_1.addItem("Mato Grosso do Sul");
        comboBox_1.addItem("Minas Gerais");
        comboBox_1.addItem("Par�");
        comboBox_1.addItem("Para�ba");
        comboBox_1.addItem("Paran�");
        comboBox_1.addItem("Pernambuco");
        comboBox_1.addItem("Piau�");
        comboBox_1.addItem("Rio de Janeiro");
        comboBox_1.addItem("Rio Grande do Norte");
        comboBox_1.addItem("Rio Grande do Sul");
        comboBox_1.addItem("Rond�nia");
        comboBox_1.addItem("Roraima");
        comboBox_1.addItem("Santa Catarina");
        comboBox_1.addItem("S�o Paulo");
        comboBox_1.addItem("Sergipe");
        comboBox_1.addItem("Tocantins");

        // -----------------------------------------------------------------------------------------------------
        JLabel lblNewLabel_4 = new JLabel("Cargo");
        lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel_4.setBounds(10, 179, 46, 14);
        contentPane.add(lblNewLabel_4);

        // -----------------------------------------------------------------------------------------------------
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        comboBox_2.setBounds(20, 206, 163, 22);
        contentPane.add(comboBox_2);

        comboBox_2.addItem("Atendente");
        comboBox_2.addItem("Gar�om/Gar�onete");
        comboBox_2.addItem("Padeiro(a)");
        comboBox_2.addItem("Faxineiro(a)");

        // -----------------------------------------------------------------------------------------------------
        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                

                if (new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().size() == 0) {
                    if (FuncionarioBean.validaNome(textField.getText()) && FuncionarioBean.validaIdade(textField_1.getText())) {
                     
                        //Criar um objeto Funcionario
                        FuncionarioBean fb = new FuncionarioBean();
                        fb.setNomeFuncionario(textField.getText());
                        fb.setSobrenomeFuncionario(textField_2.getText());
                        fb.setIdadefuncionario(Integer.parseInt(textField_1.getText()));
                        fb.setSexoFuncionario(comboBox.getSelectedItem().toString());
                        fb.setNaturalidadeFuncionario(comboBox_1.getSelectedItem().toString());
                        fb.setCargoFuncionario(comboBox_2.getSelectedItem().toString());
                        fb.gerarSalario();
                        
                        FuncionarioDao fd = new FuncionarioDao();
                        fd.cadastrarFuncionario(fb);
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!");
                    }

                    textField.setText(null);
                    textField_1.setText(null);
                    textField_2.setText(null);

                } else {
                    for (int i = 0; i < new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().size(); i++) {

                        if (new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().get(i).getNomeFuncionario().equals(textField.getText()) && (new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().get(i).getSobrenomeFuncionario().equals(textField_2.getText()))) {
                            JOptionPane.showMessageDialog(null, "Esse funcionario j� est� cadastrado");
                            textField.setText(null);
                            textField_1.setText(null);
                            textField_2.setText(null);
                            return;

                        }
                    }

                    if (FuncionarioBean.validaNome(textField.getText())
                            && FuncionarioBean.validaIdade(textField_1.getText())) {
                        
                        //Criar um objeto Funcionario
                        FuncionarioBean fb = new FuncionarioBean();
                        fb.setNomeFuncionario(textField.getText());
                        fb.setSobrenomeFuncionario(textField_2.getText());
                        fb.setIdadefuncionario(Integer.parseInt(textField_1.getText()));
                        fb.setSexoFuncionario(comboBox.getSelectedItem().toString());
                        fb.setNaturalidadeFuncionario(comboBox_1.getSelectedItem().toString());
                        fb.setCargoFuncionario(comboBox_2.getSelectedItem().toString());
                        fb.gerarSalario();
                        
                        FuncionarioDao fd = new FuncionarioDao();
                        fd.cadastrarFuncionario(fb);
                        
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!");
                    }

                    textField.setText(null);
                    textField_1.setText(null);
                    textField_2.setText(null);

                }
                
            }
        });
        btnNewButton.setBounds(56, 263, 109, 23);
        contentPane.add(btnNewButton);

        // -----------------------------------------------------------------------------------------------------
        JButton btnNewButton_1 = new JButton("Voltar");
        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AcaoAdmView a = new AcaoAdmView();
                a.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(232, 263, 109, 23);
        contentPane.add(btnNewButton_1);
    }
}
