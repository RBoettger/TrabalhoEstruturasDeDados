package model;

public class Aluno {
    private String nome;
    private int matricula;
    private char sexo;

    public Aluno(String nome, int matricula, char sexo) {
        this.nome = nome;
        this.matricula = matricula;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public char getSexo() {
        return sexo;
    }
}
