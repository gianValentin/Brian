package com.giancarlo.brian;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeActivity extends AppCompatActivity{

    private int[] img = new int[]{R.drawable.carrusel05,R.drawable.carrusel06,R.drawable.carrusel07};
    private String[] nameImg = new String[]{"carrusel05","carrusel06","carrusel07"};
    MediaPlayer mp;
    TextView txtFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extra = getIntent().getExtras();
        String fecha = extra.getString("fecha");
        setTitle(fecha);

        //txtFecha = (TextView)findViewById(R.id.textView_fecha);
        //txtFecha.setText(fecha);

        mp = MediaPlayer.create(this,R.raw.afirmkick);
        mp.start();

        //Iniciar Carrusel
        CarouselView carousel = (CarouselView)findViewById(R.id.cvHome);
        carousel.setPageCount(img.length);
        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(img[position]);
            }
        });
        carousel.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(HomeActivity.this, nameImg[position], Toast.LENGTH_SHORT).show();
            }
        });
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
