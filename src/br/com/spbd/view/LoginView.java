package br.com.spbd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	// -----------------------------------------------------------------------------------------------------

	public LoginView() {
		setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		setResizable(false);

		// Jframe
		setBackground(new Color(0, 0, 0));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 275);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// -----------------------------------------------------------------------------------------------------

		// JLabel Usuario
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblUsurio.setBounds(57, 46, 46, 14);
		contentPane.add(lblUsurio);

		// -----------------------------------------------------------------------------------------------------
		
		//Criando caixa de texto
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField.setBounds(67, 68, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		// -----------------------------------------------------------------------------------------------------
		
		// JLabel Senha
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblSenha.setBounds(57, 99, 46, 14);
		contentPane.add(lblSenha);

		// -----------------------------------------------------------------------------------------------------
		
		// Criando e adicionando uma a��o ao bot�o ENTRAR
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String usuario = textField.getText();
				String senha = passwordField.getText();

				if ((usuario.equals("funcionario")) && (senha.equals("funcionario"))) {
					AcaoFuncionarioView a = new AcaoFuncionarioView();
					a.setVisible(true);
					dispose();
				} else if ((usuario.equals("admin")) && (senha.equals("admin"))) {
					AcaoAdmView a = new AcaoAdmView();
					a.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao efetuar login!");
					textField.setText(null);
					passwordField.setText(null);
				}
			}
		});

		btnNewButton.setBounds(38, 178, 109, 23);
		contentPane.add(btnNewButton);

		// -----------------------------------------------------------------------------------------------------

		// Criando e adicionando uma a��o ao bot�o SAIR
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		btnNewButton_1.setBounds(157, 178, 105, 23);
		contentPane.add(btnNewButton_1);

		// -----------------------------------------------------------------------------------------------------

		//JPassword
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		passwordField.setBounds(67, 124, 175, 20);
		contentPane.add(passwordField);
	}
}
