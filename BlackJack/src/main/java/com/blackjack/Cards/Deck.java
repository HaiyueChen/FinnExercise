package com.blackjack.Cards;

import java.util.LinkedList;

public class Deck {
    
    private LinkedList<Card> cards = new LinkedList<Card>();

    public Deck(Iterable<String> rawCards) throws Exception
    {
        for (String rawCard : rawCards) 
        {
            if (!CardUtils.isValidCard(rawCard)) 
            {
                throw new Exception(String.format("Invalid Deck: %s", rawCard));
            }

            String suite = rawCard.substring(0,1);
            String rank = rawCard.substring(1);
            this.cards.add(new Card(suite, rank));
        }
    }

    public Card drawCard()
    {
        if (cards.size() == 0) 
        {
            return null;    
        }

        Card drawn = cards.removeFirst();
        return drawn;
    }
}
