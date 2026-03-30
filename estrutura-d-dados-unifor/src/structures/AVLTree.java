package structures;

import model.AVLNode;

public class AVLTree {

    private AVLNode root;

    public void insert(String value) {
        if (value == null) {
            return;
        }
        root = insert(root, value);
    }

    public AVLNode insert(AVLNode node, String value) {
        if (node == null) {
            return new AVLNode(value);
        }

        int cmp = value.compareToIgnoreCase(node.getWord());
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }

        node.updateNodeData();

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.getLeft()) >= 0) {
            return rightRotate(node);
        }
        if (balance > 1 && getBalance(node.getLeft()) < 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.getRight()) <= 0) {
            return leftRotate(node);
        }
        if (balance < -1 && getBalance(node.getRight()) > 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public AVLNode leftRotate(AVLNode x) {
        if (x == null || x.getRight() == null) {
            return x;
        }
        AVLNode y = x.getRight();
        AVLNode t2 = y.getLeft();

        y.setLeft(x);
        x.setRight(t2);

        x.updateNodeData();
        y.updateNodeData();
        return y;
    }

    public AVLNode rightRotate(AVLNode y) {
        if (y == null || y.getLeft() == null) {
            return y;
        }
        AVLNode x = y.getLeft();
        AVLNode t2 = x.getRight();

        x.setRight(y);
        y.setLeft(t2);

        y.updateNodeData();
        x.updateNodeData();
        return x;
    }

    public int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    /** Fator de balanceamento da raiz da árvore. */
    public int getBalance() {
        return getBalance(root);
    }

    public int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    public int height() {
        return height(root);
    }

    public AVLNode getRoot() {
        return root;
    }

}
