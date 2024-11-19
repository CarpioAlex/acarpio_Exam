package com.acarpio.acarpio_exam;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

public class Fragment1TextBar extends Fragment {

    private Fragment2TextResultado fragment2;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        // Getting the views

        View view = inflater.inflate(R.layout.fragment1_text_bar, container, false);


        Button changeText = view.findViewById(R.id.changeTextButton);
        EditText editText = view.findViewById(R.id.editText);
        SeekBar seekBar = view.findViewById(R.id.seekBar);

        // Button listener

        changeText.setOnClickListener(v -> {

            String text = editText.getText().toString();

            // Retrieving the target fragment
            fragment2 = (Fragment2TextResultado) getFragmentManager().findFragmentById(R.id.fragmentContainerView2);




            if (fragment2 != null) {
                fragment2.updateText(text);
            }
        });


        // Listeners

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //Every time that the bar moves...
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {



                if (fragment2 != null) {
                    float textSize = progress + 12;
                    fragment2.updateTextSize(textSize);
                    Log.d("TEST", "Progress: " + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        return view;
    }
}
