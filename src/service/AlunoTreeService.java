package service;

import java.util.List;

import avl.Node;
import avl.TreeAVL;
import database.AlunoDAO;
import model.Aluno;

public class AlunoTreeService {
    private TreeAVL alunosTree;
    private final AlunoDAO alunoDAO;

    public AlunoTreeService() {
        this.alunosTree = new TreeAVL();
        this.alunoDAO = new AlunoDAO();
    }

    public void insertAluno(Aluno aluno) {
        alunosTree.insert(aluno);

    }

    public Node searchByMatricula(int matricula) {
        Node node = alunosTree.searchByMatricula(matricula);
        if (node != null) {
            System.out.println("aluno encontrado: " + node.getAluno());
            return node;
        } else {
            System.out.println("aluno não encontrado");
            return null;
        }
    }

    public void updateAlunoByMatricula(int matricula, Aluno novoAluno) {
        getAlunosTree().updateAlunoByMatricula(matricula, novoAluno);
    }

    public void deleteAlunoByMatricula(int matricula) {
        alunosTree.deleteByMatricula(matricula);

    }

    public void displayTree() {
        getAlunosTree().displayTree();

    }

    public String inOrder(){
        return getAlunosTree().inOrder();

    }

    public List<Aluno> inOrderList(){
        return getAlunosTree().inOrderList();

    }

    public void refreshTree() {
        alunosTree.clear();
        this.alunosTree = alunoDAO.listTreeAvl();
    }

    public void treeCount() {
        System.out.println("existem um total de :" + alunosTree.treeCount() + " alunos registrados");

    }

    public void finallyApp() {
        getAlunoDAO().finallyApp(alunosTree);
    }

    public TreeAVL getAlunosTree() {
        return alunosTree;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

}
