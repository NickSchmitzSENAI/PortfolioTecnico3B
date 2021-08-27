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
public class Cargo{
    
    int cod_cargo;
    String nome;
    String horario;
    String funcao;
    int classificacao;

    public Cargo() {
    }
    
    
    
    public Cargo(int cod_cargo, String nome, String horario, String funcao, int classificacao){
            this.cod_cargo = cod_cargo;
            this.nome = nome;
            this.horario = horario;
            this.funcao = funcao;
            this.classificacao = classificacao;
    
}

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
    
    
    
    
    
}