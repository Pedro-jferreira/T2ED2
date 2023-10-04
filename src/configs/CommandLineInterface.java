package configs;

import model.Aluno;
import service.AlunoTreeService;

import java.util.Random;
import java.util.Scanner;

import database.AlunoDAO;

public class CommandLineInterface {

    private final AlunoTreeService avl;
    private final Scanner scanner = new Scanner(System.in);
    private int maiorMatricula = 0;

   public CommandLineInterface(AlunoTreeService avl){
    this.avl=avl;

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - buscar um aluno");
            System.out.println("3 - atualizar aluno");
            System.out.println("4 - Apagar aluno");
            System.out.println("5 - Listar todos os alunos");
            System.out.println("6 - Recarregar a árvore");
            System.out.println("7 - gerar alunos");
            System.out.println("8 - contar alunos");
            System.out.println("9 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> inserirAluno();
                case 2 -> buscarAluno();
                case 3 -> atualizarAluno();
                case 4 -> apagarAluno();
                case 5 -> listarAlunos();
                case 6 -> recarregarArvore();
                case 7 -> gerarEInserirAlunos();
                case 8 -> avl.treeCount();
                case 9-> {
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void atualizarAluno() {
        System.out.println("Digite a matrícula do aluno:");
        int matricula = scanner.nextInt();
        if ( avl.searchByMatricula(matricula)){
            System.out.println("atualize as informações do aluno");
            System.out.println("Digite o nome do aluno:");
            String nome = scanner.next();
            System.out.println("Digite o total de  faltas do aluno:");
            int faltas = scanner.nextInt();
            Aluno aluno = new Aluno(matricula,nome,faltas,null);
            avl.updateAlunoByMatricula(matricula,aluno);
            System.out.println("Aluno atualizado com sucesso.");
        }

    }

    private void buscarAluno() {
       long startTime = System.currentTimeMillis();
        System.out.println("digite a matricula");
       avl.searchByMatricula(scanner.nextInt());
        // Obtenha o tempo final
        long endTime = System.currentTimeMillis();

// Calcule o tempo decorrido em milissegundos
        long tempoDecorrido = endTime - startTime;

// Exiba o tempo decorrido
        System.out.println("Tempo decorrido (em milissegundos): " + tempoDecorrido);
    }

    private   void inserirAluno() {
        System.out.println("Digite a matrícula do aluno:");
        int matricula = scanner.nextInt();
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.next();
        System.out.println("Digite o total de  faltas do aluno:");
        int faltas = scanner.nextInt();
        Aluno aluno = new Aluno(matricula,nome,faltas,null);
        avl.insertAluno(aluno);
        System.out.println("Aluno inserido com sucesso.");
    }

    private  void apagarAluno() {
        System.out.println("Digite a matrícula do aluno a ser apagado:");
        int matricula = scanner.nextInt();
        avl.deleteAlunoByMatricula(matricula);

    }

    private  void listarAlunos() {
        avl.displayTree();
    }

    private  void recarregarArvore() {
        avl.refreshTree();
        System.out.println("Árvore recarregada com sucesso.");
    }

    private static final String[] nomesReais = {"João", "Maria", "Pedro", "Ana", "Carlos", "Lúcia", "Fernando", "Mariana", "Rafael", "Isabel"};

    public void gerarEInserirAlunos() {
        System.out.println("Quantos alunos deseja gerar?");
        int quantidade = scanner.nextInt();
        Random random = new Random();

      

        for (int i = 0; i < quantidade; i++) {
             maiorMatricula++;

            String matriculaFormatada = String.format("%04d", maiorMatricula);
            int matricula = Integer.parseInt(matriculaFormatada);

            String nome = nomesReais[random.nextInt(nomesReais.length)];
            int faltas = random.nextInt(21);

            Aluno aluno = new Aluno(matricula, nome, faltas, new Double[]{8.5,6.7,10.0});
            new AlunoDAO().save(aluno);
           
        }
    }



    }
