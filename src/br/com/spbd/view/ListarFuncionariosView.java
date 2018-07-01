package br.com.spbd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarFuncionariosView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public ListarFuncionariosView() {
		setResizable(false);
		setTitle("Listar funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// DefaultTableModel - Serve para agrupar os dados
		DefaultTableModel exibirDados = new DefaultTableModel();
		
		//Criadno colunas
		exibirDados.addColumn("Nome");
		exibirDados.addColumn("Sobrenome");
		exibirDados.addColumn("Idade");
		exibirDados.addColumn("Sexo");
		exibirDados.addColumn("Naturalidade");
		exibirDados.addColumn("cargo");
		exibirDados.addColumn("salario");
		
		for (Funcionario funcionario : Funcionario.funcionario) {
			Object[] informacoes = { funcionario.nome, funcionario.sobrenome, funcionario.idade, funcionario.sexo, funcionario.naturanidade, funcionario.cargo, funcionario.salario };
		exibirDados.addRow(informacoes);
		}

		// JTable - Serve para exibir o DefaultTableModel
		JTable tabela = new JTable(exibirDados);

		// JScrollPane - Barra de rolagem englobando o JTable
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 11, 834, 455);
		contentPane.add(barraRolagem);
		

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AcaoAdmView a = new AcaoAdmView();
				a.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(385, 487, 89, 23);
		contentPane.add(btnVoltar);
	}
}
