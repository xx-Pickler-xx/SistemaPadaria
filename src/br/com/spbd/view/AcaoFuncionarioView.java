package br.com.spbd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class AcaoFuncionarioView extends JFrame {

	private JPanel contentPane;

	// -----------------------------------------------------------------------------------------------------
	public AcaoFuncionarioView() {
		
		//JFrame
		setTitle("Usuario: Funcion\u00E1rio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// -----------------------------------------------------------------------------------------------------
		
		// Criando e adicionando uma a��o ao bot�o CADASTRAR PRODUTOS
		JButton btnCadastrarProdutos = new JButton("Cadastrar produtos");
		btnCadastrarProdutos.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnCadastrarProdutos.setForeground(Color.BLACK);
		btnCadastrarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarProdutoView a = new CadastrarProdutoView();
				a.setVisible(true);
				dispose();
			}
		});
		btnCadastrarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarProdutos.setBounds(44, 40, 214, 23);
		contentPane.add(btnCadastrarProdutos);
		
		// -----------------------------------------------------------------------------------------------------
		
		// Criando e adicionando uma a��o ao bot�o REALIZAR PEDIDOS
		JButton btnFazerPedidos = new JButton("Realizar pedidos");
		btnFazerPedidos.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnFazerPedidos.setForeground(Color.BLACK);
		btnFazerPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PedidosView a = new PedidosView();
				a.setVisible(true);
				dispose();
			}
		});
		btnFazerPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFazerPedidos.setBounds(44, 74, 214, 23);
		contentPane.add(btnFazerPedidos);
		
		// -----------------------------------------------------------------------------------------------------
		
		// Criando e adicionando uma a��o ao bot�o ALTERAR PRODUTOS
		JButton btnAlterarProdutos = new JButton("Alterar produtos");
		btnAlterarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EscolherProdutoParaAlterarView a = new EscolherProdutoParaAlterarView();
				a.setVisible(true);
				dispose();
			}
		});
		btnAlterarProdutos.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnAlterarProdutos.setForeground(Color.BLACK);
		btnAlterarProdutos.setBounds(44, 108, 214, 23);
		contentPane.add(btnAlterarProdutos);
		
		JButton btnNewButton = new JButton("Listar produtos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarProdutosView a = new ListarProdutosView();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(44, 142, 214, 23);
		contentPane.add(btnNewButton);
		
		// -----------------------------------------------------------------------------------------------------
		
		// Criando e adicionando uma a��o ao bot�o VOLTAR
		JButton btnSair = new JButton("Voltar");
		btnSair.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnSair.setForeground(Color.BLACK);
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginView a = new LoginView();
				a.setVisible(true);
				dispose();
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(108, 223, 89, 23);
		contentPane.add(btnSair);
		
		// -----------------------------------------------------------------------------------------------------
		
		// Criando e adicionando uma a��o ao bot�o LISTAR PEDIDOS
		JButton btnNewButton_1 = new JButton("Listar pedidos");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarPedidosView a = new ListarPedidosView();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(44, 176, 214, 23);
		contentPane.add(btnNewButton_1);
	}

}