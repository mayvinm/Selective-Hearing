package com.example.signit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button submitLogin = (Button) findViewById(R.id.submitLogin);
        submitLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        EditText usernameField = (EditText) findViewById(R.id.usernameField);
        EditText passwordField = (EditText) findViewById(R.id.passwordField);

        String enteredUname = ((SpannableStringBuilder)usernameField.getText()).toString();
        String enteredPword = ((SpannableStringBuilder)passwordField.getText()).toString();
    }
}
