package br.gov.sp.cps.fatecipiranga.model;
import lombok.Getter;

@Getter
public class Pistola {

    private int danoPistola = 2;
    private final String nomeArma = "pistola";

    public int atacar () {
        return danoPistola;
    }
 
}