package model;

public class AVLNode {

    private String word;
    private String Hash;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(String word) {
        this.word = word;
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
        return Hash;
    }

    public void setHash(String hash) {
        Hash = hash;
    }

    public AVLNode getLeft() {
        return left;
    }
}
