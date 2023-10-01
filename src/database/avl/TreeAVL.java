package database.avl;

import model.Aluno;

public class TreeAVL {
    private Node root;

    public TreeAVL() {
        this.root = null;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();

    }

    private int balancingFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getNodeLeft()) - height(node.getNodeRight());

    }

    private Node rightRotation(Node y) {
        Node x = y.getNodeLeft();
        Node t2 = x.getNodeRight();

        x.setNodeRight(y);
        y.setNodeLeft(t2);

        y.setHeight(Math.max(height(y.getNodeLeft()), height(y.getNodeRight())) + 1);
        x.setHeight(Math.max(height(x.getNodeLeft()), height(x.getNodeRight())) + 1);

        return x;
    }

    private Node leftRotation(Node y) {
        Node x = y.getNodeRight();
        Node t2 = x.getNodeLeft();

        y.setNodeLeft(x);
        x.setNodeRight(t2);


        x.setHeight(Math.max(height(x.getNodeLeft()), height(x.getNodeRight())) + 1);
        y.setHeight(Math.max(height(y.getNodeLeft()), height(y.getNodeRight())) + 1);

        return y;
    }

    public void insert(Aluno aluno) {
        root = insertRec(root, aluno);
    }

    private Node insertRec(Node node, Aluno aluno) {
        if (node == null) {
            return new Node(aluno);
        }
        if (aluno.getMatricula() < node.getAluno().getMatricula()) {
            node.setNodeLeft(insertRec(node.getNodeLeft(), aluno));
        } else if (aluno.getMatricula() > aluno.getMatricula()) {
            node.setNodeRight(insertRec(node.getNodeRight(), aluno));
        } else {
            return node;
        }

        int balancing = balancingFactor(node);
        if (balancing > 1) {
            if (aluno.getMatricula() < node.getNodeLeft().getAluno().getMatricula()) {
                return rightRotation(node);
            } else {
                node.setNodeLeft(leftRotation(node.getNodeLeft()));
                return rightRotation(node);

            }
        }
        if (balancing < -1) {
            if (aluno.getMatricula() > node.getNodeRight().getAluno().getMatricula()) {
                return leftRotation(node);
            } else {
                node.setNodeRight(rightRotation(node.getNodeRight()));
                return leftRotation(node);

            }
        }
        return node;
    }

    public void remove(Aluno aluno) {
        root = removeRec(root, aluno);
    }

    private Node removeRec(Node node, Aluno aluno) {
        if (node == null) {
            return node;
        }

        if (aluno.getMatricula() < node.getAluno().getMatricula()) {
            node.setNodeLeft(removeRec(node.getNodeLeft(), aluno));
        } else if (aluno.getMatricula() > node.getAluno().getMatricula()) {
            node.setNodeRight(removeRec(node.getNodeRight(), aluno));
        } else {
            if ((node.getNodeLeft() == null) || (node.getNodeRight() == null)) {
                Node temp = null;
                if (temp == node.getNodeLeft()) {
                    temp = node.getNodeRight();
                } else {
                    temp = node.getNodeLeft();
                }
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = encontrarMinimo(node.getNodeRight());
                node.setAluno(temp.getAluno());
                node.setNodeRight(removeRec(node.getNodeRight(), temp.getAluno()));

            }
        }
        if (node == null) {
            return node;
        }

        node.setHeight(Math.max(height(node.getNodeLeft()), height(node.getNodeRight())) + 1);

        int balancing = balancingFactor(node);

        if (balancing > 1) {
            if (balancingFactor(node.getNodeLeft()) >= 0) {
                return rightRotation(node);
            } else {
                node.setNodeLeft(leftRotation(node.getNodeLeft()));
                return rightRotation(node);
            }
        }

        if (balancing < -1) {
            if (balancingFactor(node.getNodeRight()) <= 0) {
                return leftRotation(node);
            } else {
                node.setNodeRight(rightRotation(node.getNodeRight()));
                return leftRotation(node);
            }
        }
        return node;


    }

    private Node encontrarMinimo(Node node) {
        Node temp = node;
        while (temp.getNodeLeft() != null) {
            temp = temp.getNodeLeft();
        }
        return temp;
    }

    public void List() {
        ListRec(root);
    }

    private void ListRec(Node node) {
        if (node != null) {
            ListRec(node.getNodeLeft());
            System.out.print(node.getAluno() + " ");
            ListRec(node.getNodeRight());
        }
    }

}