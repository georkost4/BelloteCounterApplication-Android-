package com.house.sora.bellotecounter.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.house.sora.bellotecounter.Controller.Bonus;

/**
 * Created by SoRa on 5/4/2016.
 */
public class modelTeam implements Parcelable
{
    String name;
    int score;
    int bonus;
    Boolean bidded;


    public modelTeam(String name, int score, Bonus bonus,Boolean bidded) {
        this.name = name;
        this.score = score;
        this.bonus = getValue(bonus);
        this.bidded = bidded;
    }
    public modelTeam() {this.bonus = 0;}


    public Boolean getBidded() {
        return bidded;
    }

    public void setBidded(Boolean bidded) {
        this.bidded = bidded;
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
        return this.bonus;
    }

    public void setBonus(Bonus bonus) {
        Log.d("InideModel","added");
        this.bonus += getValue(bonus);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
