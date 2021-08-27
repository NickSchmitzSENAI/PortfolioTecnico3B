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
public class Soldado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quartel.cria_tabela("cargo", "cod_cargo int primary key ", "nome varchar(30)", 
                "horario varchar(20)", "funcao varchar (50)", "classificacao int");
        Cargo c = new Cargo();
        c.setCod_cargo(631);
        c.setNome("cabo");
        c.setHorario("template");
        c.setFuncao("template");
        c.setClassificacao(1);
        Quartel.salvarC(c);
        
        Cargo a = new Cargo();
        a.setCod_cargo(632);
        a.setNome("capitão");
        a.setHorario("template");
        a.setFuncao("template");
        a.setClassificacao(2);
        Quartel.salvarC(a);
        
        Cargo r = new Cargo();
        r.setCod_cargo(633);
        r.setNome("major");
        r.setHorario("template");
        r.setFuncao("template");
        r.setClassificacao(3);
        Quartel.salvarC(r);
        
        Cargo g = new Cargo();
        g.setCod_cargo(634);
        g.setNome("brigadeiro");
        g.setHorario("template");
        g.setFuncao("template");
        g.setClassificacao(4);
        Quartel.salvarC(g);
        
        Cargo o = new Cargo();
        o.setCod_cargo(635);
        o.setNome("marechal");
        o.setHorario("template");
        o.setFuncao("template");
        o.setClassificacao(5);
        Quartel.salvarC(o);
        
        Quartel.visualizabanco("cargo", "cod_cargo", "nome", "horario", "funcao", 
                "classificacao");
        
        Quartel.cria_tabela("pessoa", "endereco varchar(30)", "nome varchar(30)", 
                "matricula int primary key", "cod_cargo int REFERENCES cargo(cod_cargo)");
        
        Pessoa p = new Pessoa();
        p.setEndereco("template");
        p.setNome("template");
        p.setMatricula(116);
        p.setCod_cargo(631);
        Quartel.salvarP(p);
        
        Pessoa e = new Pessoa();
        e.setEndereco("template");
        e.setNome("template");
        e.setMatricula(226);
        e.setCod_cargo(632);
        Quartel.salvarP(e);
        
        Pessoa s = new Pessoa();
        s.setEndereco("template");
        s.setNome("template");
        s.setMatricula(336);
        s.setCod_cargo(633);
        Quartel.salvarP(s);
        
        Pessoa l = new Pessoa();
        l.setEndereco("template");
        l.setNome("template");
        l.setMatricula(446);
        l.setCod_cargo(634);
        Quartel.salvarP(l);
        
        Pessoa d = new Pessoa();
        d.setEndereco("template");
        d.setNome("template");
        d.setMatricula(556);
        d.setCod_cargo(635);
        Quartel.salvarP(d);
        
        Quartel.visualizabanco("pessoa", "endereco", "nome", "matricula", "cod_cargo");
        
        Quartel.cria_tabela("armamento", "cod_arma int primary key", "modelo varchar(30)", 
                "fabricante varchar(30)", "quantidade int", "cod_cargo int REFERENCES cargo(cod_cargo)");
        Armamento m = new Armamento();
        m.setCod_arma(11);
        m.setModelo("cabo");
        m.setFabricante("template");
        m.setQuantidade(1000);
        m.setCod_cargo(631);
        Quartel.salvarA(m);
        
        Armamento n = new Armamento();
        n.setCod_arma(12);
        n.setModelo("cabo");
        n.setFabricante("template");
        n.setQuantidade(1000);
        n.setCod_cargo(631);
        Quartel.salvarA(n);
        
        Armamento t = new Armamento();
        t.setCod_arma(13);
        t.setModelo("cabo");
        t.setFabricante("template");
        t.setQuantidade(1000);
        t.setCod_cargo(631);
        Quartel.salvarA(t);
        
        Armamento f = new Armamento();
        f.setCod_arma(14);
        f.setModelo("cabo");
        f.setFabricante("template");
        f.setQuantidade(1000);
        f.setCod_cargo(631);
        Quartel.salvarA(f);
        
        Armamento u = new Armamento();
        u.setCod_arma(15);
        u.setModelo("cabo");
        u.setFabricante("template");
        u.setQuantidade(1000);
        u.setCod_cargo(631);
        Quartel.salvarA(u);
        
        Quartel.visualizabanco("armamento", "cod_arma", "modelo", "fabricante", "quantidade", 
                "cod_cargo");
    }
    
}
