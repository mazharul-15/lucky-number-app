package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /// defining widgets
    EditText text;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText4);
        btn = findViewById(R.id.button2);

        /// btn setting function
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = text.getText().toString();

                /// Explicit Intent
                Intent i = new Intent(
                        getApplicationContext(),
                        secondAcivity.class);

                /// putting data into intent i
                i.putExtra("name", userName);

                /// passing to second Activity
                startActivity(i);
            }
        });
    }
}