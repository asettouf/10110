package com.example.agame;

import java.util.Calendar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.telephony.SmsManager;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//basics for Alarm Management
		Calendar c=Calendar.getInstance();
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int min=c.get(Calendar.MINUTE);
		Intent i=new Intent(AlarmClock.ACTION_SET_ALARM);
		i.putExtra(AlarmClock.EXTRA_HOUR, hour);
		i.putExtra(AlarmClock.EXTRA_MINUTES, min+1);
		startActivity(i);
		
	
		//basics for SMS texting

		  String phoneNo = "0698330337";
		  
		  String sms = "EMERGENCY";

		  try {
			SmsManager smsManager = SmsManager.getDefault();
			
			smsManager.sendTextMessage(phoneNo, null, sms, null, null);
			Toast.makeText(getApplicationContext(), "SMS Sent!",
						Toast.LENGTH_LONG).show();
			finish();
		  } catch (Exception e) {
			Toast.makeText(getApplicationContext(),
				"SMS faild, please try again later!",
				Toast.LENGTH_LONG).show();
			e.printStackTrace();
		  }
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
