package service;

import structures.AVLTree;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class FileProcessor {

    private List<String> readLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return Collections.emptyList();
        }
    }
  
    public Stack<AVLTree> processFile(String path) {
        List<String> lines = readLines(path);
        Stack<AVLTree> stack = new Stack<>();
        if (lines.size() < 30) {
            System.err.println("O arquivo deve conter no minimo 30 linhas.");
            return stack;
        }
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] wordsArray = line.split("\\s+");
            List<String> wordList = new ArrayList<>();
            for (String word : wordsArray) {
                wordList.add(word);
            }
            AVLTree tree = new AVLTree();
            for (int i = wordList.size() - 1; i >= 0; i--) {
                String word = wordList.get(i);
                tree.insert(word);
            }
            stack.push(tree);
        }
        return stack;
    }
}
