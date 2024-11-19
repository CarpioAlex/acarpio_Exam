package com.acarpio.acarpio_exam;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Finding the views

        View sky = findViewById(R.id.sky);
        ImageView sun = findViewById(R.id.sun);

        ImageView smileIcon = findViewById(R.id.smile_icon);



        // Changing activity

        Intent myIntent = new Intent(this, SeekBar.class);

        smileIcon.setOnClickListener(v -> {
            startActivity(myIntent);
            finish();

        });



        // Sun listener that starts the animation
        sun.setOnClickListener(v -> {startSunsetAnimation(sky, sun);
        });


        // Added extra listener on the sky just inc ase you click it on the seocnd time
        sky.setOnClickListener(v -> {
            if (sun.getTranslationY() == 0) {
                startSunsetAnimation(sky, sun);
            } else {
                sun.setTranslationY(0);
                sky.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_sky));
            }
        });

    }


    private void startSunsetAnimation(View sky, ImageView sun) {


        // Total duration of the animation

        long animationDuration = 4000;


        // Object animator

        ObjectAnimator sunAnimator = ObjectAnimator.ofFloat(sun, "translationY", 1200f);
        sunAnimator.setDuration(animationDuration);

        // This always makes the animations better (not sure why)
        sunAnimator.setInterpolator(new AccelerateDecelerateInterpolator());


        // Colors

        int daySkyColor = ContextCompat.getColor(this, R.color.blue_sky);
        int sunsetSkyColor = ContextCompat.getColor(this, R.color.sunset_sky);
        int orangeSkyColor = ContextCompat.getColor(this, R.color.orange);
        int nightSkyColor = ContextCompat.getColor(this, R.color.night_sky);


        ValueAnimator skyAnimator = ValueAnimator.ofObject(
                new ArgbEvaluator(),
                daySkyColor,
                sunsetSkyColor,
                orangeSkyColor,
                nightSkyColor
        );
        skyAnimator.setDuration(animationDuration);
        skyAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        skyAnimator.addUpdateListener(animator -> sky.setBackgroundColor((int) animator.getAnimatedValue()));


        sunAnimator.start();
        skyAnimator.start();
    }

}




