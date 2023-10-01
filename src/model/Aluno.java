package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Aluno implements Serializable {
    private Long id;
    private int matricula;
    private String nome;
    private  int faltas;
    private double [] notas;


    public Aluno() {
    }

    public Aluno(Long id, int matricula, String nome, int faltas, double[] notas) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.faltas = faltas;
        this.notas = notas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return matricula == aluno.matricula && Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", faltas=" + faltas +
                ", notas=" + Arrays.toString(notas) +
                '}';
    }
}
