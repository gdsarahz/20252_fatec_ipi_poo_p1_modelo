package br.gov.sp.cps.fatecipiranga;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import br.gov.sp.cps.fatecipiranga.db.HistoricoDAO;
import br.gov.sp.cps.fatecipiranga.db.ResultadoDAO;
import br.gov.sp.cps.fatecipiranga.model.Bomba;
import br.gov.sp.cps.fatecipiranga.model.Historico;
import br.gov.sp.cps.fatecipiranga.model.Policial;
import br.gov.sp.cps.fatecipiranga.model.Resultado;
import br.gov.sp.cps.fatecipiranga.model.Terrorista;
import lombok.Data;

@Data
public class App {

    private static void contadorArmaPolicial(Policial policial){
        int facaCont = 0;
        int pistolaCont = 0;
        int fuzilCont = 0;

        List<String> ataques = policial.getHistoricoAtaques();
        HistoricoDAO dao = new HistoricoDAO();

        for(String arma : ataques){
            if("faca".equals(arma)){
                facaCont++;
            }
            else if("pistola".equals(arma)){
                pistolaCont++;
            }
            else if("fuzil".equals(arma)){
                fuzilCont++;
            }
        }

        try{
            String nomePersonagem = policial.getNome();
            if(facaCont > 0){
                dao.cadastrar(new Historico(nomePersonagem, "faca", facaCont));
            }
            if(pistolaCont > 0){
                dao.cadastrar(new Historico(nomePersonagem, "pistola", pistolaCont));
            }
            if(fuzilCont > 0){
                dao.cadastrar(new Historico(nomePersonagem, "fuzil", fuzilCont));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar historico do policial."+e.getMessage());
        }
    }

    private static void contadorArmaTerrorista(Terrorista terrorista){
        int facaCont = 0;
        int fuzilCont = 0;
        int pistolaCont = 0;

        List<String>ataques = terrorista.getHistoricoAtaques();
        HistoricoDAO dao = new HistoricoDAO();

        for (String arma : ataques){
            if("faca".equals(arma)){
                facaCont++;
            }
            else if("fuzil".equals(arma)){
                fuzilCont++;
            }
            else if("pistola".equals(arma)){
                pistolaCont++;
            }
        }
        
        try{
            String nomePersonagem = terrorista.getNome();
            if (facaCont > 0){
                dao.cadastrar(new Historico(nomePersonagem, "faca", facaCont));
            }
            else if(fuzilCont > 0){
                dao.cadastrar(new Historico(nomePersonagem, "fuzil", fuzilCont));
            }
            else if(pistolaCont > 0){
                dao.cadastrar(new Historico(nomePersonagem, "pistola", pistolaCont));
            }
        }
        catch (Exception e){
            System.out.println("Erro ao salvar o historico do terrorista."+e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        var gerador = new Random();
        int rodadas = 0;
            
        while (rodadas <= 0 || rodadas >= 20 || rodadas % 2 == 0)
            rodadas = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de rodadas (deve ser um numero impar de 1 a 20): "));

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
            System.out.println("********************************************");
            System.out.println("\nRodada "+aux+"/"+rodadas);
            System.out.println("********************************************");
            Bomba bomba = new Bomba();
            var t1 = new Terrorista("Gabriel", 10, 4, "", bomba);
            var p1 = new Policial("Igor", 10, 2, "", bomba);
            String vencedorDaRodada = "";

            while (true) {
                var acaoTerrorista = gerador.nextInt(4) + 1;
                var movimentaPrimeiro = 1 + gerador.nextInt(4);
                var ganhoEnergia = 1 + gerador.nextInt(2);
                
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
                                 if(ganhoEnergia == 2 && p1.getEnergia() == 9){
                                    p1.setEnergia(1);
                                }
                                else{
                                    p1.setEnergia(ganhoEnergia);
                                }
                            }
                            break;
                    }
                    Thread.sleep(2000);
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    var acaoPolicial = gerador.nextInt(4) + 1;
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
                                if(ganhoEnergia == 2 && t1.getEnergia() == 9){
                                    t1.setEnergia(1);
                                }
                                else{
                                    t1.setEnergia(ganhoEnergia);
                                }
                            }
                            break;
                    }

                }
                Thread.sleep(2000);
                if (movimentaPrimeiro == 2 || movimentaPrimeiro == 4) {
                    System.out.println("Policial faz a primeira ação");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    var acaoPolicial = gerador.nextInt(4) + 1;
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
                                if(ganhoEnergia == 2 && t1.getEnergia() == 9){
                                    t1.setEnergia(1);
                                }
                                else{
                                    t1.setEnergia(ganhoEnergia);
                                }
                            }
                            break;
                    }
                    Thread.sleep(2000);
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
                                 if(ganhoEnergia == 2 && p1.getEnergia() == 9){
                                    p1.setEnergia(1);
                                }
                                else{
                                    p1.setEnergia(ganhoEnergia);
                                }
                            }
                            break;
                    }
                }
                Thread.sleep(2000);
              
                if (bomba.isPlantada() && !bomba.isDesarmada()) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Bomba explodiu! Terrorista venceu");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    tVitoria++;
                    vencedorDaRodada = "Terrorista";
                    contadorArmaPolicial(p1);
                    contadorArmaTerrorista(t1);
                    break;
                } else if (bomba.isPlantada() && bomba.isDesarmada()) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Bomba desarmada! Policial venceu");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    pVitoria++;
                    vencedorDaRodada = "Policial";
                    contadorArmaPolicial(p1);
                    contadorArmaTerrorista(t1);
                    break;
                }

                if (p1.getEnergia() == 0 && t1.getEnergia() > 0) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Policial morreu.");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Terrorista ganhou a rodada");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    tVitoria++;
                    vencedorDaRodada = "Terrorista";
                    contadorArmaPolicial(p1);
                    contadorArmaTerrorista(t1);
                    break;
                }

                if (p1.getEnergia() > 0 && t1.getEnergia() == 0) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Terrorista morreu.");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Policial ganhou a rodada");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++");
                    pVitoria++;
                    vencedorDaRodada = "Policial";
                    contadorArmaPolicial(p1);
                    contadorArmaTerrorista(t1);
                    break;
                }

                System.out.println("+++++++++++++++++++++++++++++++++++++++");

            }

            ResultadoDAO rdao = new ResultadoDAO();
            Resultado r = new Resultado();
            
            if (vencedorDaRodada.equals("Policial")) {
                r.setNomePersonagem("Policial");
                r.setTextoResultado("Policial ganhou, Terrorista perdeu.");
            } else {
                r.setNomePersonagem("Terrorista");
                r.setTextoResultado("Terrorista ganhou, Policial perdeu.");
            }
            
            r.setNumeroRodada(aux);
            rdao.inserir(r);

            aux++;
        }
        System.out.println("Policial: " + pVitoria + " vitorias e " + tVitoria + " derrotas\nTerrorista: " + tVitoria
                + " vitorias e " + pVitoria + " derrotas");

    }
}