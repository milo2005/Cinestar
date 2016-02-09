package com.example.estacionvl_tc_014.cinestar.models;

import com.orm.SugarRecord;

/**
 * Created by EstacionVL-TC-014 on 9/02/16.
 */
public class Usuario extends SugarRecord{

    String nombre;
    String usr;
    String pass;
    String imgProfile;
    String imgBanner;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public static void init(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Dario Chamorro");
        usuario.setUsr("dar");
        usuario.setPass("123");
        usuario.setImgProfile("https://goo.gl/uk6qTN");
        usuario.setImgBanner("http://goo.gl/T6PZLC");
        usuario.save();
    }
}
