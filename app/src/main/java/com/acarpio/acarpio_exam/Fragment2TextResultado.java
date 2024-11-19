package com.acarpio.acarpio_exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2TextResultado extends Fragment {

    private TextView textContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_text_resultado, (ViewGroup) container, false);

        textContainer = view.findViewById(R.id.textContainer);


        return view;


    }

    // Public methods

    // Updates the text

    public void updateText(String text) {
        textContainer.setText(text);
    }

    // Updates the size

    public void updateTextSize(float textSize) {
        if (textContainer != null) {
            textContainer.setTextSize(textSize);
        }
    }

    // Updates the color

    public void updateTextColor(int color) {
        if (textContainer != null) {
            textContainer.setTextColor(color);
        }
    }




}

