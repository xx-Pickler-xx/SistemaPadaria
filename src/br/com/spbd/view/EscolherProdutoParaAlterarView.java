package br.com.spbd.view;


import br.com.spbd.dao.ProdutoDao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EscolherProdutoParaAlterarView extends JFrame {

	private JPanel contentPane;
	public static String jcombo = "";


	// -----------------------------------------------------------------------------------------------------

	// JFrame
	public EscolherProdutoParaAlterarView() {
		setTitle("Alterar produtos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		

		JComboBox comboBox2 = new JComboBox();
		comboBox2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		comboBox2.setBounds(10, 11, 303, 20);
		contentPane.add(comboBox2);
		
		comboBox2.setModel(new DefaultComboBoxModel(new Vector(new ProdutoDao().EnviarProdutoParaArrayList())));
		
		

		// -----------------------------------------------------------------------------------------------------

		// Criando e adicionando uma a��o ao bot�o ALTERAR
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jcombo = comboBox2.getSelectedItem().toString();
				AlterarView a = new AlterarView();
				a.setVisible(true);
				dispose();
				
			
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setBounds(65, 42, 190, 23);
		contentPane.add(btnNewButton);

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
		btnVoltar.setBounds(111, 76, 98, 23);
		contentPane.add(btnVoltar);
		
		
	
	
		
		
		
	}
}
