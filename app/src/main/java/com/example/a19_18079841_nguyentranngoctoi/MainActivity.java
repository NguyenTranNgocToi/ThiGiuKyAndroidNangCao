package com.example.a19_18079841_nguyentranngoctoi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView icon1,icon2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon1 =findViewById(R.id.imageView);
        icon2 =findViewById(R.id.imageView2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_icon);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.animation_icon2);
        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1.startAnimation(animation);
            }
        });
        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon2.startAnimation(animation2);
            }
        });

    }
}