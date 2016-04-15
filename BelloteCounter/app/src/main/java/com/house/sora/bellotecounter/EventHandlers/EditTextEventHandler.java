package com.house.sora.bellotecounter.EventHandlers;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.house.sora.bellotecounter.View.MainActivity;

import java.lang.reflect.Method;

/**
 * Created by SoRa on 8/4/2016.
 */
public class EditTextEventHandler implements View.OnFocusChangeListener {

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus)
        {
            Log.d("DEBUG","YATA_A");
            if(hasFocus) MainActivity.setNumericalButtonEventListeners((EditText) v);
        }
    }
}
