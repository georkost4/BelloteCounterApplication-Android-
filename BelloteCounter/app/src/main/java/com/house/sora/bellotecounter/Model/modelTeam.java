package com.house.sora.bellotecounter.Model;

import com.house.sora.bellotecounter.Controller.Bonus;

/**
 * Created by SoRa on 5/4/2016.
 */
public class modelTeam
{
    String name;
    int score;
    Bonus bonus;

    public modelTeam(String name, int score, Bonus bonus) {
        this.name = name;
        this.score = score;
        this.bonus = bonus;
    }


    public int getValue(Bonus bonus)
    {
        int returnedVal = 0;
        switch(bonus) {
            case BELLOTE:
                returnedVal = 20;
                break;
            case THREE_IN_A_ROW:
                returnedVal = 20;
                break;
            case FOUR_IN_A_ROW:
                returnedVal = 50;
                break;
            case FIVE_IN_A_ROW:
                returnedVal = 100;
                break;
            case FOUR_Js:
                returnedVal = 200;
                break;
            case FOUR_9s:
                returnedVal = 150;
                break;
            case FOUR_A10KQ:
                returnedVal = 100;
                break;
        }

        return returnedVal;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBonus() {
        return this.getValue(this.bonus);
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
}
