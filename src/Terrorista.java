public class Terrorista{
    private String nome;
    private int energia = 10;
    private int quantidadeGranadas = 5;
    private String armamento;



    
    Terrorista (String nome,int energia, int quantidadeGranadas,String armamento) {
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

    }

    
    void PlantarBomba() {
        System.out.println("Terrorista: " + nome + " plantando a bomba...");
        

    }
    void lancarGranada() {
        if (quantidadeGranadas >= 1)  {
            System.out.println("Terrorista: " + nome + " lançando granada...");
            quantidadeGranadas--;
        }
        else {
            System.out.println("Terrorista: " + nome + " Sem granada...");
        }
        

    }
    void atacar() {
        System.out.println("Terrorista: " + nome +" atacando com " + armamento + "...");

    }

    void passarVez () {
        System.out.println("Terrorista: " + nome +  " passando a vez...");

    }



  
}