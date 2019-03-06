package com.example.signit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button) findViewById(R.id.login);
        Button createAccount = (Button) findViewById(R.id.createAccount);

        login.setOnClickListener(this);
        createAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent nextActivity;
        switch (v.getId()) {
            case R.id.login: //Start the login activity
                nextActivity = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(nextActivity);
                break;
            case R.id.createAccount: //Start the account creation
                nextActivity = new Intent(MainActivity.this, CreateAccountActivity.class);
                MainActivity.this.startActivity(nextActivity);
                break;
        }
    }
}
