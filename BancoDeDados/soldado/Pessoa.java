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
public class Pessoa {
    
    private String endereco;
    private String nome;
    private int matricula;
    private int cod_cargo;
    
    public Pessoa() {
    }
    
    
    public Pessoa(String endereco, String nome, int matricula, int cod_cargo){
            this.endereco = endereco;
            this.nome = nome;
            this.matricula = matricula;
            this.cod_cargo = cod_cargo;
    
}


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }
    
    
}
