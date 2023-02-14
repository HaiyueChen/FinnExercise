package com.blackjack.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.blackjack.Cards.Card;
import com.blackjack.Cards.CardUtils;

public class DeckGenerator {
    
    private Random rand;

    public DeckGenerator(int seed){
        this.rand = new Random(seed);
    }

    public List<String> generateDeck()
    {
        List<String> rawDeck = new ArrayList<>(52);
        for (String suite : CardUtils.getValidSuites()) {
            for (String rank : CardUtils.getValidRanks()) {
                rawDeck.add(String.format("%s%s", suite, rank));
            }
        }

        Collections.shuffle(rawDeck, rand);
        return rawDeck;
    }
}
