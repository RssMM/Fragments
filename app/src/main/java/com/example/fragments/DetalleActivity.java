package com.example.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    public static String EXTRA_TEXTO = "com.example.fragments.EXTRA_TEXTO";
    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle detalle = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        detalle.mostrarDetall(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}