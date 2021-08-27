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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author SESI_SENAI
 */
public class Quartel {
    private static Connection connection;
   
    public static Connection getConnection(){
        if(connection == null){
            try{
                //Class.forName("com.mysql.jdbc.Driver"); //para mysql
                Class.forName("org.postgresql.Driver");//para postgresql
                String host = "localhost";
                String port = "5432";
                String database = "postgres";
                String user = "postgres";
                String pass = "senai";//digitar a senha do seu banco
                //String url = "jdbc:mysql://"+host+":"+port+"/"+database; //para mysql
                String url = "jdbc:postgresql://"+host+":"+port+"/"+database;//para postgresql
                connection = DriverManager.getConnection(url, user, pass);                
               
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void close(){
        if (connection == null){
            throw new RuntimeException("Nenhuma conexão aberta!");
        }
        else{
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    public static void cria_tabela (String tabela, String... atributo){
        try{
            Connection con = Quartel.getConnection();
            String comando = "CREATE TABLE " + tabela + " (";
            
            for (String i : atributo){
                comando = comando + i + ",";
                
            }
            comando = comando.substring(0, comando.length()-1);
            comando = comando + ");";
            
            System.out.println(comando);
            
            PreparedStatement ps = con.prepareStatement(comando);
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    public static void salvarC (Cargo cargo){
        try{
            Connection con = Quartel.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO cargo (cod_cargo, nome, horario, funcao, classificacao) values(?, ?, ?, ?, ?)");
            ps.setInt(1, cargo.getCod_cargo());
            ps.setString(2, cargo.getNome());
            ps.setString(3, cargo.getHorario());
            ps.setString(4, cargo.getFuncao());
            ps.setInt(5, cargo.getClassificacao());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void salvarP (Pessoa pessoa){
        try{
            Connection con = Quartel.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO pessoa (endereco, nome, matricula, cod_cargo) values(?, ?, ?, ?)");
            ps.setString(1, pessoa.getEndereco());
            ps.setString(2, pessoa.getNome());
            ps.setInt(3, pessoa.getMatricula());
            ps.setInt(4, pessoa.getCod_cargo());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
     
     public static void salvarA (Armamento armamento){
        try{
            Connection con = Quartel.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO armamento (cod_arma, modelo, fabricante, quantidade, cod_cargo) values(?, ?, ?, ?, ?)");
            ps.setInt(1, armamento.getCod_arma());
            ps.setString(2, armamento.getModelo());
            ps.setString(3, armamento.getFabricante());
            ps.setInt(4, armamento.getQuantidade());
            ps.setInt(5, armamento.getCod_cargo());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    public static void visualizabanco (String tabela, String... atributos){
        try{
            Connection con = Quartel.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from " + tabela);
            ResultSet rs = ps.executeQuery();
       
            String valor = "";
            while(rs.next()){
            for (String i : atributos) {
                valor = valor + "|" + rs.getString(i);
            }
            valor = valor +"\n";
                
            }
            System.out.println(valor);
        }
        catch (SQLException e) {
            e.printStackTrace();
}
}
    
    
    
    
    
    
    
    
    
}
