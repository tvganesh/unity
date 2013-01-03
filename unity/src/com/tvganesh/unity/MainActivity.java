package com.tvganesh.unity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button lengthButton,massButton,areaButton,volumeButton,velocityButton;
    Button temperatureButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}
	public void addListenerOnButton() {
		   final Context context  = this;		   
		   
		   //Mass activity
		   massButton = (Button) findViewById(R.id.button1);
		   massButton.setTextAppearance(context,R.style.ButtonFontStyle);
		   massButton.setOnClickListener(new OnClickListener() {
			   
			   public void onClick(View arg0) {
				    Intent intent = new Intent(context, massActivity.class);
				    startActivity(intent);
			   }

			
		   });
		   
		   //Length activity
		   lengthButton = (Button) findViewById(R.id.button2);
		   lengthButton.setTextAppearance(context,R.style.ButtonFontStyle);
		   lengthButton.setOnClickListener(new OnClickListener() {
			   
			   public void onClick(View arg0) {
				    Intent intent = new Intent(context, lengthActivity.class);
				    startActivity(intent);
			   }

			
		   });
		   
		   //Volume activity
		   volumeButton = (Button) findViewById(R.id.button3);
		   volumeButton.setTextAppearance(context,R.style.ButtonFontStyle);
		   volumeButton.setOnClickListener(new OnClickListener() {
			   
			   public void onClick(View arg0) {
				    Intent intent = new Intent(context, volumeActivity.class);
				    startActivity(intent);
			   }

			
		   });
		   
		   //Area activity
		   areaButton = (Button) findViewById(R.id.button4);
		   areaButton.setTextAppearance(context,R.style.ButtonFontStyle);
		   areaButton.setOnClickListener(new OnClickListener() {
			   
			   public void onClick(View arg0) {
				    Intent intent = new Intent(context, areaActivity.class);
				    startActivity(intent);
			   }

			
		   });

	

		   //Velocity activity
		   velocityButton = (Button) findViewById(R.id.button5);
		   velocityButton.setTextAppearance(context,R.style.ButtonFontStyle);
		   velocityButton.setOnClickListener(new OnClickListener() {
			   
			   public void onClick(View arg0) {
				    Intent intent = new Intent(context, velocityActivity.class);
				    startActivity(intent);
			   }

			
		   });
		   
		   //Temperature activity
		   temperatureButton = (Button) findViewById(R.id.button6);
		   temperatureButton.setTextAppearance(context,R.style.ButtonFontStyle);
		   temperatureButton.setOnClickListener(new OnClickListener() {
			   
			   public void onClick(View arg0) {
				    Intent intent = new Intent(context, temperatureActivity.class);
				    startActivity(intent);
			   }

			
		   });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}