package br.gov.sp.cps.fatecipiranga.model;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Policial {
    private String nome;
    private int energia = 10;
    private int quantidadeGranadas = 5;
    private String armamento;
    private Bomba bombaDesarmada;
    private List<String> historicoAtaques;

    private Faca faca = new Faca();
    private Pistola pistola = new Pistola();
    private Fuzil fuzil = new Fuzil();
    private Random random = new Random();

    public Policial(String nome, int energia, int quantidadeGranadas, String armamento, Bomba bombaDesarmada) {
        if (nome != null && nome.length() >= 4) {
            this.nome = nome;

        }
        if (energia >= 0 && energia <= 10) {
            this.energia = energia;
        }
        if (quantidadeGranadas >= 0 && quantidadeGranadas <= 5) {
            this.quantidadeGranadas = quantidadeGranadas;
        }
        if (armamento.equalsIgnoreCase("Faca") || armamento.equalsIgnoreCase("Fuzil")
                || armamento.equalsIgnoreCase("Pistola")) {
            this.armamento = armamento;
        }
        this.bombaDesarmada = bombaDesarmada;
        this .historicoAtaques = new ArrayList<>();

    }

    public void desarmarBomba(String nomeMapa) {
        bombaDesarmada.setBombaDesarmada(true);
        System.out.println("Policial: " + nome + " desarmando a bomba em " + nomeMapa + "...");

    }

    public void lancarGranada(Terrorista Terrorista, String nomeMapa) {
        int energiaTerrorista = Terrorista.getEnergia();
        if (energiaTerrorista <= 0) {
            System.out.println("Terrorista: " + nome + " morreu...");
            return;
        }

        if (quantidadeGranadas >= 1) {
            System.out.println("Policial: " + nome + " lançando granada em " + nomeMapa + "...");
            quantidadeGranadas--;
            Terrorista.setDano(4);
        } else {
            System.out.println("Policial: " + nome + " Sem granada...");
        }

    }

    public void atacar(Terrorista Terrorista, String nomeMapa) {
        int dano = 0;
        int escolha = random.nextInt(3) + 1;

        switch (escolha) {
            case 1: 
                this.armamento = faca.getNomeArma();
                dano = faca.atacar();
                break;
            case 2:
                this.armamento = pistola.getNomeArma();
                dano = pistola.atacar();
                break;
            case 3: 
                this.armamento = fuzil.getNomeArma();
                dano = fuzil.atacar();
                break;
        }

        historicoAtaques.add(this.armamento);

        System.out.println("Policial: " + nome + " atacando com " + armamento + " em " + nomeMapa + "...");

        if (Terrorista.getEnergia() > 0) {
            Terrorista.setDano(dano);
        }
        else{
            System.out.println("Terrorista: "+Terrorista.getNome()+" morreu...");
        }
    }

    public void passarVez() {
        System.out.println("Policial: " + nome + " passando a vez...");

    }

    public void setDano(int energia) {
        if (this.energia > 0) {
            this.energia -= energia;
            if (this.energia > 0) {
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Policial: " + nome + " Levou dano!!" + " Energia atual " + this.energia);

            }
            if (this.energia < 0) {
                this.energia = 0;
            }
        }
    }

    public List<String> getHistoricoAtaques(){
        return historicoAtaques;
    }

    public String getNome(){
        return nome;
    }

    public String getArmamento() {
        return armamento;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        
        if (this.energia > 0 && this.energia < 10) {
            this.energia += energia;

            if(this.energia > 10){
                this.energia = 10;
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println("Policial " + nome + " Ganhou " + energia + " de energia " + " energia atual " + this.energia);

        }
        
    }

}