package br.com.spbd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AcaoAdmView extends JFrame {

	private JPanel contentPane;


	public AcaoAdmView() {
		setResizable(false);
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setTitle("Usuario: Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar funcionarios");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CadastrarFuncionarioView a = new CadastrarFuncionarioView();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(104, 45, 195, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listar funcionarios");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarFuncionariosView a = new ListarFuncionariosView();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(104, 79, 195, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Demitir funcionarios");
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DemitirFuncionarioView a = new DemitirFuncionarioView();
				a.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(104, 113, 195, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginView a = new LoginView();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(148, 147, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}







