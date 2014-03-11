package com.example.agame;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity implements LocationListener {

	
	private Location loc;
	
	private Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		back=(Button) findViewById(R.id.button_main);
		
		back.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
		
		//basics for geoloc
//locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
	//Log.i(LocationManager.GPS_PROVIDER, "tt");
// Define a listener that responds to location updates
	
// Register the listener with the Location Manager to receive location updates

//locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);


//	loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

/*
loc=new Location(LocationManager.GPS_PROVIDER);



loc.setLatitude(24);
loc.setLongitude(25);

	
	try {
		Address a=getAddressForLocation(this, loc);
	
	//basics for SMS texting

	  String phoneNo = "0698330337";
	  String sms=new String();
	  if (a!=null)
		  sms= "EMERGENCY"+a.getLocality();
	  else
		  sms="Emergency";
		  
	  
		SmsManager smsManager = SmsManager.getDefault();
//I HATE U		
		smsManager.sendTextMessage(phoneNo, null, sms, null, null);
		//Toast.makeText(getApplicationContext(), "SMS Sent!",Toast.LENGTH_LONG).show();
		
	  } 
	catch (Exception e) {
		Toast.makeText(getApplicationContext(),
			"SMS faild, please try again later!",
			Toast.LENGTH_LONG).show();
		e.printStackTrace();
		
	  }
	
	
 
*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	

	public static Address getAddressForLocation(Context context, Location location) throws IOException {

        if (location == null) {
            return null;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        int maxResults = 1;

        Geocoder gc = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = gc.getFromLocation(latitude, longitude, maxResults);

        if (addresses.size() == 1) {
            return addresses.get(0);
        } else {
            return null;
        }
    }
	
	public void locUp(Location location){
		this.loc.setLatitude(location.getLatitude());
		this.loc.setLongitude(location.getLongitude());
		
	}

	@Override
	public void onLocationChanged(Location location) {
		locUp(location);
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
