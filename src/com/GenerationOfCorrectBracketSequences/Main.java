package com.GenerationOfCorrectBracketSequences;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int n = scanner.nextInt();
            scanner.close();

            ArrayList<String> result = generateBracketSequences(n);


            for (String sequence : result) {
                    System.out.println(sequence);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> generateBracketSequences(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate("", n, n, result);
        return result;
    }

    private static void generate(String current, int open, int close, ArrayList<String> result) {
        if (open == 0 && close == 0) {
            if(isValid(current)){
                result.add(current);
                return;
            }
        }

        if (open > 0) {
            generate(current + "(", open - 1, close, result);
        }

        if (open > 0) {
            generate(current + "[", open - 1, close, result);
        }

        if (close > open) {
            generate(current + ")", open, close - 1, result);
        }

        if (close > open) {
            generate(current + "]", open, close - 1, result);
        }
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (bracket == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (bracket == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (bracket == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
    static class BracketSequenceComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            // Сравниваем строки лексикографически
            int lexicoComparison = s1.compareTo(s2);

            // Если лексикографическое сравнение дало результат, возвращаем его
            if (lexicoComparison != 0) {
                return lexicoComparison;
            }

            // Иначе сравниваем строки по длине
            return Integer.compare(s1.length(), s2.length());
        }
    }
}
