package com.wenqi.learn.chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author liangwenqi
 * @date 2022/2/23
 */
public class ForTest {
    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public static void main(String[] args) {
        // Can you spot the bug?
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                // Bug: i.next()
                deck.add(new Card(i.next(), j.next()));
            }
        }
    }

    static class Card {
        private Suit suit;
        private Rank rank;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }
    }
}
