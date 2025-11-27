package br.gov.sp.cps.fatecipiranga.model;
import lombok.Getter;

@Getter
public class Fuzil {
    
    private int danoFuzil = 3;
    private final String nomeArma = "fuzil";

    public int atacar () {
        return danoFuzil;

    }

}
