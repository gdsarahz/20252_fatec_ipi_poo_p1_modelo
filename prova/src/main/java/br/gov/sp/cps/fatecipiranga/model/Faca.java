package br.gov.sp.cps.fatecipiranga.model;
import lombok.Getter;

@Getter
public class Faca {

    private int danoFaca = 1;
    private final String nomeArma = "faca";

    public int atacar () {
        return danoFaca;

    }
    
}
