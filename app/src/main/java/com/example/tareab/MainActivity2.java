package com.example.tareab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

        losEstados [0] = "Disponible";
        losEstados [1] = "Control de calidad";
        losEstados [2] = "No vigente";
        losEstados [3] = "En tránsito";

        adaptadorEstados = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, losEstados);
        spnEstado.setAdapter(adaptadorEstados);

    }//end OnCreate




    private void referencias () {
        etIdProducto = findViewById(R.id.etIdProd);
        etNombreProd = findViewById(R.id.etNombreProd);
        actvTipo = findViewById(R.id.actvTipo);
        spnEstado = findViewById(R.id.spnEstado);
        btnOk = findViewById(R.id.btnOk);
        btnVolver = findViewById(R.id.btnVolver);
    } // end referencias

}//end end