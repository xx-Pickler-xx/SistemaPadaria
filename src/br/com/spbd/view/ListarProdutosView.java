package br.com.spbd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladres.Produto;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ListarProdutosView extends JFrame {

	private JPanel contentPane;

	// -----------------------------------------------------------------------------------------------------

	public ListarProdutosView() {
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Listar produtos");

		// JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// -----------------------------------------------------------------------------------------------------

		// DefaultTableModel - Serve para agrupar os dados
		DefaultTableModel exibirDados = new DefaultTableModel();

		// Criar colunas
		exibirDados.addColumn("Produto");
		exibirDados.addColumn("Valor");
		for (Produto produto : Produto.produto) {
			Object[] informacoes = { produto.nome, produto.valor };
			exibirDados.addRow(informacoes);
		}
		contentPane.setLayout(null);

		// JTable - Serve para exibir o DefaultTableModel
		JTable tabela = new JTable(exibirDados);
		tabela.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));

		// JScrollPane - Barra de rolagem englobando o JTable
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 11, 562, 473);
		contentPane.add(barraRolagem);
		
		// -----------------------------------------------------------------------------------------------------
		
		//Criando e adicionando uma acao ao botao VOLTAR
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AcaoFuncionarioView a = new AcaoFuncionarioView();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(93, 515, 406, 23);
		contentPane.add(btnNewButton);
	}

}
