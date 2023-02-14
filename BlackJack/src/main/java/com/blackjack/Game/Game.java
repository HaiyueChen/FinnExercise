package com.blackjack.Game;

import java.util.Collection;
import java.util.LinkedList;

import com.blackjack.Cards.Card;
import com.blackjack.Cards.CardUtils;
import com.blackjack.Cards.Deck;

public class Game {

    private Deck deck;
    private int samScore = 0;
    private int dealerScore = 0;

    private LinkedList<Card> samCards = new LinkedList<>();
    private LinkedList<Card> dealerCards = new LinkedList<>();

    
    public Game(Collection<String> rawCards) throws Exception
    {
        if (rawCards.size() < 4) 
        {
            throw new Exception("Not enough cards to play the game");    
        }

        this.deck = new Deck(rawCards);
    }

    public Result play() throws Exception
    {
        String winner = null;

        gameStart();
        winner = checkWinner();
        if (winner != null) 
        {
            return new Result(winner, samCards, dealerCards);        
        }

        samPhase();
        winner = checkWinner();
        if (winner != null) 
        {
            return new Result(winner, samCards, dealerCards);
        }

        dealerPhase();
        if (dealerScore <= 21) 
        { 
            winner = "Dealer";
        }
        else
        {
            winner = "Sam";
        }
        return new Result(winner, samCards, dealerCards);
    }

    private String checkWinner()
    {
        if (samScore == 21) {return "Sam";}
        if (samScore > 21) { return "Dealer";}
        if (dealerScore == 21 && samScore != 21) {return "Dealer";}

        return null;
    }

    private void gameStart() throws Exception
    {
        for (int i = 0; i < 2; i++) 
        {
            Card samCard = deck.drawCard();
            Card dealerCard = deck.drawCard();
            samScore += CardUtils.getValueByRank(samCard.getRank());
            dealerScore += CardUtils.getValueByRank(dealerCard.getRank());
            samCards.add(samCard);
            dealerCards.add(dealerCard);
        }
    }

    private void samPhase() throws Exception
    {
        while (samScore < 17) {
            Card samCard = deck.drawCard();
            samScore += CardUtils.getValueByRank(samCard.getRank());
            samCards.add(samCard);
        }
    }

    private void dealerPhase() throws Exception
    {
        while (dealerScore <= samScore) {
            Card dealerCard = deck.drawCard();
            dealerScore += CardUtils.getValueByRank(dealerCard.getRank());
            dealerCards.add(dealerCard);
        }
    }
}
