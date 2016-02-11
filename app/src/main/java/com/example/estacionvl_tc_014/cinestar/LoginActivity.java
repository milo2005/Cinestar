package com.example.estacionvl_tc_014.cinestar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.estacionvl_tc_014.cinestar.models.Usuario;
import com.example.estacionvl_tc_014.cinestar.util.Preferences;
import com.orm.SugarContext;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout usr,pass;
    Button in,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SugarContext.init(this);

        usr = (TextInputLayout) findViewById(R.id.usr);
        pass = (TextInputLayout) findViewById(R.id.pass);

        in = (Button) findViewById(R.id.entrar);
        reg = (Button) findViewById(R.id.registrar);

        in.setOnClickListener(this);

        if(Usuario.count(Usuario.class)<1){
            Usuario.init();
        }



    }

    @Override
    public void onClick(View v) {

        String u = usr.getEditText().getText().toString();
        String p = pass.getEditText().getText().toString();

        List<Usuario> result = Usuario.find(Usuario.class
                ,"usr = ? AND pass = ?",u,p);

        if(result.size()>0){
            SharedPreferences preferences = getSharedPreferences(Preferences.PREFERENCE_NAME
                    ,MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putBoolean(Preferences.PREFERENCE_LOGGED, true);
            editor.commit();


            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario o Contraseña Incorrecto", Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
