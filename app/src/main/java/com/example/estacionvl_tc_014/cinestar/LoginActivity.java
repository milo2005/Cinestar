package com.example.estacionvl_tc_014.cinestar;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout usr,pass;
    Button in,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr = (TextInputLayout) findViewById(R.id.usr);
        pass = (TextInputLayout) findViewById(R.id.pass);

        in = (Button) findViewById(R.id.entrar);
        reg = (Button) findViewById(R.id.registrar);

        in.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
