package com.example.estacionvl_tc_014.cinestar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.estacionvl_tc_014.cinestar.util.Preferences;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences =  getSharedPreferences(Preferences.PREFERENCE_NAME
                ,MODE_PRIVATE);
        boolean logged = preferences.getBoolean(Preferences.PREFERENCE_LOGGED, false);

        Intent intent = null;

        if(logged){
            intent = new Intent(this, MainActivity.class);
        }else{
            intent = new Intent(this, LoginActivity.class);
        }

        startActivity(intent);
    }
}
