package com.martinerlic.tic_tac_toe.model;

/**
 * Created by mnxe on 5/15/2017.
 */

public class Player {


    private String textValue; // The text value of the player's mark, i.e. X or O
    private boolean turn; // Is it this player's turn?
    private int score; // How many games has this player won?
    private boolean previousWinner; // Did this player win in the previous match?


    public Player(String startTextValue, boolean startTurn, int startScore, boolean startPreviousWinner) {
        textValue = startTextValue;
        turn = startTurn;
        score = startScore;
        previousWinner = startPreviousWinner;
    }


    public String getTextValue() {
        return textValue;
    }


    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }


    public boolean isTurn() {
        return turn;
    }


    public void setTurn(boolean turn) {
        this.turn = turn;
    }


    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }


    public boolean isPreviousWinner() {
        return previousWinner;
    }


    public void setPreviousWinner(boolean previousWinner) {
        this.previousWinner = previousWinner;
    }


}
