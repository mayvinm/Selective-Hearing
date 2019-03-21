package com.example.signit;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences fileWriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Button createAccount = findViewById(R.id.createAccount);
        createAccount.setOnClickListener(this);
        fileWriter = getSharedPreferences("loginFile", MODE_PRIVATE);
    }
    @Override
    public void onClick(View view){
        EditText usernameField = (EditText) findViewById(R.id.usernameField);
        EditText passwordField = (EditText) findViewById(R.id.passwordField);

        String enteredUname = (usernameField.getText()).toString();
        String enteredPword = (passwordField.getText()).toString();

        fileWriter.edit().putString("userID", enteredUname);
        fileWriter.edit().putString("pass", enteredPword);
    }
}
