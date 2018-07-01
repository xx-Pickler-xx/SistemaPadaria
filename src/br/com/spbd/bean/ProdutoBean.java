/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spbd.bean;

import br.com.spbd.dao.ProdutoDao;
import br.com.spbd.view.EscolherProdutoParaAlterarView;

/**
 *
 * @author 104933
 */
public class ProdutoBean {

    //Atributos
    private int idProduto;
    private String nomeProduto;
    private double valorProduto;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the marcaProduto
     */
    public double getValorProduto() {
        return valorProduto;
    }

    /**
     * @param valorProduto the valorProduto to set
     */
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    //Converter produto para String
    public String toString() {
        return nomeProduto;
    }

    // -----------------------------------------------------------------------------------------------------
    // Validar nome
    public static boolean validaNome(String nome) {
        if (nome.isEmpty()) {
            return false;
        }
        return true;

    }

    // -----------------------------------------------------------------------------------------------------
    // Validar valor
    public static boolean validaValor(String valor) {
        double valorDouble;
        try {
            valorDouble = Double.parseDouble(valor);
        } catch (Exception e) {

            return false;
        }
        if (valorDouble <= 0) {
            return false;
        }
        return true;

    }
    
    // -----------------------------------------------------------------------------------------------------
    
    public static void alterarProduto(String novoNome, double novoValor) {
		
		for (int i = 0; i < new ProdutoDao().EnviarProdutoParaArrayList().size(); i++) {
			
			if(EscolherProdutoParaAlterarView.jcombo.equals(new ProdutoDao().EnviarProdutoParaArrayList().get(i).getNomeProduto())){
				
				novoNome = new ProdutoDao().EnviarProdutoParaArrayList().get(i).getNomeProduto();
				novoValor = new ProdutoDao().EnviarProdutoParaArrayList().get(i).getValorProduto();
				
			}
		
		
		}
	}
}
