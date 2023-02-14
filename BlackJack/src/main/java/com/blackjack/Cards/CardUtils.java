package com.blackjack.Cards;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public final class CardUtils {

    // RankToValue and validSuites should be defined in config files
    // I am not sure how to best do it in the java world.

    private static HashMap<String, Integer> rankToValue = 
        new HashMap<String, Integer>() 
        {{
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("A", 11);
            put("J", 10);
            put("Q", 10);
            put("K", 10);
        }};

    private static HashSet<String> validSuites = 
        new HashSet<String>() 
        {{
            add("C");
            add("D");
            add("H");
            add("S");
        }};

    public static boolean isValidSuite(String suite)
    {
        return validSuites.contains(suite);
    }

    public static boolean isValidRank(String rank)
    {
        return rankToValue.keySet().contains(rank);
    }

    public static boolean isValidCard(String card)
    {
        if (card.length() > 3 || card.length() < 2) {
            return false;
        }

        String suite = card.substring(0,1);
        String rank = card.substring(1);
        return isValidSuite(suite) && isValidRank(rank);
    }

    public static Collection<String> getValidRanks()
    {
        return rankToValue.keySet();
    }

    public static Collection<String> getValidSuites()
    {
        return validSuites;
    }

    public static int getValueByRank(String rank) throws Exception
    {
        if (!isValidRank(rank)) 
        {
            throw new Exception(String.format("Invalid rank: %s", rank));
        }

        return rankToValue.get(rank);
    }
}