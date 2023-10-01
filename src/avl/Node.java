package avl;

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

    public Node(Aluno aluno, Node nodeLeft, Node nodeRight) {
        this.aluno = aluno;
        this.nodeLeft = nodeLeft;
        this.nodeRight = nodeRight;
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

    @Override
    public String toString() {
        return "Node{" +
                "aluno=" + aluno +
                ", height=" + height +
                ", nodeLeft=" + nodeLeft +
                ", nodeRight=" + nodeRight +
                '}';
    }
}
