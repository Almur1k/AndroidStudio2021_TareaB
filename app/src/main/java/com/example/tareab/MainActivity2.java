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
    private AutoCompleteTextView actTipo;
    private ArrayAdapter adaptadorTipo;
    private ArrayList<TipoProducto> tipoProd = new ArrayList<>();
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

        // llenar array con info de estado de los productos para spinner
        losEstados [0] = "Disponible";
        losEstados [1] = "Control de calidad";
        losEstados [2] = "No vigente";
        losEstados [3] = "En tránsito";

        //unir spinner con array
        adaptadorEstados = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, losEstados);
        spnEstado.setAdapter(adaptadorEstados);

        //evento en spinner -> saber qué se seleccionó
        spnEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //position nos entrega la posicion del item en el spinner de forma automatica
                Toast.makeText(MainActivity2.this, "Seleccionó estado: " + losEstados[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        
        // llenar arraylist con tipos de productos
        tipoProd.add(new TipoProducto("1-9", "Mascotas"));
        tipoProd.add(new TipoProducto("2-8", "Libros"));
        tipoProd.add(new TipoProducto("3-7", "Instrumento musical"));
        tipoProd.add(new TipoProducto("4-6", "Instrumento médico"));
        tipoProd.add(new TipoProducto("5-5", "Instrumento veterinario"));
        tipoProd.add(new TipoProducto("6-4", "Maquinaria pesada"));
        tipoProd.add(new TipoProducto("7-3", "Tecnología Software"));
        tipoProd.add(new TipoProducto("8-2", "Tecnología Hardware"));
        tipoProd.add(new TipoProducto("9-1", "Vehículos"));
        tipoProd.add(new TipoProducto("10-9", "Servicios en general"));
        tipoProd.add(new TipoProducto("11-8", "Servicios profesionales"));


        // unir autocomplete text view con arrayList
        adaptadorTipo = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, tipoProd);
        actTipo.setAdapter(adaptadorTipo);
        actTipo.setThreshold(3); //desde donde inicia la busqueda por coincidencia de texto

        //evento en autocompleteTV (act)  -> saber qué se seleccionó
        actTipo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position Nonos entrega la posicion del item en el arrayList de forma automatica, nos entrega la posición en la lista de coincidencias así q no nos sirve y hay q arreglarlo:
                Object itemSeleccionado = parent.getItemAtPosition(position);

                /*se puede castear, pero no es muy recomendado aquí_
                TipoProducto tp = (TipoProducto) itemSeleccionado;
                */

                if (itemSeleccionado instanceof TipoProducto){ //instanceof : si algo es instancia de un obj
                    TipoProducto tp = (TipoProducto) itemSeleccionado;
                    Toast.makeText(MainActivity2.this, "Cod Tipo prod: " + tp.getCodigoTipoProd(), Toast.LENGTH_LONG).show();
                }
            }
        });

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //inicializar spinner sin valor seleccionado por defecto  - preguntar al profe
        spnEstado.setSelection(-1);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    }//end OnCreate

    private void clickBoton(View queBoton) {


        if(queBoton.getId() == R.id.btnOk) {
            //////////////////////////////////////////////////////////////////////////////
         //   losProductos.add(new Productos());
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
        actTipo = findViewById(R.id.actTipo);
        spnEstado = findViewById(R.id.spnEstado);
        btnOk = findViewById(R.id.btnOk);
        btnVolver = findViewById(R.id.btnVolver);
    } // end referencias

}//end end