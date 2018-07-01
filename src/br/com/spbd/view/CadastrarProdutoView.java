package br.com.spbd.view;

import br.com.spbd.bean.ProdutoBean;
import br.com.spbd.dao.ProdutoDao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.util.ArrayList;

public class CadastrarProdutoView extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTable table;
    private JTable table_1;
    
    
    public static void main(String[] args) {
        CadastrarProdutoView a = new CadastrarProdutoView();
        a.setVisible(true);
    }

    // -----------------------------------------------------------------------------------------------------
    public CadastrarProdutoView() {
        setResizable(false);

        // Jframe
        setTitle("Cadastrar Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 368, 272);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // -----------------------------------------------------------------------------------------------------
        // JLabel Nome
        JLabel lblPreo = new JLabel("Nome");
        lblPreo.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblPreo.setBounds(96, 30, 46, 14);
        contentPane.add(lblPreo);

        // -----------------------------------------------------------------------------------------------------
        // Criando e adicionando uma a��o ao bot�o CADASTRAR
        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProdutoDao a = new ProdutoDao();
                a.EnviarProdutoParaArrayList();
                

                if (new ProdutoDao().EnviarProdutoParaArrayList().size() == 0) {
                    if (ProdutoBean.validaNome(textField.getText()) && ProdutoBean.validaValor(textField_1.getText())) {
                        //Criar um objeto produto
                        ProdutoBean pb = new ProdutoBean();
                        pb.setNomeProduto(textField.getText());
                        pb.setValorProduto(Double.parseDouble(textField_1.getText()));
                        ProdutoDao pd = new ProdutoDao();
                        pd.cadastrarProduto(pb);
                        

                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!");

                    }

                    textField.setText(null);
                    textField_1.setText(null);

                } else {
                    for (int i = 0; i < new ProdutoDao().EnviarProdutoParaArrayList().size(); i++) {
                        
                    

                        if (new ProdutoDao().EnviarProdutoParaArrayList().get(i).getNomeProduto().equals(textField.getText())) {
                            JOptionPane.showMessageDialog(null, "Esse produto ja esta cadastrado");
                            textField.setText(null);
                            textField_1.setText(null);
                            return;

                        }
                    }
                    if (ProdutoBean.validaNome(textField.getText()) && ProdutoBean.validaValor(textField_1.getText())) {
                       ProdutoDao pd = new ProdutoDao();
                       //Criar um objeto produto
                        ProdutoBean pb = new ProdutoBean();
                        pb.setNomeProduto(textField.getText());
                        pb.setValorProduto(Double.parseDouble(textField_1.getText()));
                        pd.cadastrarProduto(pb);
                        
                        
                        
                        
                        
                        textField.setText(null);
                        textField_1.setText(null); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!");
                        textField.setText(null);
                        textField_1.setText(null);
                    }

                }
                System.out.println(new ProdutoDao().EnviarProdutoParaArrayList());
                
            }

        });
        btnNewButton.setBounds(10, 186, 150, 23);
        contentPane.add(btnNewButton);

        // -----------------------------------------------------------------------------------------------------
        // Caixa de texto
        textField = new JTextField();
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField.setBounds(106, 55, 150, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        // -----------------------------------------------------------------------------------------------------
        // JLabel Preco
        JLabel lblNewLabel = new JLabel("Pre\u00E7o");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel.setBounds(96, 86, 46, 14);
        contentPane.add(lblNewLabel);

        // -----------------------------------------------------------------------------------------------------
        // Caixa de texto
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField_1.setBounds(106, 111, 150, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        // -----------------------------------------------------------------------------------------------------
        // Criando e adicionando uma a��o ao bot�o VOLTAR
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AcaoFuncionarioView a = new AcaoFuncionarioView();
                a.setVisible(true);
                dispose();
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnVoltar.setBounds(190, 186, 150, 23);
        contentPane.add(btnVoltar);

        // -----------------------------------------------------------------------------------------------------
    }
    

}
