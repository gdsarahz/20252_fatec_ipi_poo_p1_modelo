package br.gov.sp.cps.fatecipiranga.model;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Terrorista {
    private String nome;
    private int energia = 10;
    private int quantidadeGranadas = 5;
    private String armamento;
    private Bomba bombaArmada;
    private List<String> historicoAtaques;

    private Faca faca = new Faca();
    private Pistola pistola = new Pistola();
    private Fuzil fuzil = new Fuzil();
    private Random random = new Random();

    public Terrorista(String nome, int energia, int quantidadeGranadas, String armamento, Bomba bombaArmada) {
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
        this.bombaArmada = bombaArmada;
        this.historicoAtaques = new ArrayList<>();

    }

    public void PlantarBomba(String nomeMapa) {
        bombaArmada.setBombaArmada(true);
        System.out.println("Terrorista: " + nome + " plantando a bomba em " + nomeMapa + "...");

    }

    public void lancarGranada(Policial Policial, String nomeMapa) {
        int energiaPolicial = Policial.getEnergia();

        if (energiaPolicial <= 0) {
            System.out.println("Policial: " + nome + " morreu...");
            return;
        }

        if (quantidadeGranadas >= 1) {
            System.out.println("Terrorista: " + nome + " lançando granada em " + nomeMapa + " ...");
            quantidadeGranadas--;
            Policial.setDano(4);
        } else {
            System.out.println("Terrorista: " + nome + " Sem granada...");
        }

    }

    public void atacar(Policial Policial, String nomeMapa) {
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

        System.out.println("Terrorista: " + nome + " atacando com " + armamento + " em " + nomeMapa + " ...");

        if (Policial.getEnergia() > 0) {
            Policial.setDano(dano);
        } else {
            System.out.println("Policial: " + nome + " morreu...");
            return;
        }
    }

    public void passarVez() {
        System.out.println("Terrorista: " + nome + " passando a vez...");

    }

    public void setDano(int energia) {
        if (this.energia > 0) {
            this.energia -= energia;
            if (this.energia > 0) {
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Terrorista: " + nome + " Levou dano!!" + " Energia atual " + this.energia);

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
            System.out.println("Terrorista " + nome + " Ganhou " + energia + " de energia " + " energia atual " + this.energia);

        }

    }

}
