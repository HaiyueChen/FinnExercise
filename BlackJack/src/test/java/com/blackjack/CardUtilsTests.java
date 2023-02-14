package com.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.blackjack.Cards.CardUtils;

@RunWith(Parameterized.class)
public class CardUtilsTests 
{   
    private String suite;
    private boolean expectedResult;

    public CardUtilsTests(String suite, boolean expectedResult)
    {
        this.suite = suite;
        this.expectedResult = expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> TestSuites() 
    {
       return Arrays.asList(new Object[][] {
          { "C", true },
          { "D", true },
          { "H", true },
          { "S", true },
          { "c", false },
          { "d", false },
          { "h", false },
          { "s", false },
       });
    }

    @Test
    public void TestIsValidSuiteReturnsTrue()
    {
        assertEquals(this.expectedResult, CardUtils.isValidSuite(this.suite) );
    }
}