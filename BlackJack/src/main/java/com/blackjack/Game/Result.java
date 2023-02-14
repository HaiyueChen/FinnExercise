package com.blackjack.Game;

import com.blackjack.Cards.Card;

public class Result {
    
    private String winner;
    private Iterable<Card> samCards;
    private Iterable<Card> dealerCards;

    public Result(
        String winner, 
        Iterable<Card> samCards, 
        Iterable<Card> dealerCards)
    {
        this.winner = winner;
        this.samCards = samCards;
        this.dealerCards = dealerCards;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(winner);
        output.append("\n");

        output.append("sam: ");
        for (Card card : samCards) 
        {
            output.append(card.toString());
            output.append(",");
        }
        output.deleteCharAt(output.length() - 1);
        output.append("\n");

        output.append("Dealer: ");
        for (Card card : dealerCards) 
        {
            output.append(card.toString());
            output.append(",");
        }
        output.deleteCharAt(output.length() - 1);

        return output.toString();
    }
}
