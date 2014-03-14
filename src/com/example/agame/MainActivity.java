package com.example.agame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {


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
				Intent i = new Intent(getApplicationContext(), AlarmActivity.class);
				startActivity(i);
								
			
		}
		
	});
		
	
		


	}

	
	
	



}
