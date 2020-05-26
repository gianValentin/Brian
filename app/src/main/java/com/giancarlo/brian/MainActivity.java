package com.giancarlo.brian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtNombre,txtContraseña;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txtNombre = (EditText)findViewById(R.id.editText_nombre);
        txtContraseña = (EditText)findViewById(R.id.editText_contraseña);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent HomeItemt = new Intent(this,HomeActivity.class);

        String nombre = txtNombre.getText().toString();
        String contraseña = txtContraseña.getText().toString();
        String fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        if(!contraseña.isEmpty() && !nombre.isEmpty()){
            Boolean acceso = contraseña.equals("3937") && nombre.equals("brian");
            if(acceso){
                HomeItemt.putExtra("fecha",fecha);
                startActivity(HomeItemt);
                finish();
            }else{
                txtNombre.setError("Nombre o Contraseña Erronea!");
                txtNombre.setText("");
                txtContraseña.setText("");
            }

        }else{
            txtNombre.setError("Ingrese Nombre!");
            txtContraseña.setError("Ingrese Contraseña!");
        }


    }
}
