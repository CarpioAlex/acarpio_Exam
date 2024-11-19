package com.acarpio.acarpio_exam;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

public class Fragment3RGB extends Fragment {

    private int red = 0, green = 0, blue = 0;


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment3rgb, container, false);

        // Getting the views

        SeekBar seekBarRed = view.findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = view.findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = view.findViewById(R.id.seekBarBlue);


        Button changeColorButton = view.findViewById(R.id.changeColorButton);


        // RGB Listeners

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        changeColorButton.setOnClickListener(v -> {

            int color = Color.rgb(red, green, blue);

            Fragment2TextResultado  fragment2 = (Fragment2TextResultado) getFragmentManager().findFragmentById(R.id.fragmentContainerView2);

            if (fragment2 != null) {
                fragment2.updateTextColor(color);
            }
        });

        return view;
    }
}
