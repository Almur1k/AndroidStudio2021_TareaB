package com.example.tareab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private EditText etIdProducto, etNombreProd;
    private AutoCompleteTextView actvTipo;
    private Button btnOk, btnVolver;
    private ArrayList<Productos> losProductos = new ArrayList<>();
    private ArrayAdapter adaptadorProductos;
    private Spinner spnEstado;
    private String[] losEstados = new String[4];
    private ArrayAdapter adaptadorEstados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        referencias();
        eventos();

        losEstados [0] = "Disponible";
        losEstados [1] = "Control de calidad";
        losEstados [2] = "No vigente";
        losEstados [3] = "En tránsito";

        adaptadorEstados = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, losEstados);
        spnEstado.setAdapter(adaptadorEstados);

        //evento en spinner -> saber qué se seleccionó
        spnEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this, "Seleccionó estado: " + losEstados[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }//end OnCreate

    private void clickBoton(View queBoton) {
        if(queBoton.getId() == R.id.btnOk) {
            }

        if(queBoton.getId() == R.id.btnVolver) {
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
    }//end clickBoton




    private void eventos() {
        //eventos de boton
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBoton(v);
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBoton(v);
            }
        });
    }



    private void referencias() {
        etIdProducto = findViewById(R.id.etIdProd);
        etNombreProd = findViewById(R.id.etNombreProd);
        actvTipo = findViewById(R.id.actvTipo);
        spnEstado = findViewById(R.id.spnEstado);
        btnOk = findViewById(R.id.btnOk);
        btnVolver = findViewById(R.id.btnVolver);
    } // end referencias

}//end end