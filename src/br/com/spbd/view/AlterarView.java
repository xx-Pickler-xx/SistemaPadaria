package br.com.spbd.view;

import br.com.spbd.bean.ProdutoBean;
import br.com.spbd.dao.ProdutoDao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AlterarView extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private ProdutoDao produtoAtual = new ProdutoDao();
    public String novoNome;
    public double novoValor;

    public AlterarView() {
        setResizable(false);
        for (ProdutoDao produto : new ProdutoDao().EnviarProdutoParaArrayList()) {

            if (produto.nome.equals(EscolherProdutoParaAlterarView.jcombo)) {

                produtoAtual = produto;
                break;

            }

        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 238, 238);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Novo nome");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel.setBounds(10, 11, 104, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField(produtoAtual.nome);
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField.setBounds(20, 36, 165, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Novo Valor");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(10, 67, 104, 14);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField("" + produtoAtual.valor);
        textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        textField_1.setBounds(20, 92, 165, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnAlterar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                novoNome = textField.getText();
                novoValor = Double.parseDouble(textField_1.getText());
                EscolherProdutoParaAlterarView a = new EscolherProdutoParaAlterarView();
                a.setVisible(true);
                ProdutoBean.alterarProduto(novoNome, novoValor);
                dispose();
            }
        });
        btnAlterar.setBounds(58, 130, 115, 23);
        contentPane.add(btnAlterar);

        JButton btnNewButton = new JButton("Cancelar");
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                EscolherProdutoParaAlterarView a = new EscolherProdutoParaAlterarView();
                a.setVisible(true);
                dispose();

            }
        });
        btnNewButton.setBounds(73, 164, 89, 23);
        contentPane.add(btnNewButton);
    }
}
