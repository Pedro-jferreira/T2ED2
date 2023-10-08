package avl;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class TreeAVL {
    private Node root;

    public TreeAVL() {
        this.root = null;
    }

    public void insert(Aluno aluno) {
        setRoot(insertRec(getRoot(), aluno));
    }

    public Node searchByMatricula(int matricula) {
        return searchRec(getRoot(), matricula);
    }

    public void updateAlunoByMatricula(int matricula, Aluno novoAluno) {
        Node alunoNode = searchRec(getRoot(), matricula);
        if (alunoNode != null) {
            alunoNode.setAluno(novoAluno);
            setRoot(Balance(getRoot()));
            System.out.println("Aluno com matrícula " + matricula + " atualizado com sucesso.");
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    public void deleteByMatricula(int matricula) {
        if (deleteByMatriculaRec(matricula)) {
            System.out.println("deletado com sucesso!!");
        } else {
            System.out.println("não foi possível excluir");
        }
    }

    public int treeCount() {
        return treeCountRec(getRoot());
    }

    public void displayTree() {
        if (isEmpty()) {
            System.out.println("árvore vazia!");
            return;
        }
        String separator = "  |__";
        System.out.println(getRoot().getAluno() + "(" + getRoot().getHeight() + ")");
        displaySubTree(getRoot().getNodeLeft(), separator);
        displaySubTree(getRoot().getNodeRight(), separator);
    }

    public String inOrder() {
        return inOrderRec(getRoot(), new StringBuilder());
    }

    public List<Aluno> inOrderList() {
        return inOrderRecList(getRoot(), new ArrayList<>());
    }

    public void preOrder() {
        preOrderRec(getRoot());
    }

    public void posOrder() {
        posOrderRec(getRoot());
    }

    public void clear() {
        setRoot(null);
    }

    public boolean isEmpty() {
        return getRoot() == null;
    }

    public Node getRoot() {
        return root;
    }

    private Node insertRec(Node node, Aluno aluno) {
        if (node == null)
            node = new Node(aluno, null, null);
        else if (aluno.getMatricula() < node.getAluno().getMatricula())
            node.setNodeLeft(insertRec(node.getNodeLeft(), aluno));
        else if (aluno.getMatricula() > node.getAluno().getMatricula())
            node.setNodeRight(insertRec(node.getNodeRight(), aluno));
        node = Balance(node);
        return node;

    }

    private Node searchRec(Node node, int matricula) {
        while (node != null) {
            if (matricula == node.getAluno().getMatricula())
                return node;
            else if (matricula < node.getAluno().getMatricula())
                node = node.getNodeLeft();
            else
                node = node.getNodeRight();
        }
        return null;
    }

    private boolean deleteByMatriculaRec(int matricula) {
        if (isEmpty()) {
            return false;
        }

        Node alunoNode = searchRec(getRoot(), matricula);
        Node alunoFatherNode = searchFather(alunoNode.getAluno());

        if (alunoNode.getNodeLeft() == null && alunoNode.getNodeRight() == null) {
            if (alunoFatherNode != null) {
                if (alunoFatherNode.getNodeLeft() == alunoNode) {
                    alunoFatherNode.setNodeLeft(null);
                } else {
                    alunoFatherNode.setNodeRight(null);
                }
                setRoot(Balance(getRoot()));
            } else {
                setRoot(null);
            }
        } else if (alunoNode.getNodeLeft() == null || alunoNode.getNodeRight() == null) {
            Node child = (alunoNode.getNodeLeft() != null) ? alunoNode.getNodeLeft() : alunoNode.getNodeRight();

            if (alunoFatherNode != null) {
                if (alunoFatherNode.getNodeLeft() == alunoNode) {
                    alunoFatherNode.setNodeLeft(child);
                } else {
                    alunoFatherNode.setNodeRight(child);
                }
                setRoot(Balance(getRoot()));
            } else {
                setRoot(child);
            }
        } else {
            Node successor = findSuccessor(alunoNode);
            searchFather(successor.getAluno());
            alunoNode.setAluno(successor.getAluno());
            deleteByMatriculaRec(successor.getAluno().getMatricula());
            setRoot(Balance(getRoot()));
        }

        System.out.println("Aluno com matrícula " + matricula + " excluído.");
        return true;
    }

    private int treeCountRec(Node node) {
        if (node == null) {
            return 0;
        }

        int totalEsquerda = 0;
        int totalDireita = 0;

        if (node.getNodeLeft() != null) {
            totalEsquerda = treeCountRec(node.getNodeLeft());
        }

        if (node.getNodeRight() != null) {
            totalDireita = treeCountRec(node.getNodeRight());
        }

        return totalEsquerda + totalDireita + 1;
    }

    private void displaySubTree(Node node, String separator) {

        if (node != null) {

            Node father = this.searchFather(node.getAluno());
            assert father != null;
            if (node.equals(father.getNodeLeft())) {
                System.out.println(separator + node.getAluno() + "(" + node.getHeight() + ")" + " (ESQ)");
            } else {
                System.out.println(separator + node.getAluno() + "(" + node.getHeight() + ")" + " (DIR)");
            }
            displaySubTree(node.getNodeLeft(), "     " + separator);
            displaySubTree(node.getNodeRight(), "     " + separator);
        }
    }

    private String inOrderRec(Node node, StringBuilder builder) {

        if (node != null) {
            inOrderRec(node.getNodeLeft(), builder);
            builder.append(node.getAluno()).append("\n");
            inOrderRec(node.getNodeRight(), builder);
        }
        return String.valueOf(builder);
    }

    private List<Aluno> inOrderRecList(Node node, List<Aluno> alunoList) {
    if (node != null) {
        inOrderRecList(node.getNodeLeft(), alunoList);
        alunoList.add(node.getAluno());
        inOrderRecList(node.getNodeRight(), alunoList);
    }
    return alunoList;
}

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getAluno() + "\n");
            preOrderRec(node.getNodeLeft());
            preOrderRec(node.getNodeRight());
        }
    }

    private void posOrderRec(Node node) {
        if (node != null) {
            posOrderRec(node.getNodeLeft());
            posOrderRec(node.getNodeRight());
            System.out.print(node.getAluno() + "\n");
        }
    }

    private Node rightRotation(Node node) {
        Node temp = node.getNodeLeft();

        node.setNodeLeft(temp.getNodeRight());
        temp.setNodeRight(node);

        node.setHeight(Math.max(height(node.getNodeLeft()), height(node.getNodeRight())) + 1);
        temp.setHeight(Math.max(height(temp.getNodeLeft()), height(temp.getNodeRight())) + 1);

        return temp;
    }

    private Node leftRotation(Node node) {
        Node temp = node.getNodeRight();
        node.setNodeRight(temp.getNodeLeft());
        temp.setNodeLeft(node);

        temp.setHeight(Math.max(height(node.getNodeLeft()), height(node.getNodeRight())) + 1);
        node.setHeight(Math.max(height(temp.getNodeLeft()), height(temp.getNodeRight())) + 1);

        return temp;
    }

    private Node doubleRightRotation(Node node) {
        node.setNodeLeft(leftRotation(node.getNodeLeft()));
        return rightRotation(node);
    }

    private Node doubleLeftRotation(Node node) {
        node.setNodeRight(rightRotation(node.getNodeRight()));
        return leftRotation(node);
    }


    private Node searchFather(Aluno aluno) {
        Node root = getRoot();
        Node temp = null;
        while (root != null && !(root.getAluno().getMatricula() == aluno.getMatricula())) {
            temp = root;
            if (root.getAluno().getMatricula() < aluno.getMatricula())
                root = root.getNodeRight();
            else
                root = root.getNodeLeft();
        }
        if (root != null && root.getAluno().getMatricula() == aluno.getMatricula())
            return temp;
        return null;
    }

    private Node Balance(Node node) {
        if (getFactor(node) == 2) {
            if (getFactor(node.getNodeLeft()) > 0)
                node = rightRotation(node);
            else
                node = doubleRightRotation(node);
        } else if (getFactor(node) == -2) {
            if (getFactor(node.getNodeRight()) < 0)
                node = leftRotation(node);
            else
                node = doubleLeftRotation(node);
        }
        node.setHeight(max(height(node.getNodeLeft()), height(node.getNodeRight())) + 1);
        return node;
    }

    private Node findSuccessor(Node node) {
        Node current = node.getNodeRight();
        while (current != null && current.getNodeLeft() != null) {
            current = current.getNodeLeft();
        }
        return current;
    }

    private void setRoot(Node root) {
        this.root = root;
    }

    private int height(Node node) {
        return node == null ? -1 : node.getHeight();
    }

    private int max(int lhs, int rhs) {
        return Math.max(lhs, rhs);
    }

    private int getFactor(Node node) {
        return height(node.getNodeLeft()) - height(node.getNodeRight());
    }
}