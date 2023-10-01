import database.AlunoDAO;
import database.avl.TreeAVL;
import model.Aluno;

public class App {
    public static void main(String[] args) {
        double[] nota = {7.5,8.1,5.6};
        Aluno a1 = new Aluno(1L,11,"pedrooo",2,nota);
        Aluno a2 = new Aluno(2L,12,"pedrooo",2,nota);
        Aluno a3 = new Aluno(3L,13,"pedrooo",2,nota);
        Aluno a4 = new Aluno(4L,14,"pedrooo",2,nota);

        TreeAVL treeAVL = new TreeAVL();
        treeAVL.insert(a1);
        treeAVL.insert(a2);
        treeAVL.insert(a3);
        treeAVL.insert(a4);
        treeAVL.List();
    }
}
