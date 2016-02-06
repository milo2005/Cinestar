package com.example.estacionvl_tc_014.cinestar;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.estacionvl_tc_014.cinestar.adapters.PeliculaAdapter;
import com.example.estacionvl_tc_014.cinestar.models.Pelicula;
import com.example.estacionvl_tc_014.cinestar.util.C;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    ListView list;


    PeliculaAdapter adapter;

    DrawerLayout drawer;
    NavigationView nav;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        C.data = new ArrayList<>();
        adapter = new PeliculaAdapter(this, C.data);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        cargarPeliculas();

        //METODOS DEL DRAWER LAYOUT

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        nav = (NavigationView) findViewById(R.id.nav);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawer
                , R.string.open_nav, R.string.close_nav);

        drawer.setDrawerListener(this);
        nav.setNavigationItemSelectedListener(this);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    //region Cargar Peliculas
    public void cargarPeliculas(){
        Pelicula p1 = new Pelicula();
        p1.setNombre("Batman v Superman");
        p1.setDuracion("160 minutos");
        p1.setCalificacion(5.0f);
        p1.setUrl("http://cine3.com/wp-content/uploads/2015/07/BVS-Empire.jpg");

        Pelicula p2 = new Pelicula();
        p2.setNombre("Deadpool");
        p2.setDuracion("140 minutos");
        p2.setCalificacion(4.5f);
        p2.setUrl("http://cdn.idigitaltimes.com/sites/idigitaltimes.com/files/2015/12/14/new-deadpool-promo-images-offer-hints-movie-s-unconventional-tone-492440.jpg");


        Pelicula p3 = new Pelicula();
        p3.setNombre("Warcraft");
        p3.setDuracion("150 minutos");
        p3.setCalificacion(4.0f);
        p3.setUrl("http://static.srcdn.com/slir/w786-h393-q90-c786:393/wp-content/uploads/warcraft-movie-posters-logo.jpg");

        Pelicula p4 = new Pelicula();
        p4.setNombre("Civil War");
        p4.setDuracion("140 minutos");
        p4.setCalificacion(4.0f);
        p4.setUrl("https://qph.is.quoracdn.net/main-qimg-2292e23e3c5310e8cef43240ef58cbee?convert_to_webp=true");

        C.data.add(p1);
        C.data.add(p2);
        C.data.add(p3);
        C.data.add(p4);

        adapter.notifyDataSetChanged();

    }
    //endregion


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
            return  true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView,slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawers();
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetalleActivity.class);
        startActivity(intent);
    }
}
