package ru.job4j.collection.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder sb = new StringBuilder();
        int queueSize = evenElements.size();
        for (int i = 0; i < queueSize; i++) {
            if (i % 2 == 0) {
                sb.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
            System.out.println(i);
        }
        return sb.toString();
    }

    private String getDescendingElements() {
        StringBuilder sb = new StringBuilder();
        int queueSize = descendingElements.size();
        for (int i = 0; i < queueSize; i++) {
            sb.append(descendingElements.pollLast());
        }
        return sb.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
