package com.house.sora.bellotecounter.View;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.house.sora.bellotecounter.Controller.RoundController;
import com.house.sora.bellotecounter.EventHandlers.ButtonBackSpaceEventHandler;
import com.house.sora.bellotecounter.EventHandlers.EditTextEventHandler;
import com.house.sora.bellotecounter.EventHandlers.NumericalButtonsEventHandler;
import com.house.sora.bellotecounter.Model.modelTeam;
import com.house.sora.bellotecounter.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private static  boolean TEAM_A_BIDDING = false,TEAM_B_BIDDING = false;
    private static  Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnGO;
    private static ImageButton btnBackSpace;
    private static EditText editTextTeamA,editTextTeamB;
    private static ListView listViewTEAM_A,listViewTEAM_B;
    private static  ArrayList<String> arrayListA,arrayListB;
    private static ArrayAdapter<String> adapterA,adapterB;
    private static TextView textViewTeamA,textViewTeamB;
    private static modelTeam TeamA = new modelTeam();
    private static modelTeam TeamB = new modelTeam();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllComponents();

        Intent intent = new Intent(MainActivity.this,new BonusView().getClass());
        startActivity(intent);


    }

    private void initializeAllComponents()
    {
        btn0 = (Button) findViewById(R.id.btnZero);
        btn1 = (Button) findViewById(R.id.btnOne);
        btn2 = (Button) findViewById(R.id.btnTwo);
        btn3 = (Button) findViewById(R.id.btnThree);
        btn4 = (Button) findViewById(R.id.btnFour);
        btn5 = (Button) findViewById(R.id.btnFive);
        btn6 = (Button) findViewById(R.id.btnSix);
        btn7 = (Button) findViewById(R.id.btnSeven);
        btn8 = (Button) findViewById(R.id.btnEight);
        btn9 = (Button) findViewById(R.id.btnNine);
        btnGO = (Button) findViewById(R.id.btnGo);

        btnBackSpace = (ImageButton) findViewById(R.id.btnBackSpace);

        editTextTeamA = (EditText) findViewById(R.id.txtScoreA);
        editTextTeamB = (EditText) findViewById(R.id.txtScoreB);

        listViewTEAM_A = (ListView) findViewById(R.id.listViewA);
        listViewTEAM_B = (ListView) findViewById(R.id.listViewB);

        textViewTeamA = (TextView) findViewById(R.id.textViewTeamA);
        textViewTeamB = (TextView) findViewById(R.id.textViewTeamB);





        btnGO.setOnClickListener(new btnGOEventHandler());


        editTextTeamA.setOnFocusChangeListener(new EditTextEventHandler());
        editTextTeamB.setOnFocusChangeListener(new EditTextEventHandler());

        btnBackSpace.setOnClickListener(new ButtonBackSpaceEventHandler(editTextTeamA,editTextTeamB));

        textViewTeamA.setOnClickListener(new textViewEventHandler());
        textViewTeamB.setOnClickListener(new textViewEventHandler());

        arrayListA = new ArrayList<String>();
        arrayListB = new ArrayList<>();



        adapterA = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,arrayListA);
        adapterB = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,arrayListB);


        listViewTEAM_A.setAdapter(adapterA);
        listViewTEAM_B.setAdapter(adapterB);
    }




    public static void setNumericalButtonEventListeners(EditText editText)
    {
        btn1.setOnClickListener(new NumericalButtonsEventHandler(editText, btn1));
        btn2.setOnClickListener(new NumericalButtonsEventHandler(editText, btn2));
        btn3.setOnClickListener(new NumericalButtonsEventHandler(editText, btn3));
        btn4.setOnClickListener(new NumericalButtonsEventHandler(editText, btn4));
        btn5.setOnClickListener(new NumericalButtonsEventHandler(editText, btn5));
        btn6.setOnClickListener(new NumericalButtonsEventHandler(editText, btn6));
        btn7.setOnClickListener(new NumericalButtonsEventHandler(editText, btn7));
        btn8.setOnClickListener(new NumericalButtonsEventHandler(editText, btn8));
        btn9.setOnClickListener(new NumericalButtonsEventHandler(editText, btn9));
        btn0.setOnClickListener(new NumericalButtonsEventHandler(editText, btn0));
    }




    private class textViewEventHandler implements  View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            if(v.getId() == findViewById(R.id.textViewTeamA).getId())
            {
                v.setBackgroundColor(Color.CYAN);
                TeamA.setBidded(true);
                TeamB.setBidded(false);
                findViewById(R.id.textViewTeamB).setBackgroundColor(Color.WHITE);

            }
            else
            {
                v.setBackgroundColor(Color.CYAN);
                TeamB.setBidded(true);
                TeamA.setBidded(false);
                findViewById(R.id.textViewTeamA).setBackgroundColor(Color.WHITE);
            }

        }
    }
    private class btnGOEventHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            RoundController controller = new RoundController();

            Log.d("DEBUG","EDW");
            if(editTextTeamA.hasFocus()&&!editTextTeamA.getText().toString().equals(""))
            {

                controller.countRound(TeamA,TeamB,editTextTeamA);

                adapterB.add(String.valueOf(TeamB.getScore()));
                adapterA.add(String.valueOf(TeamA.getScore()));
                editTextTeamA.setText("");
                editTextTeamB.setText("");
            }
            else if(editTextTeamB.hasFocus()&& !editTextTeamB.getText().toString().equals(""))
            {
                controller.countRound(TeamA,TeamB,editTextTeamB);

                adapterB.add(String.valueOf(TeamB.getScore()));
                adapterA.add(String.valueOf(TeamA.getScore()));
                editTextTeamA.setText("");
                editTextTeamB.setText("");
            }
            else Toast.makeText(getApplicationContext(),"Enter a score",Toast.LENGTH_SHORT).show();
            Log.d("DEBUG","EDW3");


        }
    }


}
