package com.blackjack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.blackjack.Cards.CardUtils;

public class CardUtilsTests 
{
    @Test(expected = Exception.class)
    public void testGetValueByRankThrowsException() throws Exception
    {
        Exception e = null;
        try {
            CardUtils.getValueByRank("L");
        } catch (Exception a) {
            e = a;
        }
        assertTrue(e.getMessage().equals("Invalid rank: L"));
        throw e;
    }
}