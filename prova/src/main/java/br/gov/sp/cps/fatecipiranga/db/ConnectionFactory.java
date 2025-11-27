package br.gov.sp.cps.fatecipiranga.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario = "avnadmin";
    private String senha = "";
    private String host = "p2-poo-server-252-sabrinaduarte2003.e.aivencloud.com";
    private String porta = "18326";
    private String bd = "defaultdb";

        public Connection obtemConexao(){
            try{
                Connection c = DriverManager.getConnection("jdbc:postgresql://"+host+":"+porta+"/"+bd,usuario,senha);
                System.out.println("Conexão com o BD feita com sucesso.");
                return c;
            }
            catch (Exception e){
                System.out.println("Erro ao conectar com o BD");
                e.printStackTrace();
                return null;
            }
        }

}
