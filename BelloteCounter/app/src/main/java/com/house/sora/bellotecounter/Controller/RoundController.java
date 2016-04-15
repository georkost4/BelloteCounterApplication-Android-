package com.house.sora.bellotecounter.Controller;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.house.sora.bellotecounter.Model.modelTeam;
import com.house.sora.bellotecounter.R;
import com.house.sora.bellotecounter.View.MainActivity;

import java.util.ArrayList;

/**
 * Created by SoRa on 4/4/2016.
 */
public class RoundController
{


    public void countRound(modelTeam teamA,modelTeam teamB,EditText teamScoreText) {
        Boolean biddedA = teamA.getBidded();
        Boolean biddedB = teamB.getBidded();

        if (teamScoreText.getId() == R.id.txtScoreA) {
            int scoreA = Integer.parseInt(teamScoreText.getText().toString());
            if (biddedA && scoreA < 81) {
                Log.d("DEBUG", "bloom");
                teamA.setScore(0);
                teamB.setScore(162);
            } else if (biddedB && scoreA > 81) {
                Log.d("DEBUG", "bloom2");
                teamA.setScore(162);
                teamB.setScore(0);
            } else {
                teamB.setScore(162 - scoreA);
                teamA.setScore(scoreA);
            }
        } else {
            int scoreB = Integer.parseInt(teamScoreText.getText().toString());
            if (biddedA && scoreB > 81) {
                Log.d("DEBUG", "bloom3");
                teamA.setScore(0);
                teamB.setScore(162);
            } else if (biddedB && scoreB < 81) {
                Log.d("DEBUG", "bloom2");
                teamA.setScore(162);
                teamB.setScore(0);
            } else {
                teamA.setScore(162 - scoreB);
                teamB.setScore(scoreB);
            }

        }
        Log.d("DEBUG", "os edo kati inge");
    }





}
