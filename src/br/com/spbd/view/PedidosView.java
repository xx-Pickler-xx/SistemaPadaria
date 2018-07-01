package br.com.spbd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class PedidosView extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    public Pedidos pedidoAtual = new Pedidos();
    // -----------------------------------------------------------------------------------------------------

    public PedidosView() {
        setResizable(false);
        setTitle("Realizar pedidos");

        //JFrame
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 455, 261);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // -----------------------------------------------------------------------------------------------------
        //JLabel
        JLabel lblProdutos = new JLabel("Produto");
        lblProdutos.setBounds(36, 14, 61, 14);
        contentPane.add(lblProdutos);

        JLabel lblQuantidade = new JLabel("Quantidade");
        lblQuantidade.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblQuantidade.setBounds(36, 70, 73, 14);
        contentPane.add(lblQuantidade);

        // -----------------------------------------------------------------------------------------------------
        //Caixa de texto
        textField = new JTextField();
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField.setBounds(60, 95, 355, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        // -----------------------------------------------------------------------------------------------------
        //JComboBox
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        comboBox.setBounds(60, 39, 355, 20);
        contentPane.add(comboBox);

        comboBox.setModel(new DefaultComboBoxModel(new Vector(Produto.ListaNomeDeProdutos)));

        // -----------------------------------------------------------------------------------------------------
        // Criando e adicionando uma a��o ao bot�o ADICIOANAR AO PEDIDO
        JButton btnNewButton = new JButton("Adicionar ao pedido");
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Pedidos.validaQuantidade(textField.getText())) {
                    pedidoAtual.adicionarAoPedido(comboBox.getSelectedItem().toString(), Integer.parseInt(textField.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar pedido!");
                }

                textField.setText(null);

            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(36, 146, 180, 23);
        contentPane.add(btnNewButton);

        // -----------------------------------------------------------------------------------------------------
        //// Criando e adicionando uma a��o ao bot�o VOLTAR
        JButton btnNewButton_1 = new JButton("Voltar");
        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                AcaoFuncionarioView a = new AcaoFuncionarioView();
                a.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(162, 180, 136, 23);
        contentPane.add(btnNewButton_1);

        // -----------------------------------------------------------------------------------------------------
        //// Criando e adicionando uma a��o ao bot�o PEDIR
        JButton btnNewButton_2 = new JButton("Finalizar Pedido");
        btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                pedidoAtual.finalizarPedido();
                AcaoFuncionarioView a = new AcaoFuncionarioView();
                a.setVisible(true);
                dispose();

            }
        });
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_2.setBounds(235, 146, 180, 23);
        contentPane.add(btnNewButton_2);

    }
}
