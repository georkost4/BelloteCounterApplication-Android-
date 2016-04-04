package com.house.sora.bellotecounter.Controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SoRa on 5/4/2016.
 */
public class ButtonEventHandler implements View.OnClickListener {

    TextView textView;
    Button btn;

    public ButtonEventHandler(TextView textView, Button btn)
    {
        this.textView = textView;
        this.btn = btn;
    }

    @Override
    public void onClick(View v)
    {
        textView.setText(textView.getText() + String.valueOf(btn.getText()));
        Log.d("TAG", "ASDAD2456");
    }
}
