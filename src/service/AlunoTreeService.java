package service;

import avl.Node;
import avl.TreeAVL;
import database.AlunoDAO;
import model.Aluno;

public class AlunoTreeService {
    private TreeAVL alunosTree;
    private AlunoDAO alunoDAO;

    public AlunoTreeService() {
        this.alunosTree = new TreeAVL();
        this.alunoDAO = new AlunoDAO();
    }

    public void insertAluno(Aluno aluno, boolean saveDataBase) {
        alunosTree.insert(aluno);
        if (saveDataBase) {
            alunoDAO.Save(aluno);
        }
    }

    public void deleteAlunoByMatricula(int matricula, boolean saveDataBase) {
        alunosTree.deleteByMatricula(matricula);
        if (saveDataBase) {
            alunoDAO.delete(alunosTree);
        }
    }


    public void seartch( int matricula){
     Node node = alunosTree.search(matricula);
     if (node != null){
         System.out.println("aluno encontrado: "+ node.getAluno());
     }else System.out.println("aluno não encontrado");
    }

    public void  ListarAlunos() {
         getAlunosTree().displayTree();
    }
    public  void displayTree(){

    }
    public void  refreshTree(){
        alunosTree.clear();
        setAlunosTree(alunoDAO.List());
    }
    public  void  contarAlunos(){
        System.out.println("existem um total de :"+alunosTree.contarAlunos()+ "alunos Armazenados");

    }

    public TreeAVL getAlunosTree() {
        return alunosTree;
    }

    private void setAlunosTree(TreeAVL alunosTree) {
        this.alunosTree = alunosTree;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    private void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }
}
