import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        var gerandor = new Random();
        int rodadas;
        rodadas = Integer.parseInt(
                JOptionPane.showInputDialog("Digite o numero de rodadas (deve ser um numero impar de 1 a 20): "));
        while (rodadas <= 0 || rodadas >= 20 || rodadas % 2 == 0)
            rodadas = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o numero de rodadas (deve ser um numero impar de 1 a 20): "));

        int aux = 1;
        int pVitoria = 0;
        int tVitoria = 0;

        // mapa
        String escolheMapa = JOptionPane.showInputDialog("Escolha o mapa:\n1- Roma\n2- Fatec Ipiranga");
        String nomeMapa = null;
        if (escolheMapa != null) {
            if (escolheMapa.equals("1")) {
                nomeMapa = "Roma";
            } else if (escolheMapa.equals("2")) {
                nomeMapa = "Fatec Ipiranga";
            }

            else {
                JOptionPane.showMessageDialog(null, "Mapa inválido. Selecione novamente");
            }

        }

        // loop do jogo
        while (aux <= rodadas) {
            var bomba = new Bomba();
            var t1 = new Terrorista("Gabriel", 4, 4, "Pistola", bomba);
            var p1 = new Policial("Igor", 5, 2, "Fuzil", bomba);

            while (true) {
                var acaoTerrorista = gerandor.nextInt(4) + 1;
                var movimentaPrimeiro = 1 + gerandor.nextInt(4);
                var ganhoEnergia = 1 + gerandor.nextInt(2);
                if (movimentaPrimeiro == 1 || movimentaPrimeiro == 3) {
                    System.out.println("Terrorista faz a primeira ação");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    switch (acaoTerrorista) {
                        case 1:
                            if (t1.getEnergia() > 0) {
                                t1.PlantarBomba(nomeMapa);
                            }
                            break;
                        case 2:
                            if (t1.getEnergia() > 0) {
                                t1.lancarGranada(p1, nomeMapa);
                            }
                            break;
                        case 3:
                            if (t1.getEnergia() > 0) {
                                t1.atacar(p1, nomeMapa);
                            }
                            break;
                        case 4:
                            if (t1.getEnergia() > 0) {
                                t1.passarVez();
                                p1.setEnergia(ganhoEnergia);
                            }
                            break;
                    }
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    var acaoPolicial = gerandor.nextInt(4) + 1;
                    switch (acaoPolicial) {
                        case 1:
                            if (p1.getEnergia() > 0) {
                                p1.desarmarBomba(nomeMapa);
                            }
                            break;
                        case 2:
                            if (p1.getEnergia() > 0) {
                                p1.lancarGranada(t1, nomeMapa);
                            }
                            break;
                        case 3:
                            if (p1.getEnergia() > 0) {
                                p1.atacar(t1, nomeMapa);
                            }
                            break;
                        case 4:
                            if (p1.getEnergia() > 0) {
                                p1.passarVez();
                                t1.setEnergia(ganhoEnergia);
                            }
                            break;
                    }

                }
                if (movimentaPrimeiro == 2 || movimentaPrimeiro == 4) {
                    System.out.println("Policial faz a primeira ação");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    var acaoPolicial = gerandor.nextInt(4) + 1;
                    switch (acaoPolicial) {
                        case 1:
                            if (p1.getEnergia() > 0) {
                                p1.desarmarBomba(nomeMapa);
                            }
                            break;
                        case 2:
                            if (p1.getEnergia() > 0) {
                                p1.lancarGranada(t1, nomeMapa);
                            }
                            break;
                        case 3:
                            if (p1.getEnergia() > 0) {
                                p1.atacar(t1, nomeMapa);
                            }
                            break;
                        case 4:
                            if (p1.getEnergia() > 0) {
                                p1.passarVez();
                                t1.setEnergia(ganhoEnergia);
                            }
                            break;
                    }
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    switch (acaoTerrorista) {
                        case 1:
                            if (t1.getEnergia() > 0) {
                                t1.PlantarBomba(nomeMapa);
                            }
                            break;
                        case 2:
                            if (t1.getEnergia() > 0) {
                                t1.lancarGranada(p1, nomeMapa);
                            }
                            break;
                        case 3:
                            if (t1.getEnergia() > 0) {
                                t1.atacar(p1, nomeMapa);
                            }
                            break;
                        case 4:
                            if (t1.getEnergia() > 0) {
                                t1.passarVez();
                                p1.setEnergia(ganhoEnergia);
                            }
                            break;
                    }
                }

                if (bomba.isPlantada() && !bomba.isDesarmada()) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Bomba explodiu! Terrorista venceu");
                    tVitoria++;
                    break;
                } else if (bomba.isPlantada() && bomba.isDesarmada()) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Bomba desarmada! Policial venceu");
                    pVitoria++;
                    break;
                }

                if (p1.getEnergia() == 0 && t1.getEnergia() > 0) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Policial morreu.");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Terrorista ganhou a rodada");
                    tVitoria++;
                    break;
                }

                if (p1.getEnergia() > 0 && t1.getEnergia() == 0) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Terrorista morreu.");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Policial ganhou a rodada");
                    pVitoria++;
                    break;
                }

                System.out.println("+++++++++++++++++++++++++++++++++++++++");

            }
            Thread.sleep(2000);
            aux++;
        }
        System.out.println("Policial: " + pVitoria + " vitorias e " + tVitoria + " derrotas\nTerrorista: " + tVitoria
                + " vitorias e " + pVitoria + " derrotas");

    }
}
