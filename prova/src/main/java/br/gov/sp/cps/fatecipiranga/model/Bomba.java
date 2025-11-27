package br.gov.sp.cps.fatecipiranga.model;

public class Bomba {
    private Boolean bombaArmada;
    private Boolean bombaDesarmada;

    public Bomba() {
        this.bombaArmada = false;
        this.bombaDesarmada = false;
    }

    public Boolean isPlantada() {
        return bombaArmada;
    }

    public void setBombaArmada(Boolean bombaArmada) {
        this.bombaArmada = bombaArmada;
    }

    public Boolean isDesarmada() {
        return bombaDesarmada;
    }

    public void setBombaDesarmada(Boolean bombaDesarmada) {
        this.bombaDesarmada = bombaDesarmada;
    }
}