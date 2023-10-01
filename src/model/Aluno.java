package model;

import java.io.Serializable;
import java.util.Arrays;

public class Aluno implements Serializable {

    private int matricula;
    private String nome;
    private  int faltas;
    private double [] notas;


    public Aluno() {
    }

    public Aluno(int matricula, String nome, int faltas, double[] notas) {

        this.matricula = matricula;
        this.nome = nome;
        this.faltas = faltas;
        this.notas = notas;
    }



    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula == aluno.matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", faltas=" + faltas +
                ", notas=" + Arrays.toString(notas) +
                '}';
    }
}
