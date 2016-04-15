package com.house.sora.bellotecounter.EventHandlers;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SoRa on 5/4/2016.
 */
public class NumericalButtonsEventHandler implements View.OnClickListener {

    EditText editText;
    Button btn;

    public NumericalButtonsEventHandler(EditText editText, Button btn)
    {
        this.editText = editText;
        this.btn = btn;
    }

    @Override
    public void onClick(View v)
    {
        editText.setText(editText.getText() + String.valueOf(btn.getText()));
        Log.d("TAG", "ASDAD2456");
    }
}
