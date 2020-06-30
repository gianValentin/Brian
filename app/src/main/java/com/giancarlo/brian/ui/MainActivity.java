package com.giancarlo.brian.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.giancarlo.brian.R;
import com.giancarlo.brian.db.entity.UserEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

        String name = txtNombre.getText().toString();
        String password = txtContraseña.getText().toString();

        if(!name.isEmpty() && !password.isEmpty()){
            String user = validar(name,password);

            if(user.equals("brian")){
                Intent HomeItemt = new Intent(this, HomeActivity.class);
                HomeItemt.putExtra("fecha",new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
                startActivity(HomeItemt);
                finish();
            }else if(user.equals("giancarlo")){
                Intent PegerItemt = new Intent(this, PagerActivity.class);
                startActivity(PegerItemt);
                finish();
            }else{
                txtNombre.setError("Nombre o Contraseña Erronea!");
                txtNombre.setText("");
                txtContraseña.setText("");
            }

        }else{
            txtNombre.setError("Complete Camapos!");
        }


    }

    //Funciones y Procedimientos

    private String validar(String name, String password){
        String acceso = "";
        String fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        List<UserEntity> listUser = new ArrayList<>();
        listUser.add(new UserEntity("brian","12345"));
        listUser.add(new UserEntity("giancarlo","12345"));

        for(UserEntity userEntity: listUser) {
            if (userEntity.getName().equals(name) && userEntity.getPassword().equals(password) && fecha.equals("2020-06-14")) {
                acceso = userEntity.getName();
            }
        }
        return acceso;
    }
}
