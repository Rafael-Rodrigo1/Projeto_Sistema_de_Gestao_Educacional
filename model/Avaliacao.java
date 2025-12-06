package model;

public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = 0.0; // Nota inicializada como 0.0 por padrão
    }

    public double getNota() {
        return nota;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Permitir atualização da nota apenas via método atribuirNota(valor), validando se está entre 0 e 10.
    public void atribuirNota(double valor) {
        if (valor >= 0 && valor <= 10) {
            this.nota = valor;
        } else {
            System.out.println("Nota inválida. A nota Tem que está entre 0 e 10.");
        }
    }
}
