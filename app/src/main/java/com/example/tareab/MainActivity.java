package com.example.tareab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilUsuario, tilConstraseña;
    private EditText etUsuario, etContraseña;
    private Button btnIniciar, btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referencias();
        eventos();
    }


    private void clickBoton(View queBoton) {
       if(queBoton.getId() == R.id.btnIniciar){
          if(validarUsuario() && validarContraseña()){
              Intent i = new Intent(this, MainActivity2.class);
              startActivity(i);
          }
          else if(queBoton.getId() == R.id.btnCancelar)
           {

          }
      }//end btnIniciar
    }//end clickBoton


    //
    public boolean validarUsuario() {
        boolean retorno = true;
        String user = tilUsuario.getEditText().getText().toString().trim();
        if (!user.equals("joan@gmail.com")&& user.isEmpty()) {
            tilUsuario.setError("Ingresa usuario válido");
            retorno = false;
        }
        return retorno;
    }
    //
    public boolean validarContraseña(){
        boolean retorno = true;
        String pass = tilConstraseña.getEditText().getText().toString().trim();
        if (!pass.equals("12345") || pass.isEmpty()) {
            tilConstraseña.setError("Contraseña incorrecta");
            retorno = false;
        }
        return retorno;
    }


    private void eventos() {
        //eventos de boton
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBoton(v);
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBoton(v);
            }
        });


        //evento error en usuario
        etUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tilUsuario.setError(null);
            }
        });

        //evento error en contraseña
        etContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tilConstraseña.setError(null);
            }
        });

    }
    private void referencias () {
        tilUsuario = findViewById(R.id.tilUsuario);
        tilConstraseña = findViewById(R.id.tilContraseña);
        etUsuario = findViewById(R.id.etUsuario);
        etContraseña = findViewById(R.id.etContraseña);

        btnIniciar = findViewById(R.id.btnIniciar);
        btnCancelar = findViewById(R.id.btnCancelar);

    }
}