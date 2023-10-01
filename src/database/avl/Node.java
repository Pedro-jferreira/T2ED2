package database.avl;

import model.Aluno;

public class Node {
    private Aluno aluno;
    private  int height;
    private Node nodeLeft, nodeRight;

    public Node() {
    }

    public Node(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Node getNodeLeft() {
        return nodeLeft;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNodeLeft(Node nodeLeft) {
        this.nodeLeft = nodeLeft;
    }

    public Node getNodeRight() {
        return nodeRight;
    }

    public void setNodeRight(Node nodeRight) {
        this.nodeRight = nodeRight;
    }
}
