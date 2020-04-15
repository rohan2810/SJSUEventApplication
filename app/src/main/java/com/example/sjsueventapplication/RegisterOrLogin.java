package com.example.sjsueventapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class RegisterOrLogin extends AppCompatActivity implements View.OnClickListener
{
    private Button registerButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_or_login);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view == loginButton)
        {
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (view == registerButton)
        {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}
