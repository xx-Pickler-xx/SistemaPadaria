/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spbd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 104933
 */
public class ConnectionFactory {

    //Dados  de aceso para o BD
    private final String url = "jdbc:mysql://localhost:3306/spbd";
    private final String user = "root";
    private final String password = "";

    //Método de conexão
    public Connection obterConexao() {

        //Variavel para retornar conexao
        Connection conexao = null;

        //Tentar realizar a conexao
        try {
            conexao = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Conexao ok");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha: " + erro.getMessage());
            throw new RuntimeException(erro);
        }

        //Retorna a conexao
        return conexao;
    }
}
