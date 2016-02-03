package com.example.estacionvl_tc_014.cinestar.adapters;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.estacionvl_tc_014.cinestar.R;
import com.example.estacionvl_tc_014.cinestar.models.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by EstacionVL-TC-014 on 2/02/16.
 */
public class PeliculaAdapter extends BaseAdapter{

    Activity activity;
    List<Pelicula> data;

    public PeliculaAdapter(Activity activity, List<Pelicula> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null)
            v = View.inflate(activity, R.layout.template_pelicula, null);

        Pelicula p = data.get(position);

        TextView titulo = (TextView) v.findViewById(R.id.title);
        titulo.setText(p.getNombre());

        TextView score = (TextView) v.findViewById(R.id.txt_score);
        score.setText(""+p.getCalificacion());

        TextView duracion = (TextView) v.findViewById(R.id.txt_time);
        duracion.setText(p.getDuracion());

        ImageView img = (ImageView) v.findViewById(R.id.img);

        Picasso.with(activity).load(Uri.parse(p.getUrl())).into(img);



        return v;
    }
}
