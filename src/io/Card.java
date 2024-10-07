package io;

public class Card {
    
    private String suite;
    private String rank;

    public Card (String rank, String suite){
        this.rank = rank;
        this.suite = suite;
    }

    // Getters and Setters

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString(){
        return rank + " of " + suite;
    }
    

}
