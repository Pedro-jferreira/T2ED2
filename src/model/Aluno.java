package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

public class Aluno implements Serializable {

    private int matricula;
    private String nome;
    private int faltas;
    private Double[] notas;

    public Aluno() {
    }

    public Aluno(int matricula, String nome, int faltas, Double[] notas) {

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

    public Double[] getNotas() {
        return notas;
    }

    public void setNotas(Double[] notas) {
        this.notas = notas;
    }

    public Double getMedia() {
        return Double.parseDouble(new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US))
                .format((getNotas()[0] * 0.2) + (getNotas()[1] * 0.35) + (getNotas()[2] * 0.45)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Aluno aluno = (Aluno) o;
        return matricula == aluno.matricula;
    }

    @Override
    public String toString() {
        return matricula + ","+
                nome + ","+
                faltas  + ","+
                Arrays.toString(notas).replaceAll("\\[|\\]|\\s", "");
    }

}
