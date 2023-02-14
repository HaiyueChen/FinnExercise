package com.blackjack;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import com.blackjack.Game.Game;
import com.blackjack.Game.Result;

public class GameTest 
{

    private LinkedList<String> rawDeck;

    @Before
    public void initialize()
    {
        this.rawDeck = new LinkedList<>();
    }

    @Test
    public void samShouldWin() throws Exception
    {
        // Arrange
        rawDeck = new LinkedList<>();
        rawDeck.add("CA");
        rawDeck.add("D5");
        rawDeck.add("H9");
        rawDeck.add("HQ");
        rawDeck.add("S8");
        Game game = new Game(rawDeck);

        // Act
        Result result = game.play();

        // Assert
        assertTrue(result.getWinner().equals("Sam"));
    }


    // I wish I could have added the following tests, but I have to catch a plane right now
    // and do not have more time to add tests :(

    /*
    @Test
    public void dealerShouldWin()
    {}

    @Test
    public void samShouldWinOnFirstRound()
    {}

    @Test
    public void dealerShouldWinOnFirstRound()
    {}

    @Test
    public void samWinsAfterHisRound()
    {}

    @Test
    public void samGoesBust()
    {}

    @Test
    public void dealerGoesBust(){}
     */
}
