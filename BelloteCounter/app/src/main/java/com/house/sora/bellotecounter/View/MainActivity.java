package com.house.sora.bellotecounter.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.house.sora.bellotecounter.Controller.ButtonEventHandler;
import com.house.sora.bellotecounter.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "ASDAD");
        final Button btn = (Button) findViewById(R.id.btnOne);
        btn.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn));

        final Button btn2 = (Button) findViewById(R.id.btnTwo);
        btn2.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn2));

        final Button btn3 = (Button) findViewById(R.id.btnThree);
        btn3.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn3));
        final Button btn4 = (Button) findViewById(R.id.btnFour);
        btn4.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn4));
        final Button btn5 = (Button) findViewById(R.id.btnFive);
        btn5.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn5));
        final Button btn6 = (Button) findViewById(R.id.btnSix);
        btn6.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn6));
        final Button btn7 = (Button) findViewById(R.id.btnSeven);
        btn7.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn7));
        final Button btn8 = (Button) findViewById(R.id.btnEight);
        btn8.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn8));
        final Button btn9 = (Button) findViewById(R.id.btnNine);
        btn9.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn9));
        final Button btn0 = (Button) findViewById(R.id.btnOne);
        btn.setOnClickListener(new ButtonEventHandler((TextView) findViewById(R.id.textView2), btn));

        ListView listView = (ListView) findViewById(R.id.listView);
        ListView listView2 = (ListView) findViewById(R.id.listView2);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("lola");
        arrayList.add("lola1");
        arrayList.add("lola2");
        arrayList.add("lola3");
        arrayList.add("lola4");
        arrayList.add("lola5");
        arrayList.add("lola23");
        arrayList.add("lola");
        arrayList.add("lol34a");
        arrayList.add("lo34la");
        arrayList.add("lola34");
        arrayList.add("lol43a");
        arrayList.add("lol745a");
        arrayList.add("lola999");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
    }
}