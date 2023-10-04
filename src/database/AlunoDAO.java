package database;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import avl.TreeAVL;
import model.Aluno;

public class AlunoDAO {

    public void save(Aluno aluno) {
        try (FileOutputStream fileOut = new FileOutputStream("resources\\entrada.txt", true); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(aluno);

            objectOut.close();
            fileOut.close();
            System.out.println("alunos salvos com sucesso.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TreeAVL listTreeAvl() {

        TreeAVL alunos = new TreeAVL();

        try {
            FileInputStream fileI = new FileInputStream("resources\\entrada.txt");

            while (fileI.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fileI);
                alunos.insert((Aluno) ois.readObject());

            }

            fileI.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }

    public void finallyApp(TreeAVL avl) {

        try {
            FileWriter fileWriter = new FileWriter("resources\\saida.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(avl.inOrder());

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Dados salvos no arquivo saida.txt");
        } catch (IOException e) {

            throw new RuntimeException("Error ao salvar os dados no arquivo saida.txt " + e);
        }
    }

}
