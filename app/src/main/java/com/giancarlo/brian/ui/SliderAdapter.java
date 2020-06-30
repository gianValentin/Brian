package com.giancarlo.brian.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.giancarlo.brian.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.sliderViewHolder> {

    private List<SliderItem> sliderItems;
    private ViewPager2 viewPager2;

    SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public sliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new sliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull sliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class sliderViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView imageView;

        sliderViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageSlide);
        }

        public void setImage(SliderItem imageView) {
            this.imageView.setImageResource(imageView.getImage());
        }
    }

}
