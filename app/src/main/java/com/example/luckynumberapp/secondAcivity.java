package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class secondAcivity extends AppCompatActivity {

    TextView luckyNumber;
    Button shareBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acivity);

        // getting widgets
        luckyNumber = findViewById(R.id.lucky_number_text);
        shareBtn = findViewById(R.id.share_btn);

        // getting data from main activity
        Intent i = getIntent();
        String name = i.getStringExtra("name");

        // Random number generating;
        int randomNumber = randomNumberGenerating();
        luckyNumber.setText(""+randomNumber);

        /// sharing data to other applications
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(name, randomNumber);
            }
        });

    }

    public int randomNumberGenerating() {
        Random random = new Random();
        int up_limit = 1000;
        int randomNumber = random.nextInt(up_limit);

        return randomNumber;
    }

    public void shareData(String name, int luckyNumber) {
        // implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, name+" got lucky number");
        i.putExtra(Intent.EXTRA_TEXT, "His Lukcy Number is: " + luckyNumber);

        startActivity(Intent.createChooser(i, "choose a platform"));
    }
}