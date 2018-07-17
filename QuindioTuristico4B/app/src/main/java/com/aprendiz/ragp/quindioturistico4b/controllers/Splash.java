package com.aprendiz.ragp.quindioturistico4b.controllers;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aprendiz.ragp.quindioturistico4b.R;

import com.aprendiz.ragp.quindioturistico4b.models.GestorDB;
import com.aprendiz.ragp.quindioturistico4b.models.ListasSitios;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        inputData();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, ActivityMenu.class);
                startActivity(intent);
                finish();

            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,1500);
    }

    public void inputData(){
        GestorDB gestorDB  = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SITIOS",null);
        if (!cursor.moveToFirst()) {
            ListasSitios.inputHoteles();
            ListasSitios.inputSitios();
            ListasSitios.inputRes();

            for (int i = 0; i<ListasSitios.listaHoteles.length; i++){
                gestorDB.inputData(ListasSitios.listaHoteles[i]);
            }

            for (int i = 0; i<ListasSitios.listaRestaurantes.length; i++){
                gestorDB.inputData(ListasSitios.listaRestaurantes[i]);
            }

            for (int i = 0; i<ListasSitios.listaSitios.length; i++){
                gestorDB.inputData(ListasSitios.listaSitios[i]);
            }

        }
    }


}
