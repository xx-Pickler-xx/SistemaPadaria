/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spbd.dao;

import br.com.spbd.bean.ProdutoBean;
import br.com.spbd.connection.ConnectionFactory;
import br.com.spbd.view.CadastrarProdutoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 104933
 */
public class ProdutoDao {

    //Variaveis
    public String nome;
    public double valor;

    //Variavel contendo a conexao
    private Connection conexao;

    //Construtor
    public ProdutoDao() {

        //Instanciar um objeto da classe ConnectionFactory
        ConnectionFactory cf = new ConnectionFactory();

        //Adicionar a conexao na variavel da calsse
        this.conexao = cf.obterConexao();

    }

    // -----------------------------------------------------------------------------------------------------
    // Cadastrar produto
    public void cadastrarProduto(ProdutoBean objeto) {

        //SQL
        String sql = "INSERT INTO produtos (nomeProduto, valorProduto) VALUES (?, ?)";

        //Tentar executar o comando SQL
        try {

            //Preparar comando com a conexao
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            //PAssar os parametros do comando sql
            pstmt.setString(1, objeto.getNomeProduto());
            pstmt.setDouble(2, objeto.getValorProduto());

            //executar comando
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. tipo do erro: " + e.getMessage());
        }

    }

    public DefaultTableModel listarProdutos() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Produto");
        modelo.addColumn("Valor");
        String sql = "SELECT * FROM produtos";

        try {

            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("idproduto"),
                     rs.getString("nomeProduto"),
                     rs.getDouble("valorProduto")

                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "falha ao obter os produtos");
        }
        return modelo;
    }

    public ArrayList<ProdutoBean> EnviarProdutoParaArrayList() {

        String PegarProdutoDoBanco = "SELECT nomeProduto, valorProduto FROM produtos";
        ArrayList<ProdutoBean> retornarArrayListNomeProduto = new ArrayList<>();

        try {

            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(PegarProdutoDoBanco);

            while (rs.next()) {

                {
                    ProdutoBean p = new ProdutoBean();
                    p.setNomeProduto(rs.getString("nomeProduto"));
                    retornarArrayListNomeProduto.add(p);
                };
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "falha ao obter os produtos");
        }

        return retornarArrayListNomeProduto;
    }
}
