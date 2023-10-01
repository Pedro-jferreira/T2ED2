package configs;

import model.Aluno;
import service.AlunoTreeService;

import java.util.Random;
import java.util.Scanner;

public class CommandLineInterface {

    private  AlunoTreeService avl = new AlunoTreeService();
    private  Scanner scanner = new Scanner(System.in);

   public CommandLineInterface(){

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - buscar um aluno");
            System.out.println("3 - Apagar aluno");
            System.out.println("4 - Listar todos os alunos");
            System.out.println("5 - Recarregar a árvore");
            System.out.println("6 - gerar alunos");
            System.out.println("7 - contar alunos");
            System.out.println("8 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> inserirAluno();
                case 2 -> buscarAluno();
                case 3 -> apagarAluno();
                case 4 -> listarAlunos();
                case 5 -> recarregarArvore();
                case 6 -> gerarEInserirAlunos();
                case 7 -> avl.contarAlunos();
                case 8-> {
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void buscarAluno() {
       long startTime = System.currentTimeMillis();
        System.out.println("digite a matricula");
       avl.seartch(scanner.nextInt());
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

    private static final String[] nomesReais = {"João", "Maria", "Pedro", "Ana", "Carlos", "Lúcia", "Fernando", "Mariana", "Rafael", "Isabel"};

    public void gerarEInserirAlunos() {
        System.out.println("Quantos alunos deseja gerar?");
        int quantidade = scanner.nextInt();
        Random random = new Random();

        int proximaMatricula = 0; // Inicializa a próxima matrícula como 0000

        for (int i = 0; i < quantidade; i++) {
            // Formata a matrícula com 4 dígitos usando zeros à esquerda
            String matriculaFormatada = String.format("%04d", proximaMatricula);
            int matricula = Integer.parseInt(matriculaFormatada);

            String nome = nomesReais[random.nextInt(nomesReais.length)]; // Seleciona um nome real aleatoriamente
            int faltas = random.nextInt(21); // De 0 a 20 faltas
            double[] notas = null; // Notas nulas

            Aluno aluno = new Aluno(matricula, nome, faltas, notas);
            avl.insertAluno(aluno, true);

            // Incrementa a próxima matrícula
            proximaMatricula++;
        }}

    }
