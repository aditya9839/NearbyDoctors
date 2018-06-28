package com.example.acer.goxpcare;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Location myLocation;
    private TextView mTextMessage;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    DoctorList doctorList;

    LocationManager l;
    LocationListener locationListener;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.content, doctorList);
                    fragmentTransaction.commit();

                    mTextMessage.setText(null);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.chatting);
                    return true;
                case R.id.chat:
                    mTextMessage.setText(R.string.profile);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        doctorList = new DoctorList();

//
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("location","asd");
        CurrentLocation.getLastKnownLocation(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CurrentLocation.REQUEST_LOCATION){
            Log.d("Asdas","asd");
            CurrentLocation.getLastKnownLocation(this);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

//    public void getLocation() {
//        l = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        l.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//        Location location = l.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        double locationn = location.getLatitude();
//        Log.d("location",""+locationn);
//        locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                Log.i("Location", location.toString());
//                double lat = location.getLatitude();
//                double longi = location.getLongitude();
//                Geocoder geocoder = new Geocoder(getApplicationContext());//GeoCoder will convert latitude and longitude into meaningful address
//                try {
//                    List<Address> addressList = geocoder.getFromLocation(lat, longi, 1);//list of address of current location
//                    str = addressList.get(0).getLocality();//get locality name (city)
//                    str1 = addressList.get(0).getSubLocality();//get locality name (city)
//                    address = addressList.get(0).getAddressLine(0);
//                        getCurrentWeather();
//                    Log.d("onLocationChanged: ", address);
//                    Toast.makeText(MainActivity.this, "add."+address, Toast.LENGTH_SHORT).show();

//                    Toast.makeText(MainActivity.this, "" + str1+" "+str, Toast.LENGTH_SHORT).show();
                    //    Toast.makeText(MainActivity.this, ""+address, Toast.LENGTH_SHORT).show();

//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

//            @Override
//            public void onStatusChanged(String s, int i, Bundle bundle) {
//            }
//
//            @Override
//            public void onProviderEnabled(String s) {
//            }
//
//            @Override
//            public void onProviderDisabled(String s) {
//            }
//        };
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                l.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
    }
}