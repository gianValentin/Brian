package com.giancarlo.brian;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    MediaPlayer mp;
    TextView txtFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extra = getIntent().getExtras();
        String fecha = extra.getString("fecha");
        setTitle(fecha);

        txtFecha = (TextView)findViewById(R.id.textView_fecha);
        txtFecha.setText(fecha);

        mp = MediaPlayer.create(this,R.raw.afirmkick);
        mp.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

}
