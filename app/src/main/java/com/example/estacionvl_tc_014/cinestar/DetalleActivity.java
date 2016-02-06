package com.example.estacionvl_tc_014.cinestar;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.estacionvl_tc_014.cinestar.models.Pelicula;
import com.example.estacionvl_tc_014.cinestar.util.C;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class DetalleActivity extends AppCompatActivity implements Callback {

    ImageView imageView;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        int pos =  getIntent().getIntExtra("pos",0);

        imageView = (ImageView) findViewById(R.id.img);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.collpasing);

        setSupportActionBar(toolbar);



        Pelicula p = C.data.get(pos);

        collapsingToolbarLayout.setTitle(p.getNombre());
        Picasso.with(this).load(Uri.parse(p.getUrl())).into(imageView, this);




    }

    @Override
    public void onSuccess() {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();

        Palette palette = Palette.from(drawable.getBitmap()).generate();

        int colorPrimary = ContextCompat.getColor(this, R.color.colorPrimary);
        int colorVibrant = palette.getVibrantColor(colorPrimary);

        collapsingToolbarLayout.setContentScrimColor(colorVibrant);
    }

    @Override
    public void onError() {

    }
}
