public class Terrorista {
    private String nome;
    private int energia = 10;
    private int quantidadeGranadas = 5;
    private String armamento;
    private Bomba bombaArmada;

    Terrorista(String nome, int energia, int quantidadeGranadas, String armamento, Bomba bombaArmada) {
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
        if (armamento.equals("Faca")) {
            dano = 1;
        } else if (armamento.equals("Fuzil")) {
            dano = 2;
        } else if (armamento.equals("Pistola")) {
            dano = 3;
        }
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

    public String getArmamento() {
        return armamento;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia += energia;
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("Terrorista " + nome + " Ganhou " + energia + " de energia");

    }

}