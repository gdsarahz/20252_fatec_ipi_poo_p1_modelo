public class Policial {
    private String nome;
    private int energia = 10;
    private int quantidadeGranadas = 5;
    private String armamento;
    private Bomba bombaDesarmada;

    Policial (String nome, int energia, int quantidadeGranadas,String armamento,Bomba bombaDesarmada) {
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


    void desarmarBomba() {
        bombaDesarmada.setBombaDesarmada(true);
        System.out.println("Policial: " + nome + " desarmando a bomba...");

    }
    void lancarGranada() {
        if (quantidadeGranadas >= 1)  {
            System.out.println("Policial: " + nome + " lançando granada...");
            quantidadeGranadas--;
        }
        else{
            System.out.println("Policial: " +nome+ " Sem granada...");
        }
        

    }
    
    void atacar() {
        System.out.println("Policial: " + nome + " atacando com " + armamento + "...");

    }

    void passarVez () {
        System.out.println("Policial: " + nome + " passando a vez...");

    }
    public void setDano(int energia){
        if(this.energia > 0){
            this.energia -= energia;
            if(this.energia > 0){
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Policial: " + nome + " Levou dano!!" + " Energia atual " + this.energia);
              
            }
            if(this.energia < 0){
                this.energia = 0;
            }
        }
    }
    public String getArmamento(){
        return armamento;
    }
    public int getEnergia(){
        return energia;
    }

    public void setEnergia(int energia){
        this.energia += energia;
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("Policial " + nome + " Ganhou " + energia + " de energia");
        
    }

  
}