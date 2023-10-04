package service;

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

    public boolean searchByMatricula(int matricula) {
        Node node = alunosTree.searchByMatricula(matricula);
        if (node != null) {
            System.out.println("aluno encontrado: " + node.getAluno());
            return true;
        } else {
            System.out.println("aluno não encontrado");
            return false;
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
