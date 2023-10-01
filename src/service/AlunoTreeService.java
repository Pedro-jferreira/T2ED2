package service;

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

/*    public void AtualizarAluno(Aluno aluno, boolean saveDataBase) {

        alunosTree.update(aluno);

        if (saveDataBase){
            alunoDAO.update(aluno);
        }
    }*/

    public void  ListarAlunos() {
         getAlunosTree().displayTree();
    }
    public  void displayTree(){

    }
    public void  refreshTree(){
        alunosTree.clear();
        setAlunosTree(alunoDAO.List());
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
