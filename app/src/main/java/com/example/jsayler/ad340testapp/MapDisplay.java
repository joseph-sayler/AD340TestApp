package com.example.jsayler.ad340testapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapDisplay extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener, OnMapReadyCallback {

    protected static final String msg = "MapDisplay";

    protected static final int LOCATION_PERMISSIONS = 0;

    final static int REQUEST_LOCATION = 9;

    protected static final String ADDRESS_REQUESTED_KEY = "address-request-pending";
    protected static final String LOCATION_ADDRESS_KEY = "location-address";

    protected String mLatitudeLabel;
    protected String mLongitudeLabel;
    protected TextView mLatitudeText;
    protected TextView mLongitudeText;
    protected TextView mLocationText;
    protected String mAddressOutput;

    protected GoogleApiClient mGoogleApiClient;

    protected Location mLastLocation;

    protected boolean mAddressRequested;

    private GoogleMap mMap;

    private AddressResultReceiver mResultReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        mLatitudeLabel = getResources().getString(R.string.latitude_label);
        mLongitudeLabel = getResources().getString(R.string.longitude_label);
        mLocationText = (TextView) findViewById((R.id.location_address));
        mLatitudeText = (TextView) findViewById((R.id.latitude_text));
        mLongitudeText = (TextView) findViewById((R.id.longitude_text));

        buildGoogleApiClient();

        mResultReceiver = new AddressResultReceiver(new Handler());

        mLocationText = (TextView) findViewById(R.id.location_address);

        mAddressRequested = true;
        mAddressOutput = "";

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Log.d(msg, "create event");
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                               .addConnectionCallbacks(this)
                               .addOnConnectionFailedListener(this)
                               .addApi(LocationServices.API)
                               .build();
        Log.d(msg, "GoogleAPIClient created");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void setMap() {
        LatLng myLocation = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        float zoomLevel = (float) 12.0; // auto zoom in on marker location
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, zoomLevel));
        mMap.addMarker(new MarkerOptions().position(myLocation).title("Current location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));

    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_PERMISSIONS);
        } else {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (mLastLocation != null) {
                Log.d("loc: ", mLastLocation.toString());
                setMap();
                if (mAddressRequested) {
                    startIntentService();
                }
            }
            mLatitudeText.setText(String.format("%s: %f", mLatitudeLabel, mLastLocation.getLatitude()));
            mLongitudeText.setText(String.format("%s: %f", mLongitudeLabel, mLastLocation.getLongitude()));
        }
        Log.d(msg, "connected event");
    }

    protected void startIntentService() {
        Intent intent = new Intent(this, FetchAddressIntentService.class);
        intent.putExtra(Constants.RECEIVER, mResultReceiver);
        intent.putExtra(Constants.LOCATION_DATA_EXTRA, mLastLocation);
        startService(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // reload activity to show lat/lon, etc...
                    finish();
                    // overridePendingTransition prevents screen blinking when reloading activity
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                    Log.i(msg, "activity reloaded after enabling location permission");
                } else {
                    showToast(getString(R.string.no_location_detected));
                }
                return;
            }
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(msg, "Connection failed: " + result.getErrorCode());
    }

    @Override
    public void onConnectionSuspended(int cause) {
        Log.i(msg, "connection suspended");
        mGoogleApiClient.connect();
    }

    protected void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    class AddressResultReceiver extends ResultReceiver {

        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            // Display the address string or an error message sent from the intent service.
            mAddressOutput = resultData.getString(Constants.RESULT_DATA_KEY);
            mLocationText.setText(mAddressOutput);

            // Show a toast message if an address was found.
            if (resultCode == Constants.SUCCESS_RESULT) {
                showToast(getString(R.string.address_found));
            }

            mAddressRequested = false;
        }
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
        Log.d(msg, "start event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
        Log.d(msg, "stop event");
    }
}
