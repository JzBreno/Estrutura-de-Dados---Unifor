import service.FileProcessor;
import structures.AVLTree;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "data/data.txt";
        FileProcessor processor = new FileProcessor();
        Stack<AVLTree> stack = processor.processFile(path);
        if (stack.isEmpty()) {
            System.exit(1);
        }
        while (!stack.isEmpty()) {
            AVLTree tree = stack.pop();
            System.out.println(tree.computeHash(tree.getRoot()));
        }
    }
}
