package me.tolkstudio.myapplication;

import java.io.Serializable;

public class Parcel implements Serializable {
    private final int ImageIndex;
    private final String cityName;

    public int getImageIndex(){ return ImageIndex; }

    public String getCityName(){ return cityName; }

    public Parcel(int imageIndex, String cityName){
        this.ImageIndex = imageIndex;
        this.cityName = cityName;
    }
}
