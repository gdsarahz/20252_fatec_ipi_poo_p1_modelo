public class Policial {
    private String nome;
    private int energia = 10;
    private int quantidadeGranadas = 5;
    private String armamento;
    private Bomba bombaDesarmada;

    Policial(String nome, int energia, int quantidadeGranadas, String armamento, Bomba bombaDesarmada) {
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
        if (armamento.equals("Faca")) {
            dano = 1;
        }

        if (armamento.equals("Fuzil")) {
            dano = 3;
        }

        if (armamento.equals("Pistola")) {
            dano = 2;
        }
        System.out.println("Policial: " + nome + " atacando com " + armamento + " em " + nomeMapa + "...");

        if (Terrorista.getEnergia() > 0) {
            Terrorista.setDano(dano);
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