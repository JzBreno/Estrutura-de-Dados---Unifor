package structures;

import model.AVLNode;

public class HashTree {

    public String computeHash(AVLNode node) {
        if (node == null) {
            return "";
        }
        computeHash(node.getLeft());
        computeHash(node.getRight());
        node.updateNodeData();
        return node.getHash();
    }
}
