package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    
    private List<Card> cards; //List to holld the cards
    private int currentCard;

    public Deck(){

        currentCard =0;
        cards = new ArrayList<>();
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs","Spades"};

        for(String suit: suits){
            for (String rank: ranks){
                cards.add(new Card(rank,suit));
            }
        }

    }

    public List<Card> getCards(){
        return cards;
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
        currentCard=0;
    }

    public Card drawCard(){
        if (currentCard < cards.size()){
            return cards.get(currentCard++);
        } else{
            return null;
        }
    }

}
