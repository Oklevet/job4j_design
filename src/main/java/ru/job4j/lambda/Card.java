package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit
                + ", value=" + value + '}';
    }

    public static List<Card> makeCardDeck() {
        return Arrays.stream(Suit.values())
                .flatMap(x -> Arrays.stream(Value.values())
                        .map(y -> new Card(x, y)))
                .toList();
    }

    public static void main(String[] args) {
        makeCardDeck().forEach(x -> System.out.println(x.toString()));
    }
}