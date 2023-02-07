package ru.job4j.collection.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        Iterator<Character> it = evenElements.iterator();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (it.hasNext()) {
            if (i % 2 == 0) {
                sb.append(it.next());
            } else {
                it.next();
            }
            i++;
        }
        return sb.toString();
    }

    private String getDescendingElements() {
        Iterator<Character> it = descendingElements.descendingIterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
