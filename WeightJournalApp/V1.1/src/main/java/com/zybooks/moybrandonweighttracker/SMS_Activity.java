package com.zybooks.moybrandonweighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SMS_Activity extends AppCompatActivity {

    //widgets variables
    private Button yes;
    private Button no;
    private TextView option;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s_);

        //connecting widgets variables to actually widgets in xmls
        yes = findViewById(R.id.yesButton);
        no = findViewById(R.id.noButton);
        option = findViewById(R.id.optionText);
        backButton = findViewById(R.id.bckbt);

        //back button to take back to weight activity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weightIntent = new Intent(SMS_Activity.this, WeightActivity.class);
                startActivity(weightIntent);
            }
        });

        //Option when yes is clicked
        yes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                option.setText("SMS Notifications Enabled!");
            }
        });
        //option when no is clicked
        no.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                option.setText("SMS Notifications Disabled!");
            }
        });
    }


}