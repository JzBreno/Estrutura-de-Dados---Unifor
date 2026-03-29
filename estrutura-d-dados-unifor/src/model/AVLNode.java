package model;

import util.SHA1Util;

public class AVLNode {

    private String word;
    private String hash;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(String word) {
        this.word = word;
        this.height = 1;
        this.hash = SHA1Util.gerarHash(word);
    }

    public void updateNodeData() {

        int leftHeight = (left != null) ? left.getHeight() : 0;
        int rightHeight = (right != null) ? right.getHeight() : 0;
        this.height = 1 + Math.max(leftHeight, rightHeight);

        String leftHash = (left != null) ? left.getHash() : "";
        String rightHash = (right != null) ? right.getHash() : "";
        String currentWordHash = SHA1Util.gerarHash(this.word);

        this.hash = SHA1Util.gerarHash(leftHash + rightHash + currentWordHash);
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "word='" + word + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public AVLNode getLeft() {
        return left;
    }
}
