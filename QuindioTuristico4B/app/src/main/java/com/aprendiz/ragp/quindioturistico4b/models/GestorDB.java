package com.aprendiz.ragp.quindioturistico4b.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GestorDB extends SQLiteOpenHelper {
    public GestorDB(Context context) {
        super(context, Constants.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.script);
    }

    public void inputData(Sitios sitios){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("IMAGEN",Integer.toString(sitios.getImagen()));
        values.put("NOMBRE",sitios.getNombre());
        values.put("DESCRIPCIONC",sitios.getDescripcionc());
        values.put("UBICACION",sitios.getUbicacion());
        values.put("DESCRIPCION",sitios.getDescripcion());
        values.put("LATITUD",sitios.getLatitud());
        values.put("LONGITUD",sitios.getLongitud());
        values.put("LUGAR",sitios.getLugar());
        db.insert("SITIOS",null,values);
        db.close();
    }

    public List<Sitios> listarHoteles(){
        List<Sitios> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SITIOS WHERE LUGAR ='hotel'",null);
        if (cursor.moveToFirst()){
            do {
                Sitios sitios = new Sitios();
                sitios.setImagen(Integer.parseInt(cursor.getString(0)));
                sitios.setNombre(cursor.getString(1));
                sitios.setDescripcionc(cursor.getString(2));
                sitios.setUbicacion(cursor.getString(3));
                sitios.setDescripcion(cursor.getString(4));
                sitios.setLatitud(cursor.getFloat(5));
                sitios.setLongitud(cursor.getFloat(6));
                sitios.setLugar(cursor.getString(7));

                results.add(sitios);


            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return results;
    }


    public List<Sitios> listarRestaurantes(){
        List<Sitios> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SITIOS WHERE LUGAR ='restaurante'",null);
        if (cursor.moveToFirst()){
            do {
                Sitios sitios = new Sitios();
                sitios.setImagen(Integer.parseInt(cursor.getString(0)));
                sitios.setNombre(cursor.getString(1));
                sitios.setDescripcionc(cursor.getString(2));
                sitios.setUbicacion(cursor.getString(3));
                sitios.setDescripcion(cursor.getString(4));
                sitios.setLatitud(cursor.getFloat(5));
                sitios.setLongitud(cursor.getFloat(6));
                sitios.setLugar(cursor.getString(7));

                results.add(sitios);


            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return results;
    }


    public List<Sitios> listarSitios(){
        List<Sitios> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SITIOS WHERE LUGAR ='sitio'",null);
        if (cursor.moveToFirst()){
            do {
                Sitios sitios = new Sitios();
                sitios.setImagen(Integer.parseInt(cursor.getString(0)));
                sitios.setNombre(cursor.getString(1));
                sitios.setDescripcionc(cursor.getString(2));
                sitios.setUbicacion(cursor.getString(3));
                sitios.setDescripcion(cursor.getString(4));
                sitios.setLatitud(cursor.getFloat(5));
                sitios.setLongitud(cursor.getFloat(6));
                sitios.setLugar(cursor.getString(7));

                results.add(sitios);


            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return results;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
