package br.ufpe.cin.gdi.conectividade.dados.repositorios;

import java.sql.Connection;
import java.sql.*;

public class Conexao {
        
        private final String ipServidor = "itapissuma.cin.ufpe.br";
        private final String portaServidor = "1521";
        private final String nomeBD = "dbdisc";
        private final String usuarioBD = "g132if685cc_eq02";
        private final String senhaBD = "eydfajul6";
        
        private Connection con;
        
        public void conectarBD() throws ClassNotFoundException, SQLException{
                
                // driver de acesso ao SGBD Oracle:
                Class.forName("oracle.jdbc.driver.OracleDriver");
                
                //configurando a conexão com o banco de dados:
                Connection con = DriverManager.getConnection(this.toString(),this.usuarioBD,this.senhaBD);
                
                this.con = con;
        }

        public void desconectarBD() throws SQLException{
                this.con.close();
        }
        
        public String toString(){
                // String de conexão
                return "jdbc:oracle:thin:@//" + this.ipServidor +":"+ this.portaServidor + "/" + this.nomeBD; 
        }

        public Connection getCon() {
                return con;
        }       
        
}

