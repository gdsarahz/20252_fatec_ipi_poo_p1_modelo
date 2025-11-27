package br.gov.sp.cps.fatecipiranga.db;

import java.sql.PreparedStatement;
import br.gov.sp.cps.fatecipiranga.model.Historico;
import java.sql.Connection;

public class HistoricoDAO{
  private ConnectionFactory factory = new ConnectionFactory();

  public void cadastrar(Historico h) throws Exception{
    var sql = "INSERT INTO historico(nome, armamento, quantidade) VALUES(?, ?, ?)";
    Connection conexao = null;
    PreparedStatement ps = null;

    try{
      conexao = factory.obtemConexao();
      if(conexao == null){
        throw new Exception("Erro ao conectar com o BD.");
      }

    ps = conexao.prepareStatement(sql);
    ps.setString(1, h.getNome());
    ps.setString(2, h.getArmamento());
    ps.setInt(3, h.getQuantidade());
    ps.execute();
    System.out.println("Rodada salva!\n"+h.getNome()+" usou "+h.getArmamento()+" "+h.getQuantidade()+" vezes.");
    }
    catch(Exception e){
      System.out.println("Erro ao cadastrar as rodadas no BD.");
      e.printStackTrace();
      throw e;
    }
    finally{
      if(ps != null){
      ps.close();
      }
      if (conexao != null){
      conexao.close();
      }
  } 
}
}

