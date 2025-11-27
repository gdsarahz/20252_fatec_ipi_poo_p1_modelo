package br.gov.sp.cps.fatecipiranga.model;

import lombok.Data;

@Data
public class Resultado {
    private int id;
    private String nomePersonagem;
    private String textoResultado;
    private int numeroRodada;

    public Resultado() {}

    public Resultado(String nomePersonagem, String textoResultado, int numeroRodada) {
        this.nomePersonagem = nomePersonagem;
        this.textoResultado = textoResultado;
        this.numeroRodada = numeroRodada;
    }
}