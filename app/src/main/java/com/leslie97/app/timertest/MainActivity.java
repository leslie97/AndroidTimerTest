package com.leslie97.app.timertest;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mText;
    private boolean mToggle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.timer_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStart();
            }
        });

        mText = findViewById(R.id.timer_text);
    }

    private void timerStart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mToggle) {
                    mText.setText("This text will change 5 seconds after you push the button.");
                } else {
                    mText.setText("The text was changed.");
                }
                mToggle = !mToggle;
            }
        }, 5000);
    }
}