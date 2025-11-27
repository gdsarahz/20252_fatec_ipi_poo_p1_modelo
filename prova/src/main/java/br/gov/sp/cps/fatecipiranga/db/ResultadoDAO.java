package br.gov.sp.cps.fatecipiranga.db;

import java.sql.PreparedStatement;
import br.gov.sp.cps.fatecipiranga.model.Resultado;
import java.sql.Connection;

public class ResultadoDAO {
    
    public void inserir(Resultado r) {
        String sql = "INSERT INTO rodadas (nome_personagem, resultado_rodada, numero_rodada) VALUES (?, ?, ?)";

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, r.getNomePersonagem());
            ps.setString(2, r.getTextoResultado());
            ps.setInt(3, r.getNumeroRodada());

            ps.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}