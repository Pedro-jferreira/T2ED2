package configs;

import model.Aluno;
import service.AlunoTreeService;

import java.util.Scanner;

public class CommandLineInterface {

    private  AlunoTreeService avl = new AlunoTreeService();
    private  Scanner scanner = new Scanner(System.in);

   public CommandLineInterface(){

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - Apagar aluno");
            System.out.println("3 - Listar todos os alunos");
            System.out.println("4 - Recarregar a árvore");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> inserirAluno();
                case 2 -> apagarAluno();
                case 3 -> listarAlunos();
                case 4 -> recarregarArvore();
                case 5 -> {
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private   void inserirAluno() {
        System.out.println("Digite a matrícula do aluno:");
        int matricula = scanner.nextInt();
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.next();
        System.out.println("Digite o total de  faltas do aluno:");
        int faltas = scanner.nextInt();
        Aluno aluno = new Aluno(matricula,nome,faltas,null);
        avl.insertAluno(aluno,true);
        System.out.println("Aluno inserido com sucesso.");
    }

    private  void apagarAluno() {
        System.out.println("Digite a matrícula do aluno a ser apagado:");
        int matricula = scanner.nextInt();
        avl.deleteAlunoByMatricula(matricula,true);

    }

    private  void listarAlunos() {
        avl.ListarAlunos();
    }

    private  void recarregarArvore() {
        avl.refreshTree();
        System.out.println("Árvore recarregada com sucesso.");
    }
}
