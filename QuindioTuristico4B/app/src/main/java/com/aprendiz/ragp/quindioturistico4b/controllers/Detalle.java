package com.aprendiz.ragp.quindioturistico4b.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendiz.ragp.quindioturistico4b.R;
import com.aprendiz.ragp.quindioturistico4b.models.Sitios;

public class Detalle extends AppCompatActivity {
    ImageView imageView;
    TextView txtnombre;
    TextView txtdescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        imageView = findViewById(R.id.imgDetalle);
        txtnombre = findViewById(R.id.txtnombreDetalle);
        txtdescripcion = findViewById(R.id.txtDescricpcionDetalle);

        inputData();
    }

    private void inputData() {
        Sitios sitios = ActivityMenu.sitios;
        BitmapFactory.Options op = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), sitios.getImagen(),op);
        imageView.setImageBitmap(bitmap);
        txtnombre.setText(sitios.getNombre());
        txtdescripcion.setText(sitios.getDescripcion());
    }
}
