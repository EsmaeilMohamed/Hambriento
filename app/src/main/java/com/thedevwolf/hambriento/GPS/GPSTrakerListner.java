package com.thedevwolf.hambriento.GPS;

public interface GPSTrakerListner {
    void onTrakerSuccess(Double lat, Double log);

    void onStartTraker();
}
