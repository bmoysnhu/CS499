package com.zybooks.moybrandonweighttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.security.auth.login.LoginException;

public class CreateLoginActivity extends AppCompatActivity {

    //connecting widgets variables to actually widgets in xmls
    private EditText userName;
    private EditText userPhone;
    private EditText userPassword;
    private Button registerButton;
    private TextView existingAccount;
    private TextView topTextView;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_login);

        //setups ui views
        db = new DatabaseHelper(this);
        userName = (EditText) findViewById(R.id.editText_createUsername);
        userPassword = (EditText) findViewById(R.id.editText_createPassword);
        userPhone = (EditText) findViewById(R.id.editText_createPhoneNumber);
        registerButton = (Button) findViewById(R.id.regButton);
        existingAccount = (TextView) findViewById(R.id.existingLogin);
        topTextView = (TextView) findViewById(R.id.CreateInstructions);

        //sets up button control to register users
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString().trim();
                String password = userPassword.getText().toString().trim();
                String phonenumber = userPhone.getText().toString().trim();

                //if fields are not empty, app will add user, password, and phonenumber to the database
                //and take them back to the login menu
                if (!user.isEmpty() && !password.isEmpty() && !phonenumber.isEmpty()){
                    //checks to see if username, password are already in database. If there is,
                    //will present user with an error.
                    //In a real situation, it should only be username. I tried to do this by deleting
                    //password from () in checkAccount and different classes, but it would still register
                    //the same username.
                    Boolean result = db.checkAccount(user, password);
                    if (result == false){
                        db.addUser(user,password,phonenumber);
                        topTextView.setText("Registration Successful");
                        Intent loginIntent = new Intent (CreateLoginActivity.this, LogInActivity.class);
                        startActivity(loginIntent);
                    }
                    else{
                        topTextView.setText("Invalid Login, Account exist, or Fields incomplete.");
                    }
                }
            }
        });

        //takes user back to login page if account exist, but have to click the textview
        existingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateLoginActivity.this,LogInActivity.class));
            }
        });
    }

}