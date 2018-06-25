package com.example.acer.goxpcare;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by acer on 25-Jun-18.
 */

public class CurrentLocation extends Activity {
    LocationManager l;
    String str;
    LocationListener locationListener;
    String address;
    public void getLocation(){
        l = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        l.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("Location",location.toString());
                double lat =location.getLatitude();
                double longi =location.getLongitude();
                Geocoder geocoder = new Geocoder(getApplicationContext());//GeoCoder will convert latitude and longitude into meaningful address
                try {
                    List<Address> addressList = geocoder.getFromLocation(lat, longi, 1);//list of address of current location
//                    str = addressList.get(0).getLocality();//get locality name (city)
//                    str1 = addressList.get(0).getSubLocality();//get locality name (city)
                    address = addressList.get(0).getAddressLine(0);
//                        getCurrentWeather();
                    Log.d("onLocationChanged: ",address);
//                    Toast.makeText(MainActivity.this, "" + str1+" "+str, Toast.LENGTH_SHORT).show();
                    //    Toast.makeText(MainActivity.this, ""+address, Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
            }
            @Override
            public void onProviderEnabled(String s) {
            }
            @Override
            public void onProviderDisabled(String s) {
            }
        };
        if(Build.VERSION.SDK_INT<23){
//            l.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            } else {
                l.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
    }
}
