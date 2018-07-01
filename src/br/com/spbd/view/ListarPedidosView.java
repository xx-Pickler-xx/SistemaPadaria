package br.com.spbd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladres.Pedidos;
import controladres.Produto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ListarPedidosView extends JFrame {

	private JPanel contentPane;

	// -----------------------------------------------------------------------------------------------------
	
	//JFrame
	public ListarPedidosView() {
		setResizable(false);
		setTitle("Listar Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// -----------------------------------------------------------------------------------------------------
		
		// DefaultTableModel - Serve para agrupar os dados
				DefaultTableModel exibirDados = new DefaultTableModel();

				// Criar colunas
				exibirDados.addColumn("Pedidos");
				exibirDados.addColumn("Valor Total");
				contentPane.setLayout(null);
				
				

				// JTable - Serve para exibir o DefaultTableModel
				JTable tabela = new JTable(exibirDados);
				tabela.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));

				// JScrollPane - Barra de rolagem englobando o JTable
				JScrollPane barraRolagem = new JScrollPane(tabela);
				barraRolagem.setBounds(16, 10, 452, 402);
				contentPane.add(barraRolagem);
				
				for (Pedidos pedido : Pedidos.PedidoTotal) {
					Object[] obj5 = { pedido.texto, pedido.precoTotal};
					exibirDados.addRow(obj5);
					
				}
				
				// -----------------------------------------------------------------------------------------------------
				
				// Criando e adicionando uma a��o ao bot�o VOLTAR
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
				btnNewButton_1.setBounds(66, 441, 352, 23);
				contentPane.add(btnNewButton_1);
	}

}
