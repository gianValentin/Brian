package com.giancarlo.brian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PagerActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    private TextView tvTitulo;
    private TextView tvDescripcion;
    private int timeSlider = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        getSupportActionBar().hide();

        viewPager2 = findViewById(R.id.vpImageSlider);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvDescripcion = findViewById(R.id.tvDescripcion);

        tvDescripcion.setText("Este es mi texto de muestra de todos los datss que se carga al mismo tiempo de los demas datos");

        final List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.strickerhiduo,""));
        sliderItems.add(new SliderItem(R.drawable.img02,"BIENVENIDA!"));
        sliderItems.add(new SliderItem(R.drawable.img01,"Picasso 460"));
        sliderItems.add(new SliderItem(R.drawable.img02,"Vartolomen 533"));
        sliderItems.add(new SliderItem(R.drawable.img03,"Nerudas 342"));
        sliderItems.add(new SliderItem(R.drawable.img04, "Tomseak 234"));
        sliderItems.add(new SliderItem(R.drawable.img05,"Apollo 234"));
        sliderItems.add(new SliderItem(R.drawable.img06,"Micael 453"));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 -Math.abs((position));
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,timeSlider); // Duracion
                tvTitulo.setText(sliderItems.get(position).getNameImage());
            }
        });

    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, timeSlider);
    }
}