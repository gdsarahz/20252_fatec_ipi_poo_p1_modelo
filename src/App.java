import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        var gerandor = new Random();
        var t1 = new Terrorista("Gabriel", 7, 4, "Pistola"); 
        var p1 = new Policial("Igor", 8, 2, "Fuzil"); 
        //loop do jogo
        while(true){
            var acaoTerrorista = gerandor.nextInt (4) + 1;
            switch (acaoTerrorista) {
                case 1: 
                    t1.PlantarBomba();
                    break;
                case 2: 
                    t1.lancarGranada();
                    break;
                case 3:
                    t1.atacar();
                    break;
                case 4:
                    t1.passarVez();
                    break;
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++");

            var acaoPolicial = gerandor.nextInt (4) + 1;
            switch (acaoPolicial) {
                case 1: 
                    p1.desarmarBomba();
                    break;
                case 2: 
                    p1.lancarGranada();
                    break;
                case 3:
                    p1.atacar();
                    break;
                case 4:
                    p1.passarVez();
                    break;
            }

            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            Thread.sleep(2000);




            


            
        }
    }
}
