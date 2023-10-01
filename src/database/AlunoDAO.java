package database;

import avl.Node;
import avl.TreeAVL;
import model.Aluno;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


public class AlunoDAO {
    private  String src = "resources\\entrada.txt";

    public void Save(Aluno aluno) {
        try (FileOutputStream fileOut = new FileOutputStream(src, true);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(aluno);
objectOut.close();
            fileOut.close();
            System.out.println("Objetos salvos com sucesso.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(TreeAVL avl) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resources\\temp.txt"))) {
            deleteInOrder(avl.getRoot(), oos);

            System.out.println("Alunos salvos com sucesso no arquivo 'resources\\temp.txt'");
            oos.close();
            replaceFiles();
        } catch (IOException e) {
            System.err.println("Erro ao salvar os alunos no arquivo: " + e.getMessage());
        }
    }

    private void deleteInOrder(Node node, ObjectOutputStream oos) throws IOException {
        if (node != null) {
            deleteInOrder(node.getNodeLeft(), oos);
            oos.writeObject(node.getAluno());
            deleteInOrder(node.getNodeRight(), oos);
        }
    }

    public TreeAVL List() {

        TreeAVL alunos = new TreeAVL();


        try {
            FileInputStream fileI = new FileInputStream(src);

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
    public void replaceFiles() {
        Path entradaFilePath = Path.of("resources\\entrada.txt");
        Path tempFilePath = Path.of("resources\\temp.txt");

        try {
            // Verifica se o arquivo de entrada existe e o apaga, se necessário
            if (Files.exists(entradaFilePath)) {
                Files.delete(entradaFilePath);
                System.out.println("Arquivo 'resources\\entrada.txt' apagado com sucesso.");
            }else System.out.println("não foi possivel apagar");

            // Renomeia o arquivo temporário para o arquivo de entrada
            Files.move(tempFilePath, entradaFilePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo 'resources\\temp.txt' renomeado para 'resources\\entrada.txt'.");
        } catch (IOException e) {
            System.err.println("Erro ao substituir os arquivos: " + e.getMessage());
        }
    }



    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}


