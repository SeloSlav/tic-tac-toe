package com.martinerlic.tic_tac_toe.model;

/**
 * Created by mnxe on 5/15/2017.
 */

public class Player {


    private String textValue; // The text value of the player's mark, i.e. X or O
    private boolean turn; // Is it this player's turn?


    public Player(String startTextValue, boolean startTurn) {
        textValue = startTextValue;
        turn = startTurn;
    }


    public String getTextValue() {
        return textValue;
    }


    public boolean isTurn() {
        return turn;
    }


    public void setTurn(boolean turn) {
        this.turn = turn;
    }


}
