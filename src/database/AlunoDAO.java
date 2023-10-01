package database;

import model.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AlunoDAO {

    public void Save(Aluno aluno) {
        try (FileOutputStream fileOut = new FileOutputStream("src\\database\\entrada.txt", true);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(aluno);

            System.out.println("Objetos salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Aluno> List() {
        List<Aluno> objetosLidos = new ArrayList<>();

        try {
            FileInputStream fileI = new FileInputStream("src\\database\\entrada.txt");
            while (fileI.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fileI);
                objetosLidos.add((Aluno) ois.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return objetosLidos;
    }
}


