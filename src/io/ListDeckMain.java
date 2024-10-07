package io;

import java.io.Console;
import java.lang.System;

public class ListDeckMain {

    public static  void main (String[] args){

        Deck deck = new Deck();
        boolean stop = false;
        Console cons = System.console();

        while(!stop){
            String cmd = cons.readLine(">>> Draw or Shuffle? ").trim();

            switch (cmd.toUpperCase()){
                case "DRAW":
                System.out.println(deck.drawCard() + "\n");
                break;
                case "SHUFFLE":
                deck.shuffleDeck();
                System.out.println("The Deck has been shuffled\n");
                break;
                case "BREAK":
                stop = true;
                break;

            }
        }

    }
    
}
