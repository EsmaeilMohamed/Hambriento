package com.thedevwolf.hambriento.GPS;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.thedevwolf.hambriento.R;


public class GPSTracker extends Service implements LocationListener {

    private final Context mContext;

    // flag for GPS Status
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    boolean canGetLocation = false;


    Location location;
    double latitude;
    double longitude;


    GPSTrakerListner gpsTrakerListner;
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 500; // 100 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 30000; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;

    public GPSTracker(Context context, GPSTrakerListner gpsTrakerListner) {
        this.mContext = context;
        this.gpsTrakerListner = gpsTrakerListner;
    }

    public GPSTracker(Context context) {
        this.mContext = context;
    }

    @SuppressLint("MissingPermission")
    public Location getLocation() {
        try {
            locationManager = (LocationManager) mContext
                    .getSystemService(Context.LOCATION_SERVICE);

            //locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);


            if (!isGPSEnabled && !isNetworkEnabled) {
                // location service disabled
                Log.e("GPS", "No GPS And Network Enabled");
            } else {
                this.canGetLocation = true;

                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

                    if (locationManager != null) {
                        Log.e("GPS", "GPS Enabled");
                        location = locationManager
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        //updateGPSCoordinates(location);
                    }
                }
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        if (locationManager != null) {
                            Log.e("GPS", "Network");
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            //updateGPSCoordinates(location);
                        }
                    }

                }

                // check if the dialog of start deticting location is open
                if (getLatitude() == 0.0 && getLongitude() == 0.0) {
                    Log.e("latLng", "lat:" + getLatitude() + " lng:" + getLongitude());
                    gpsTrakerListner.onStartTraker();
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
            Log.e("GPS",
                    "Impossible to connect to LocationManager", e);
        }
        return location;
    }

    public void updateGPSCoordinates(Location location) {
        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Log.e("LatLng:", "Lat:" + latitude + "  Lng:" + longitude);
//            gpsTrakerListner.onTrakerSuccess(latitude, longitude);
        } else {
            Log.e("GPS", "Location null");
        }
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void onLocationChanged(Location location) {
        Log.e("GPS", "Location :" + location.toString());
//        updateGPSCoordinates(location);
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.e("GPS", "StatusChanged" + provider.toString());

    }


    public boolean isProviderDisabled(String provider) {
        boolean isDisable = true;
        LocationManager locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(provider)) {
            isDisable = false;
        }
        return isDisable;

    }

    public void showUserSettings() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getString(R.string.GPS));
        builder.setMessage(mContext.getString(R.string.GPs_disapled));
        builder.setCancelable(false);
        builder.setPositiveButton(mContext.getString(R.string.enable), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mContext.startActivity(intent);
            }
        });
        builder.setNegativeButton(mContext.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Function to get latitude
     */
    public double getLatitude() {
        if (location != null) {
            latitude = location.getLatitude();
        }

        // return latitude
        return latitude;
    }

    /**
     * Function to get longitude
     */
    public double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }
        // return longitude
        return longitude;
    }

}
