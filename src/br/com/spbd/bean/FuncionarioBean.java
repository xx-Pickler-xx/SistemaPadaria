/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spbd.bean;

import br.com.spbd.dao.FuncionarioDao;
import br.com.spbd.view.DemitirFuncionarioView;

/**
 *
 * @author 104933
 */
public class FuncionarioBean {

    private int idFuncionario, idadefuncionario;
    private String nomeFuncionario, sobrenomeFuncionario, sexoFuncionario, naturalidadeFuncionario, cargoFuncionario, salariofuncionario;

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idadefuncionario
     */
    public int getIdadefuncionario() {
        return idadefuncionario;
    }

    /**
     * @param idadefuncionario the idadefuncionario to set
     */
    public void setIdadefuncionario(int idadefuncionario) {
        this.idadefuncionario = idadefuncionario;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the sobrenomeFuncionario
     */
    public String getSobrenomeFuncionario() {
        return sobrenomeFuncionario;
    }

    /**
     * @param sobrenomeFuncionario the sobrenomeFuncionario to set
     */
    public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
        this.sobrenomeFuncionario = sobrenomeFuncionario;
    }

    /**
     * @return the sexoFuncionario
     */
    public String getSexoFuncionario() {
        return sexoFuncionario;
    }

    /**
     * @param sexoFuncionario the sexoFuncionario to set
     */
    public void setSexoFuncionario(String sexoFuncionario) {
        this.sexoFuncionario = sexoFuncionario;
    }

    /**
     * @return the naturalidadeFuncionario
     */
    public String getNaturalidadeFuncionario() {
        return naturalidadeFuncionario;
    }

    /**
     * @param naturalidadeFuncionario the naturalidadeFuncionario to set
     */
    public void setNaturalidadeFuncionario(String naturalidadeFuncionario) {
        this.naturalidadeFuncionario = naturalidadeFuncionario;
    }

    /**
     * @return the cargoFuncionario
     */
    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    /**
     * @param cargoFuncionario the cargoFuncionario to set
     */
    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    /**
     * @return the salariofuncionario
     */
    public String getSalariofuncionario() {
        return salariofuncionario;
    }

    /**
     * @param salariofuncionario the salariofuncionario to set
     */
    public void setSalariofuncionario(String salariofuncionario) {
        this.salariofuncionario = salariofuncionario;
    }

    //Converter nome completo do funcionario para String
    public String toString() {
        return nomeFuncionario + " " + sobrenomeFuncionario;
    }

    public void gerarSalario() {

        if (cargoFuncionario.equals("Atendente")) {
            salariofuncionario = "R$ 1800,00";
        } else if (cargoFuncionario.equals("Gar�om/Gar�onete")) {
            salariofuncionario = "R$ 1200,00";
        } else if (cargoFuncionario.equals("Padeiro(a)")) {
            salariofuncionario = "R$ 2000,00";
        } else {
            salariofuncionario = "R$ 1000,00";
        }

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
    // Validar sobrenome
    public static boolean validaSobrenome(String sobrenome) {
        if (sobrenome.isEmpty()) {
            return false;
        }
        return true;

    }

    // -----------------------------------------------------------------------------------------------------
    // Validar valor
    public static boolean validaIdade(String idade) {
        int idadeInt;
        try {
            idadeInt = Integer.parseInt(idade);
        } catch (Exception e) {

            return false;
        }
        if ((idadeInt < 16) || (idadeInt > 80)) {
            return false;
        }
        return true;

    }

    public static void demitirFuncionario() {

        for (int i = 0; i < new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().size(); i++) {

            if (DemitirFuncionarioView.funcionarioSelecionado
                    .equals(new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().get(i).getNomeFuncionario() + " " + new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().get(i).getSobrenomeFuncionario())) {

                new FuncionarioDao().EnviarNomeESobrenomeParaArrayList().remove(i);

            }

        }

    }
}
