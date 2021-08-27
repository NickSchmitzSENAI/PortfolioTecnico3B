/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soldado;

/**
 *
 * @author SESI_SENAI
 */
public class Armamento {
    private int cod_arma;
    private String modelo;
    private String fabricante;
    private int quantidade;
    private int cod_cargo;
    
    public Armamento() {
    }
    
    
    public Armamento(int cod_arma,String modelo, String fabricante, int quantidade, int cod_cargo){
            this.cod_arma = cod_arma;
            this.modelo = modelo;
            this.fabricante = fabricante;
            this.quantidade = quantidade;
            this.cod_cargo = cod_cargo;
                    
}

    public int getCod_arma() {
        return cod_arma;
    }

    public void setCod_arma(int cod_arma) {
        this.cod_arma = cod_arma;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    
    
}