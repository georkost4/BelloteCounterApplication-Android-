package com.house.sora.bellotecounter.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.house.sora.bellotecounter.Controller.Bonus;
import com.house.sora.bellotecounter.Model.modelTeam;
import com.house.sora.bellotecounter.R;

/**
 * Created by SoRa on 9/4/2016.
 */
public class BonusView extends AppCompatActivity
{
    private CheckBox ThreeCards_TeamA,ThreeCards_TeamB,FourCards_TeamA,FourCards_TeamB,FiveCards_TeamA,FiveCards_TeamB,
            Bellote_TeamA,Bellote_TeamB,
            FourJs_TeamA, FourJs_TeamB,Four9s_TeamA,Four9s_TeamB,FourA10KQs_TeamA,FourA10KQs_TeamB;
    private Button btnGo;
    private modelTeam TeamA,TeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus_layout);

        initComponents();

        if(savedInstanceState == null)
        {
            TeamA = new modelTeam();
            TeamB = new modelTeam();
            Log.d("Debug","BAD BAD ROBOT");
            Toast.makeText(this,"Ba ROBOOTTTT",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        TeamA = savedInstanceState.getParcelable("TeamA");
        TeamB = savedInstanceState.getParcelable("TeamB");
        Log.d("Debug","GG");
        Toast.makeText(this,"Loaded",Toast.LENGTH_LONG).show();


    }



    private void initComponents()
    {

        btnGo = (Button) findViewById(R.id.btnBonusGo);

        ThreeCards_TeamA = (CheckBox) findViewById(R.id.chkbox_ThreeCardsTeamA);
        ThreeCards_TeamB = (CheckBox) findViewById(R.id.chkbox_ThreeCardsTeamB);

        FourCards_TeamA = (CheckBox) findViewById(R.id.chkbox_FourCardsTeamA);
        FourCards_TeamB = (CheckBox) findViewById(R.id.chkbox_FourCardsTeamB);

        FiveCards_TeamA = (CheckBox) findViewById(R.id.chkbox_FiveCardsTeamA);
        FiveCards_TeamB = (CheckBox) findViewById(R.id.chkbox_FiveCardsTeamB);

        Bellote_TeamA = (CheckBox) findViewById(R.id.chkbox_BelloteTeamA);
        Bellote_TeamB = (CheckBox) findViewById(R.id.chkbox_BelloteTeamB);

        FourJs_TeamA = (CheckBox) findViewById(R.id.chkbox_FourJs_TeamA);
        FourJs_TeamB = (CheckBox) findViewById(R.id.chkbox_FourJs_TeamB);

        Four9s_TeamA = (CheckBox) findViewById(R.id.chkbox_Four9s_TeamA);
        Four9s_TeamB = (CheckBox) findViewById(R.id.chkbox_Four9s_TeamB);

        FourA10KQs_TeamA = (CheckBox) findViewById(R.id.chkbox_FourA10KQs_TeamA);
        FourA10KQs_TeamB = (CheckBox) findViewById(R.id.chkbox_FourA10KQs_TeamB);



        Bellote_TeamA.setOnClickListener(new onClickHandler());
        Bellote_TeamB.setOnClickListener(new onClickHandler());

        FourA10KQs_TeamA.setOnClickListener(new QuadraHandler());
        FourA10KQs_TeamB.setOnClickListener(new QuadraHandler());

        Four9s_TeamA.setOnClickListener(new Quadra9sHandler());
        Four9s_TeamB.setOnClickListener(new Quadra9sHandler());

        FourJs_TeamA.setOnClickListener(new QuadraJsHandler());
        FourJs_TeamB.setOnClickListener(new QuadraJsHandler());

        btnGo.setOnClickListener(new btnGoOnClickHandler());


    }


    private class onClickHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            CheckBox checkBox = (CheckBox) v;

            switch (checkBox.getId())
            {
                case R.id.chkbox_BelloteTeamA:
                    Bellote_TeamB.setChecked(false);
                    break;
                case R.id.chkbox_BelloteTeamB:
                    Bellote_TeamA.setChecked(false);
                    break;
            }
        }
    }

    private class btnGoOnClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v)
        {
           if(ThreeCards_TeamA.isChecked()) TeamA.setBonus(Bonus.THREE_IN_A_ROW);
           if(ThreeCards_TeamB.isChecked()) TeamB.setBonus(Bonus.THREE_IN_A_ROW);
           if(FourCards_TeamA.isChecked()) TeamA.setBonus(Bonus.FOUR_IN_A_ROW);
           if(FourCards_TeamB.isChecked()) TeamB.setBonus(Bonus.FOUR_IN_A_ROW);
           if(FiveCards_TeamA.isChecked()) TeamA.setBonus(Bonus.FIVE_IN_A_ROW);
           if(FiveCards_TeamB.isChecked()) TeamB.setBonus(Bonus.FIVE_IN_A_ROW);

           if(Bellote_TeamA.isChecked()) TeamA.setBonus(Bonus.BELLOTE);
           if(Bellote_TeamB.isChecked()) TeamB.setBonus(Bonus.BELLOTE);

           if(FourJs_TeamA.isChecked()) TeamA.setBonus(Bonus.FOUR_Js);
           if(FourJs_TeamB.isChecked()) TeamB.setBonus(Bonus.FOUR_Js);
           if(Four9s_TeamA.isChecked()) TeamA.setBonus(Bonus.FOUR_9s);
           if(Four9s_TeamB.isChecked()) TeamB.setBonus(Bonus.FOUR_9s);
           if(FourA10KQs_TeamA.isChecked()) TeamA.setBonus(Bonus.FOUR_A10KQ);
           if(FourA10KQs_TeamB.isChecked()) TeamA.setBonus(Bonus.FOUR_A10KQ);





            Log.d("DEBUG","SUM UP:");
            Log.d("DEBUG","Team A score:"+TeamA.getBonus());
            Log.d("DEBUG","Team B score:"+TeamB.getBonus());

        }
    }

    private class QuadraHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            CheckBox checkBox = (CheckBox) v;

            switch (checkBox.getId())
            {
                case R.id.chkbox_FourA10KQs_TeamA:
                    FourA10KQs_TeamB.setChecked(false);
                    break;
                case R.id.chkbox_FourA10KQs_TeamB:
                    FourA10KQs_TeamA.setChecked(false);
                    break;
            }
        }

    }


    private class Quadra9sHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            CheckBox checkBox = (CheckBox) v;

            switch (checkBox.getId())
            {
                case R.id.chkbox_Four9s_TeamA:
                    Four9s_TeamB.setChecked(false);
                    break;
                case R.id.chkbox_Four9s_TeamB:
                    Four9s_TeamA.setChecked(false);
                    break;
            }
        }
    }

    private class QuadraJsHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            CheckBox checkBox = (CheckBox) v;
            switch (checkBox.getId())
            {
                case R.id.chkbox_FourJs_TeamA:
                    FourJs_TeamB.setChecked(false);
                    break;
                case R.id.chkbox_FourJs_TeamB:
                    FourJs_TeamA.setChecked(false);
                    break;
            }
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("TeamA",TeamA);
        outState.putParcelable("TeamB",TeamB);
        Log.d("Debg","Wannabe saved");
        Toast.makeText(this,"Wannabe saved",Toast.LENGTH_LONG).show();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Log.d("Debug","On stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Debug","On destroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("Debug","On pause");
        super.onPause();
    }
}
