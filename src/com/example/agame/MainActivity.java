package com.example.agame;

import java.util.Calendar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Calendar c=Calendar.getInstance();
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int min=c.get(Calendar.MINUTE);
		Intent i=new Intent(AlarmClock.ACTION_SET_ALARM);
		i.putExtra(AlarmClock.EXTRA_HOUR, hour);
		i.putExtra(AlarmClock.EXTRA_MINUTES, min+1);
		startActivity(i);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
