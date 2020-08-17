package com.zybooks.moybrandonweighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {
    //purpose is to view the activity weight screen in the application
    private Button openWeightAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //connecting widgets variables to actually widgets in xmls
        //makes create_button display the activity_weight screen when clicked
        //purpose is to view the activity weight screen in the application
        //todo change this button to add entries into database.
        openWeightAct = findViewById(R.id.create_button);
        openWeightAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeightActivity();
            }
        });
    }

    //purpose is to view the activity weight screen in the application
    //starts the WeightActivity screen
    public void openWeightActivity(){
        Intent intent = new Intent(this, WeightActivity.class);
        startActivity(intent);
    }
}

//todo add dynamic disable, enable to login button

