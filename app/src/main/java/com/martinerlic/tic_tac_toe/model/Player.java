package com.martinerlic.tic_tac_toe.model;

/**
 * Created by mnxe on 5/15/2017.
 */

public class Player {

    private String textValue;
    private boolean turn;
    private int score;
    private boolean previousWinner;

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
