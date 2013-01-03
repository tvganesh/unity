package com.tvganesh.unity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class temperatureActivity extends Activity {
	  private EditText text1;
	  private TextView txtConvertedValue;
	  private String fromUnit, toUnit;
	   Button button;
	   Spinner sp1,sp2;
	   int item1,item2;
	   String[]  temperatureUnits = {"centigrade","fahrenheit"};
	   
	  
	   
	   
	   
	   protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.temperature);
			ArrayAdapter<String>  temperatureAdapter = new ArrayAdapter<String> (this, 
					android.R.layout.simple_spinner_item,temperatureUnits);
			sp1 = (Spinner) findViewById(R.id.spinner1);
			sp1.setAdapter(temperatureAdapter);
			sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
				   public void onItemSelected(AdapterView<?> argo0, View arg1,
						   int arg2, long arg3)   {
					      int item = sp1.getSelectedItemPosition();
					      fromUnit = temperatureUnits[item];
					      //Toast.makeText(getBaseContext(),"You have selected: " +
					      //temperatureUnits[item], Toast.LENGTH_SHORT).show();
				   }
			
				    public void onNothingSelected(AdapterView<?> arg0) {
					}							
					});
			sp2 = (Spinner) findViewById(R.id.spinner2);
			sp2.setAdapter(temperatureAdapter);
			sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
				   public void onItemSelected(AdapterView<?> argo0, View arg1,
						   int arg2, long arg3)   {
					      int item = sp2.getSelectedItemPosition();
					      toUnit = temperatureUnits[item];
					      //Toast.makeText(getBaseContext(),"sp2:You have selected: " +
					      //temperatureUnits[item], Toast.LENGTH_SHORT).show();
				   }
			
				    public void onNothingSelected(AdapterView<?> arg0) {
					}							
					});
				
			
	   }
	   
		public void convert(View view) {
			sp1 = (Spinner) findViewById(R.id.spinner1);
			sp2 = (Spinner) findViewById(R.id.spinner2);
			text1 = (EditText) findViewById(R.id.editText1);
			txtConvertedValue = (TextView) findViewById(R.id.txtConvertedValue);
			if(text1.getText().length() == 0){
				Toast.makeText(this,"Please enter a valid number", Toast.LENGTH_LONG).show();
				return;
			}
			double inputValue = Double.parseDouble(text1.getText().toString());
			int item1 = sp1.getSelectedItemPosition();	
			fromUnit = temperatureUnits[item1];
			int item2 = sp2.getSelectedItemPosition();
			toUnit = temperatureUnits[item2];
			if((fromUnit.equals("centigrade")) && (toUnit.equals("fahrenheit"))){
				txtConvertedValue.setText(String.valueOf(convertcentigrade2fahrenheit(inputValue)));
			}
			else if((fromUnit.equals("fahrenheit")) && (toUnit.equals("centigrade"))){
				txtConvertedValue.setText(String.valueOf(convertfahrenheit2centigrade(inputValue)));
			}		
			else if((fromUnit.equals("fahrenheit")) && (toUnit.equals("fahrenheit"))){
				txtConvertedValue.setText("1.0");
			}
			else if((fromUnit.equals("centigrade")) && (toUnit.equals("centigrade"))){
				txtConvertedValue.setText("1.0");
			}
		}
		
		private double convertcentigrade2fahrenheit(double centigrade){
			return((centigrade *9)/5) + 32;
		}	
		private double convertfahrenheit2centigrade(double fahrenheit){
			return((fahrenheit -32) *5 /9);
		}
		
		public void home(View view) {
			final Context context  = this;		
		    Intent intent = new Intent(context, MainActivity.class);
		    startActivity(intent);
		}
}