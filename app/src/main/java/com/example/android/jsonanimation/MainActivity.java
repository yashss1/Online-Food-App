package com.example.android.jsonanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    TextView master_text;
    // Use LottieFiles for downloading sizable animations
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        master_text = findViewById(R.id.master_yash);
//        master_text.setVisibility(View.INVISIBLE);
//        master_text.setAlpha(1f);
//        master_text.animate()
//                .alpha(0f)
//                .setDuration(1000)
//                .setStartDelay(4000);
    }
}