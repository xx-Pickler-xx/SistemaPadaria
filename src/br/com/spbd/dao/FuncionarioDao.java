/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spbd.dao;

import br.com.spbd.bean.FuncionarioBean;
import br.com.spbd.bean.ProdutoBean;
import br.com.spbd.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//--------------------------------------------------------------------------------------------------------------------------
/**
 *
 * @author 104933
 */
public class FuncionarioDao {

    //Variaveis
    public String nome;
    public double valor;

    //Variavel contendo a conexao
    private Connection conexao;

    //Construtor
    public FuncionarioDao() {

        //Instanciar um objeto da classe ConnectionFactory
        ConnectionFactory cf = new ConnectionFactory();

        //Adicionar a conexao na variavel da calsse
        this.conexao = cf.obterConexao();

    }

    // -----------------------------------------------------------------------------------------------------
    // Cadastrar produto
    public void cadastrarFuncionario(FuncionarioBean objeto) {

        //SQL
        String sql = "INSERT INTO funcionarios (nomeFuncionario, sobrenomeFuncionario, idadeFuncionario, sexoFuncionario, naturalidadeFuncionario, cargoFuncionario, salarioFuncionario) VALUES (?, ?, ?, ?, ?, ?, ?)";

        //Tentar executar o comando SQL
        try {

            //Preparar comando com a conexao
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            //Passar os parametros do comando sql
            pstmt.setString(1, objeto.getNomeFuncionario());
            pstmt.setString(2, objeto.getSobrenomeFuncionario());
            pstmt.setInt(3, objeto.getIdadefuncionario());
            pstmt.setString(4, objeto.getSexoFuncionario());
            pstmt.setString(5, objeto.getNaturalidadeFuncionario());
            pstmt.setString(6, objeto.getCargoFuncionario());
            pstmt.setString(7, objeto.getSalariofuncionario());

            //executar comando
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. tipo do erro: " + e.getMessage());
        }

    }
//--------------------------------------------------------------------------------------------------------------------------

    public DefaultTableModel listarFuncionarios() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Sobrenome");
        modelo.addColumn("Idade");
        modelo.addColumn("Sexo");
        modelo.addColumn("Naturalidade");
        modelo.addColumn("Cargo");
        modelo.addColumn("Salario");
        String sql = "SELECT * FROM produtos";

        try {

            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nomeFuncionario"),
                    rs.getString("sobrenomeFuncionario"),
                    rs.getInt("idadeFuncionario"),
                    rs.getString("sexoFuncionario"),
                    rs.getString("naturalidadeFuncionario"),
                    rs.getString("cargoFuncionario"),
                    rs.getString("salarioFuncionario")

                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "falha ao obter os produtos");
        }
        return modelo;
    }
//--------------------------------------------------------------------------------------------------------------------------

    public ArrayList<FuncionarioBean> EnviarNomeESobrenomeParaArrayList() {

        String PegarnomeESobrenomeDoBanco = "SELECT nomeFuncionario, sobrenomeFuncionario FROM funcionarios";
        ArrayList<FuncionarioBean> retornarArrayListFuncionario = new ArrayList<>();

        try {

            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(PegarnomeESobrenomeDoBanco);

            while (rs.next()) {

                {
                    FuncionarioBean f = new FuncionarioBean();
                    f.setNomeFuncionario(rs.getString("nomeFuncionario"));
                    f.setSobrenomeFuncionario(rs.getString("sobrenomeFuncionario"));
                    retornarArrayListFuncionario.add(f);
                };
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "falha ao obter os produtos");
        }

        return retornarArrayListFuncionario;
    }

    //--------------------------------------------------------------------------------------------------------------------------
    public void demitirFuncionarioBanco(String nome, String sobrenome) {

        //SQL
        String sql = "DELETE FROM funcionarios WHERE funcionarios.nomeFuncionario = ? AND funcionarios.sobrenomeFuncionario = ?";

        //Tentar executar o comando SQL
        try {

            //Preparar comando com a conexao
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            //Passar os parametros do comando sql
            pstmt.setString(1, nome);
            pstmt.setString(2, sobrenome);

            //executar comando
             System.out.println(pstmt.toString());
            pstmt.execute();
           
            pstmt.close();
        } catch (Exception e) {
            System.out.println("Falha ao demitir funcionario. Tipo do erro: " + e.getMessage());
        }

    }
    //--------------------------------------------------------------------------------------------------------------------------
}
