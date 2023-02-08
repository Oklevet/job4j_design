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
        for (int i = evenElements.size(); i > 0; i -= 2) {
            sb.append(evenElements.pollFirst());
            evenElements.pollFirst();
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
