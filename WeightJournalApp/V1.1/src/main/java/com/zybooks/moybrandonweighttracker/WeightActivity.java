package com.zybooks.moybrandonweighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WeightActivity extends AppCompatActivity {

    //creates widget access
    private Button smsButton;
    private Button add; //could not figure out how to create new rows
    private EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10;
    private Button d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        //Could not figure out how to assign different databases to different users.
        //In result, created a grid view of multiple weight entries.
        //nor could i get the user input to be saved in the list after exiting the app.
        et1 = findViewById(R.id.weightEntry1);
        et2 = findViewById(R.id.weightEntry2);
        et3 = findViewById(R.id.weightEntry3);
        et4 = findViewById(R.id.weightEntry4);
        et5 = findViewById(R.id.weightEntry5);
        et6 = findViewById(R.id.weightEntry6);
        et7 = findViewById(R.id.weightEntry7);
        et8 = findViewById(R.id.weightEntry8);
        et9 = findViewById(R.id.weightEntry9);
        et10 = findViewById(R.id.weightEntry10);

        //deletes entry in corresponding edit text by setting an OnClickListener for d1-d10
        d1 = findViewById(R.id.delBt1);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(" ");
            }
        });

        d2 = findViewById(R.id.delBt2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et2.setText(" ");
            }
        });
        d3 = findViewById(R.id.delBt3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et3.setText(" ");
            }
        });
        d4 = findViewById(R.id.delBt4);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et4.setText(" ");
            }
        });
        d5 = findViewById(R.id.delBt5);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et5.setText(" ");
            }
        });
        d6 = findViewById(R.id.delBt6);
        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et6.setText(" ");
            }
        });
        d7 = findViewById(R.id.delBt7);
        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et7.setText(" ");
            }
        });
        d8 = findViewById(R.id.delBt8);
        d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et8.setText(" ");
            }
        });
        d9 = findViewById(R.id.delBt9);
        d9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et9.setText(" ");
            }
        });
        d10 = findViewById(R.id.delBt10);
        d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et10.setText(" ");
            }
        });

        //sms button functionality
        smsButton = findViewById(R.id.SMS_Button);
        //sets up if smsButton is clicked, takes them to sms activity
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //takes user to SMS activity
                Intent smsIntent = new Intent(WeightActivity.this, SMS_Activity.class);
                startActivity(smsIntent);

            }
        });

        add = findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo create function that would create new row below the latest one.
                //not sure how to do this
                Toast.makeText(WeightActivity.this, "Should create a new row, but does not", Toast.LENGTH_SHORT).show();
            }
        });
    }
}