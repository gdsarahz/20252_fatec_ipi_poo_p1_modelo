import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        var gerandor = new Random();
        var bomba = new Bomba();
        var t1 = new Terrorista("Gabriel", 4, 4, "Pistola",bomba); 
        var p2 = new Policial("Hank", 7, 5, "Pistola",bomba);
        var p1 = new Policial("Igor", 5, 2, "Fuzil",bomba); 
        
     
        
        // loop do jogo
        while (true) {
            var acaoTerrorista = gerandor.nextInt(4) + 1;
            var movimentaPrimeiro = 1 + gerandor.nextInt(4);
            var ganhoEnergia = 1 + gerandor.nextInt(2);
            if (movimentaPrimeiro == 1 || movimentaPrimeiro == 3) {
                System.out.println("Terrorista faz a primeira ação");
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                switch (acaoTerrorista) {
                    case 1:
                        if(t1.getEnergia() > 0){
                            t1.PlantarBomba();
                        }
                        break;
                    case 2:
                        if(t1.getEnergia() > 0){
                            t1.lancarGranada();
                            p1.setDano(4);
                        }
                        break;
                    case 3:
                        if(t1.getEnergia() > 0){
                            t1.atacar();
                            if (t1.getArmamento().equalsIgnoreCase("Faca")) {
                                p1.setDano(1);
                            }
                            if (t1.getArmamento().equalsIgnoreCase("Pistola")) {
                                p1.setDano(2);
                            }
                            if (t1.getArmamento().equalsIgnoreCase("Fuzil")) {
                                p1.setDano(3);
                            }
                        }
                        break;
                    case 4:
                        if(t1.getEnergia() > 0){
                            t1.passarVez();
                            switch (ganhoEnergia) {
                                case 1:
                                    if (p1.getEnergia() > 0 && p1.getEnergia() < 10) {
                                        p1.setEnergia(1);

                                    }
                                    break;
                                case 2:
                                    if (p1.getEnergia() == 9) {
                                        p1.setEnergia(1);

                                    } else if ((p1.getEnergia() > 0 && p1.getEnergia() < 8)) {
                                        p1.setEnergia(2);
                                    }
                                    break;

                            }
                        }
                        break;
                }
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                var acaoPolicial = gerandor.nextInt(4) + 1;
                switch (acaoPolicial) {
                    case 1:
                        if(p1.getEnergia() > 0){
                            p1.desarmarBomba();
                        }
                        break;
                    case 2:
                        if(p1.getEnergia() > 0){
                            p1.lancarGranada();
                            t1.setDano(4);
                        }
                        break;
                    case 3:
                        if(p1.getEnergia() > 0){
                            p1.atacar();
                            if (p1.getArmamento().equalsIgnoreCase("Faca")) {
                                t1.setDano(1);
                            }
                            if (p1.getArmamento().equalsIgnoreCase("Pistola")) {
                                t1.setDano(2);
                            }
                            if (p1.getArmamento().equalsIgnoreCase("Fuzil")) {
                                t1.setDano(3);
                            }
                        }
                        break;
                    case 4:
                        if(p1.getEnergia() > 0){
                            p1.passarVez();
                            switch (ganhoEnergia) {
                                case 1:
                                    if (t1.getEnergia() > 0 && t1.getEnergia() < 10) {
                                        t1.setEnergia(1);

                                    }
                                    break;
                                case 2:
                                    if (t1.getEnergia() == 9) {
                                        t1.setEnergia(1);

                                    } else if ((t1.getEnergia() > 0 && t1.getEnergia() < 8)) {
                                        t1.setEnergia(2);
                                    }
                                    break;

                            }
                        }
                        break;
                }

            }
            if (movimentaPrimeiro == 2 || movimentaPrimeiro == 4){
                System.out.println("Policial faz a primeira ação");
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                var acaoPolicial = gerandor.nextInt(4) + 1;
               switch (acaoPolicial) {
                    case 1:
                        if(p1.getEnergia() > 0){
                            p1.desarmarBomba();
                        }
                        break;
                    case 2:
                        if(p1.getEnergia() > 0){
                            p1.lancarGranada();
                            t1.setDano(4);
                        }
                        break;
                    case 3:
                        if(p1.getEnergia() > 0){
                            p1.atacar();
                            if (p1.getArmamento().equalsIgnoreCase("Faca")) {
                                t1.setDano(1);
                            }
                            if (p1.getArmamento().equalsIgnoreCase("Pistola")) {
                                t1.setDano(2);
                            }
                            if (p1.getArmamento().equalsIgnoreCase("Fuzil")) {
                                t1.setDano(3);
                            }
                        }
                        break;
                    case 4:
                        if(p1.getEnergia() > 0){
                            p1.passarVez();
                            switch (ganhoEnergia) {
                                case 1:
                                    if (t1.getEnergia() > 0 && t1.getEnergia() < 10) {
                                        t1.setEnergia(1);

                                    }
                                    break;
                                case 2:
                                    if (t1.getEnergia() == 9) {
                                        t1.setEnergia(1);

                                    } else if ((t1.getEnergia() > 0 && t1.getEnergia() < 8)) {
                                        t1.setEnergia(2);
                                    }
                                    break;

                            }
                        }
                        break;
                }
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                switch (acaoTerrorista) {
                    case 1:
                        if(t1.getEnergia() > 0){
                            t1.PlantarBomba();
                        }
                        break;
                    case 2:
                        if(t1.getEnergia() > 0){
                            t1.lancarGranada();
                            p1.setDano(4);
                        }
                        break;
                    case 3:
                        if(t1.getEnergia() > 0){
                            t1.atacar();
                            if (t1.getArmamento().equalsIgnoreCase("Faca")) {
                                p1.setDano(1);
                            }
                            if (t1.getArmamento().equalsIgnoreCase("Pistola")) {
                                p1.setDano(2);
                            }
                            if (t1.getArmamento().equalsIgnoreCase("Fuzil")) {
                                p1.setDano(3);
                            }
                        }
                        break;
                    case 4:
                        if(t1.getEnergia() > 0){
                            t1.passarVez();
                            switch (ganhoEnergia) {
                                case 1:
                                    if (p1.getEnergia() > 0 && p1.getEnergia() < 10) {
                                        p1.setEnergia(1);

                                    }
                                    break;
                                case 2:
                                    if (p1.getEnergia() == 9) {
                                        p1.setEnergia(1);

                                    } else if ((p1.getEnergia() > 0 && p1.getEnergia() < 8)) {
                                        p1.setEnergia(2);
                                    }
                                    break;

                            }
                        }
                        break;
                }
            }

            if(bomba.isPlantada() && !bomba.isDesarmada()){
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Bomba explodiu! Terrorista venceu");
                break;
            } else if(bomba.isPlantada() && bomba.isDesarmada()){
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Bomba desarmada! Policial venceu");
                break;
            }

            if(p1.getEnergia() == 0 && t1.getEnergia() > 0){
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Policial morreu.");
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Terrorista ganhou o jogo");
                break;
            }
           
            if(p1.getEnergia() > 0 && t1.getEnergia() == 0){
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Terrorista morreu.");
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("Policial ganhou o jogo");
                break;
            }



            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            Thread.sleep(2000);

        }
    }
}
