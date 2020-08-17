package com.zybooks.moybrandonweighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {
    //purpose is to view the activity weight screen in the application
    //private Button openWeightAct;
    private EditText username;
    private EditText password;
    private Button Login;
    private TextView intro;
    private Button createLogin;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //connecting widgets variables to actually widgets in xmls
        db = new DatabaseHelper(this);
        username = (EditText) findViewById(R.id.editText_username);
        password = (EditText) findViewById(R.id.editText_password);
        Login = (Button) findViewById(R.id.login_button);
        intro = (TextView) findViewById(R.id.introText);
        createLogin = (Button) findViewById(R.id.create_button);

        //watches the username field for input
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            //enables the login button when username and password field has input
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String usernameInput = username.getText().toString();
                Login.setEnabled(!usernameInput.isEmpty());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //enables Login button to validate from validate class
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String user = username.getText().toString().trim();
              String pw = password.getText().toString().trim();
              Boolean result = db.checkAccount(user, pw);
              if (result ==  true){
                  Intent loginIntent = new Intent(LogInActivity.this, WeightActivity.class);
                  startActivity(loginIntent);
              }
              else{
                  intro.setText("Invalid Login.");
              }
            }
        });

        //enables create_button to go to CreateLoginActivity
        createLogin.setOnClickListener(new View.OnClickListener(){;
        public void onClick (View view) {
            Intent registerIntent = new Intent(LogInActivity.this, CreateLoginActivity.class);
            startActivity(registerIntent);
            }
        });
    }

}


