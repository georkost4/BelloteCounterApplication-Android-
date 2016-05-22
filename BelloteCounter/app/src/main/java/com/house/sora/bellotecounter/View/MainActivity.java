package com.house.sora.bellotecounter.View;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.house.sora.bellotecounter.Controller.Bonus;
import com.house.sora.bellotecounter.Controller.RoundController;
import com.house.sora.bellotecounter.Model.modelTeam;
import com.house.sora.bellotecounter.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "DEBUG";
    private static  Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnGO;
    private static ImageButton btnBackSpace;
    private static EditText editTextTeamA,editTextTeamB;
    private static ListView listViewTEAM_A,listViewTEAM_B;
    private static  ArrayList<String> arrayListA,arrayListB;
    private static ArrayAdapter<String> adapterA,adapterB;
    private static TextView textViewTeamA,textViewTeamB;
    private static modelTeam TeamA,TeamB;
    private static LinearLayout layoutA;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllComponents();
    }

    private void initializeAllComponents()
    {
        TeamA = new modelTeam();
        TeamB = new modelTeam();

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

        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
                                });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { numericKeyPadOnClickEvent(v);  }
        });

        btnBackSpace = (ImageButton) findViewById(R.id.btnBackSpace);

        editTextTeamA = (EditText) findViewById(R.id.txtScoreA);
        editTextTeamB = (EditText) findViewById(R.id.txtScoreB);

        editTextTeamA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onTextChangeEvent(s, before);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTextTeamB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onTextChangeEvent(s, before);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listViewTEAM_A = (ListView) findViewById(R.id.listViewA);
        listViewTEAM_B = (ListView) findViewById(R.id.listViewB);

        textViewTeamA = (TextView) findViewById(R.id.textViewTeamA);
        textViewTeamB = (TextView) findViewById(R.id.textViewTeamB);


        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBackSpaceOnClickEvent(v);
            }
        });


        btnGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGoOnClickEvent();
            }
        });


        textViewTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewTeamOnClick(v);
            }
        });
        textViewTeamA.setBackgroundColor(Color.rgb(198,194,215));
        TeamA.setBidded(true);
        textViewTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewTeamOnClick(v);
            }
        });

        arrayListA = new ArrayList<String>();
        arrayListB = new ArrayList<>();

        adapterA = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,arrayListA);
        adapterB = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,arrayListB);

        listViewTEAM_A.setAdapter(adapterA);
        listViewTEAM_B.setAdapter(adapterB);
    }

    private void textViewTeamOnClick(View v) {
        if(v.getId() == findViewById(R.id.textViewTeamA).getId())
        {
            v.setBackgroundColor(Color.rgb(198,194,215));
            TeamA.setBidded(true);
            TeamB.setBidded(false);
            findViewById(R.id.textViewTeamB).setBackgroundColor(Color.WHITE);

        }
        else
        {
            v.setBackgroundColor(Color.rgb(198,194,215));
            TeamB.setBidded(true);
            TeamA.setBidded(false);
            findViewById(R.id.textViewTeamA).setBackgroundColor(Color.WHITE);
        }
    }

    private void btnGoOnClickEvent() {
        startActivityForResult(new Intent(this, BonusView.class),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 1)
        {
            Bundle dat = data.getExtras();
            modelTeam teamABonus = dat.getParcelable("teamA");
            modelTeam teamBBonus = data.getExtras().getParcelable("teamB");
            String lol = (String) data.getExtras().get("putses");
            Log.d(TAG, lol);
            TeamA.setBonus(teamABonus.getBonus());
            TeamB.setBonus(teamBBonus.getBonus());

            Log.d(TAG, "Team A bonus = " + String.valueOf(TeamA.getBonus()));
            Log.d(TAG, "Team B bonus = " + String.valueOf(TeamB.getBonus()));

            Toast.makeText(getApplicationContext(), "balls", Toast.LENGTH_SHORT).show();

            RoundController controller = new RoundController();
        }
//
//        Log.d("DEBUG","EDW");
//        if(editTextTeamA.hasFocus()&&!editTextTeamA.getText().toString().equals(""))
//        {
//
//            controller.countRound(TeamA,TeamB,editTextTeamA);
//
//            adapterB.add(String.valueOf(TeamB.getScore()));
//            adapterA.add(String.valueOf(TeamA.getScore()));
//            editTextTeamA.setText("");
//            editTextTeamB.setText("");
//        }
//        else if(editTextTeamB.hasFocus()&& !editTextTeamB.getText().toString().equals(""))
//        {
//            controller.countRound(TeamA,TeamB,editTextTeamB);
//
//            adapterB.add(String.valueOf(TeamB.getScore()));
//            adapterA.add(String.valueOf(TeamA.getScore()));
//            editTextTeamA.setText("");
//            editTextTeamB.setText("");
//        }
//        else Toast.makeText(getApplicationContext(),"Enter a score",Toast.LENGTH_SHORT).show();
//        Log.d("DEBUG","EDW3");
    }

    private void onTextChangeEvent(CharSequence s, int before) {
        if(s.length() != 0)
        {
            int number = Integer.parseInt(String.valueOf(s));


            if(editTextTeamA.hasFocus())
            {
                if (number > 162) { editTextTeamA.setText(editTextTeamA.getText().delete(editTextTeamA.getText().length() - 1, editTextTeamA.getText().length()));}
            }
            if (editTextTeamB.hasFocus())
            {
                if (number > 162) { editTextTeamA.setText(editTextTeamA.getText().delete(editTextTeamA.getText().length() - 1, editTextTeamA.getText().length()));}
            }
        }
    }


    private void btnBackSpaceOnClickEvent(View v)
    {
        try
        {
            if (editTextTeamA.isFocused())
                editTextTeamA.setText(editTextTeamA.getText().delete(editTextTeamA.length() - 1, editTextTeamA.length()));
            if (editTextTeamB.isFocused())
                editTextTeamB.setText(editTextTeamB.getText().delete(editTextTeamB.length() - 1, editTextTeamB.length()));
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
            Toast.makeText(v.getContext(), "Nothing to delete.", Toast.LENGTH_SHORT).show();
        }
    }


    private  void numericKeyPadOnClickEvent(View v)
    {
       Button button = (Button) v;
       if(editTextTeamA.isFocused())
       {
           editTextTeamA.setText(String.valueOf(editTextTeamA.getText())+button.getText());
       }
       if(editTextTeamB.isFocused())
       {
           editTextTeamB.setText(String.valueOf(editTextTeamB.getText())+button.getText());
       }
    }





}
