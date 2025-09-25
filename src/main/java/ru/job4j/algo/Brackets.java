package ru.job4j.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        boolean error = false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> sameSymPairs = new HashMap<>();
        sameSymPairs.put('\"', '\"');
        Map<Character, Character> uniqueSymPairs = new HashMap<>();
        uniqueSymPairs.put(')', '(');
        uniqueSymPairs.put(']', '[');
        uniqueSymPairs.put('}', '{');

        for (char c : chars) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }

            if (uniqueSymPairs.containsValue(c)) {
                stack.push(c);
                continue;
            }

            if (sameSymPairs.containsKey(c)) {
                if (stack.pop().equals(c)) {
                    continue;
                } else {
                    error = true;
                    break;
                }
            }

            if (uniqueSymPairs.containsKey(c)) {
                if (stack.pop().equals(uniqueSymPairs.get(c))) {
                    continue;
                } else {
                    error = true;
                    break;
                }
            }

            stack.push(c);
        }

        if (!stack.empty()) {
            error = true;
        }

        return !error;
    }
}