package com.house.sora.bellotecounter.EventHandlers;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.house.sora.bellotecounter.R;
import com.house.sora.bellotecounter.View.MainActivity;

/**
 * Created by SoRa on 8/4/2016.
 */
public class ButtonBackSpaceEventHandler implements View.OnClickListener
{
    EditText editText;
    EditText editText1;

    public ButtonBackSpaceEventHandler(EditText editText1,EditText editText2)
    {
        this.editText = editText1;
        this.editText1 = editText2;
    }

    @Override
    public void onClick(View v)
    {
        try
        {
            if (editText.isFocused())
                editText.setText(editText.getText().delete(editText.length() - 1, editText.length()));
            if (editText1.isFocused())
                editText1.setText(editText1.getText().delete(editText1.length() - 1, editText1.length()));
        }
        catch (IndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
            Toast.makeText(v.getContext(),"Nothing to delete.",Toast.LENGTH_SHORT).show();
        }

    }
}
