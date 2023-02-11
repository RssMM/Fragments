package com.example.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado frgListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.frgListado);
        frgListado.setCorreosListener(new CorreoListener() {
            @Override
            public void onCorreoSeleccionado(Correo correo) {
                FragmentDetalle frgDetalle = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
                if (frgDetalle != null){
                    frgDetalle.mostrarDetall(correo.getTexto());
                }
                else {
                    Intent i = new Intent(getApplicationContext(), DetalleActivity.class);
                    i.putExtra(DetalleActivity.EXTRA_TEXTO, correo.getTexto());
                    startActivity(i);
                }
            }
        });
    }
}