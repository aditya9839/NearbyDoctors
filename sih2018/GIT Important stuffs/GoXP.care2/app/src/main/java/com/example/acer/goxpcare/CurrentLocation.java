package com.example.acer.goxpcare;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.List;
/**
 * Created by acer on 25-Jun-18.
 */

    //optimized code to getCurrent location or last known location but it will work if gps is on

public class CurrentLocation {
    LocationManager mLocationManager;
    private Activity parentActivity;

    public CurrentLocation(Activity parentActivity){
        this.parentActivity = parentActivity;

    }

    public Location  getLastKnownLocation() {
        mLocationManager = (LocationManager) this.parentActivity.getSystemService(this.parentActivity.LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(this.parentActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.parentActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.parentActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
            double d = bestLocation.getLatitude();
            double d1 = bestLocation.getLongitude();
            Log.d("Location", "d :" + d + "  " + d1);
        }

        return bestLocation;
    }
}