package br.gov.sp.cps.fatecipiranga.model;
import lombok.Data;

@Data
public class Historico {
    private int codigo;
    private String nome;
    private String armamento;
    private int quantidade;

    public Historico(String nome, String armamento, int quantidade){
        this(0, nome, armamento, quantidade);
    }


    public Historico(int codigo, String nome, String armamento, int quantidade){
        setCodigo(codigo);
        setNome(nome);
        setArmamento(armamento);
        setQuantidade(quantidade);
    }
    
}

