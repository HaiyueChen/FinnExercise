package com.blackjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.blackjack.Game.DeckGenerator;
import com.blackjack.Game.Game;
import com.blackjack.Game.Result;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length > 1) {
            System.out.println("Invalid commandline arguments.");
            System.exit(0);
        }

        List<String> rawDeck;
        if (args.length == 1) {
            rawDeck = readRawDeck(args[0]);
        }
        else
        {
            DeckGenerator gen = new DeckGenerator(123);
            rawDeck = gen.generateDeck();
        }

        rawDeck = new LinkedList<>();
        rawDeck.add("CA");
        rawDeck.add("D5");
        rawDeck.add("H9");
        rawDeck.add("HQ");
        rawDeck.add("S8");
        try {
            Game game = new Game(rawDeck);
            Result result = game.play();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(String.format("Unexpected Error: %s", e.getMessage()));
        }
        
    }

    private static List<String> readRawDeck(String path)
    {
        String data = null;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              data = myReader.nextLine();
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("Deck not found.");
            System.exit(0);
          }
        
        if (data == null) 
        {
            System.out.println("Deck not found.");
            System.exit(0);
        }

        return Arrays.asList(data.split(","));
    }
}
