package com.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blackjack.Cards.Card;

public class CardTests {

    @Test
    public void TestStringFormating()
    {
        // Arrange
        Card card = new Card("C", "A");
        // Act
        String cardAsString = card.toString();

        // Assert
        assertEquals("CA", cardAsString);
    }
}
