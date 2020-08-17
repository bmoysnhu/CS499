package com.zybooks.moybrandonweighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeightActivity extends AppCompatActivity {

    //creates widget access
    private Button smsButton;

    //todo create functionality for delete and edit buttons
    //may delete the edit button, allowing the user to just click the entry and edit it there
    //todo possibly change grid to a list? offers better edit/delete features

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        //connecting widgets variables to actually widgets in xmls
        //makes SMS_button display the activity_s_m_s screen when clicked
        //purpose is to view the activity sms screen in the application
        smsButton = findViewById(R.id.SMS_Button);
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSMSOption();
            }
        });
    }
    //purpose is to view the SMS activity in the application
    //starts the SMS_Activity screen
    public void openSMSOption(){
        Intent intent = new Intent(this, SMS_Activity.class);
        startActivity(intent);
    }
}