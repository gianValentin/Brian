package com.giancarlo.brian.ui;

public class SliderItem {

    private int image;
    private String nameImage;

    SliderItem(int image,String nameImage){
        this.image = image;this.nameImage = nameImage;
    }

    public int getImage(){
        return  this.image;
    }

    public String getNameImage() {
        return nameImage;
    }
}
