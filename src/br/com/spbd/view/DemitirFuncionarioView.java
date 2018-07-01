package br.com.spbd.view;

import br.com.spbd.bean.FuncionarioBean;
import br.com.spbd.dao.FuncionarioDao;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JOptionPane;

public class DemitirFuncionarioView extends JFrame {

    private JPanel contentPane;
    public static String funcionarioSelecionado;
    String nomeInteiro;

    public DemitirFuncionarioView() {
        setResizable(false);
        setTitle("Demitir Funcionarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 393, 207);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        comboBox.setBounds(10, 11, 357, 22);
        contentPane.add(comboBox);

        for (int i = 0; i < new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().size(); i++) {

            nomeInteiro = new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().get(i).getNomeFuncionario() + " " + new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().get(i).getSobrenomeFuncionario();
            comboBox.addItem(nomeInteiro);
        }

        JButton btnNewButton = new JButton("Demitir");
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                funcionarioSelecionado = comboBox.getSelectedItem().toString();
                String[] informacoes = funcionarioSelecionado.split(" ", 2);
                JOptionPane.showMessageDialog(null, "Funcionario demitido com sucesso");
                AcaoAdmView a = new AcaoAdmView();
                a.setVisible(true);
                new FuncionarioDao().demitirFuncionarioBanco(informacoes[0], informacoes[1]);
                new FuncionarioBean().demitirFuncionario();
                dispose();
            }
        });
        btnNewButton.setBounds(58, 68, 254, 23);
        contentPane.add(btnNewButton);

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
        btnNewButton_1.setBounds(141, 117, 89, 23);
        contentPane.add(btnNewButton_1);
    }

}
