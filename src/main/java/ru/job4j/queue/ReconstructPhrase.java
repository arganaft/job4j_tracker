package ru.job4j.queue;

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
        StringBuilder resultLine = new StringBuilder();
        Object[] evenArray = evenElements.toArray();
        for (int i = 0; i < evenArray.length; i += 2) {
            resultLine.append(evenArray[i]);
        }
        return String.valueOf(resultLine);
    }

    private String getDescendingElements() {
        StringBuilder resultLine = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            resultLine.append(iterator.next());
        }
        return String.valueOf(resultLine);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}