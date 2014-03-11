package com.example.agame;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Location loc;
	private LocationManager locationManager;
	private Address addr;
	private Button alarm;
	private Button accSettings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		alarm=(Button) findViewById(R.id.button_alarm);
		accSettings=(Button) findViewById(R.id.button_acc_settings);
		
		accSettings.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), SecondActivity.class);
				startActivity(i);
			}
		});
		

	
		alarm.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				Calendar c=Calendar.getInstance();
				int hour=c.get(Calendar.HOUR_OF_DAY);
				int min=c.get(Calendar.MINUTE);
				Intent i=new Intent(AlarmClock.ACTION_SET_ALARM);
				i.putExtra(AlarmClock.EXTRA_HOUR, hour);
				i.putExtra(AlarmClock.EXTRA_MINUTES, min+20);
				i.putExtra(AlarmClock.EXTRA_MESSAGE, "Parking ticket ends in 20 minutes");
				startActivity(i);
						
			
		}
		
	});
		
	
		


	}

	
	
	



}
