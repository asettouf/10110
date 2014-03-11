package com.example.agame;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AlarmActivity extends Activity {

	private Button back;
	private Button alarm;
	private EditText hours;
	private int late;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		alarm=(Button) findViewById(R.id.button_alarm_go);
		hours=(EditText) findViewById(R.id.hours);
        back=(Button) findViewById(R.id.button_main);
		
		back.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
		
		alarm.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				late=Integer.parseInt(hours.getText().toString());
				Calendar c=Calendar.getInstance();
				int hour=c.get(Calendar.HOUR_OF_DAY);
				int min=c.get(Calendar.MINUTE);
				Intent i=new Intent(AlarmClock.ACTION_SET_ALARM);
				i.putExtra(AlarmClock.EXTRA_HOUR, hour+late);
				i.putExtra(AlarmClock.EXTRA_MINUTES, min -20);
				i.putExtra(AlarmClock.EXTRA_MESSAGE, "Parking ticket ends in 20 minutes");
				startActivity(i);
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}

}
