package com.blackjack.Cards;

public class Card {
    
    private String suite;
    private String rank;

    public Card(String suite, String rank)
    {
        this.suite = suite;
        this.rank = rank;
    }

    public String getSuite()
    {
        return this.suite;
    }

    public String getRank()
    {
        return this.rank;
    }

    public int getValueByRank() throws Exception
    {
        return CardUtils.getValueByRank(rank);
    }

    @Override
    public String toString()
    {
        return String.format("%s%s", suite, rank);
    }
}
