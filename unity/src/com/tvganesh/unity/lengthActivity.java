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

public class lengthActivity extends Activity {
	  private EditText text1;
	  private TextView txtConvertedValue;
	   Button button;
	   Spinner sp1,sp2;
	   int item1,item2;
	   String[]  lengthUnits = {"centimeter","meter","kilometer","inch","foot","mile"};
	   
	  
	   
	   
	   double lengthConversion[][] = new double [][]{
		   {1.0,1e-2,1e-5,0.3937,3.281e-2,6.214e-6},
		   {100.0,1.0,1e-3,39.37,3.281,6.214e-4},
		   {1e5,1000,1,3.937e-4,3281,0.6214},
		   {2.54,2.54e-2,2.54e-3,1,8.333e-2,1.578e-5},
		   {30.48,.3048,3.048e-4,12,1,1.894e-4},
		   {1.609e5,1609,1.609,6.336e4,5280,1}
	   };
	   
	   protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.length);
			ArrayAdapter<String>  lengthAdapter = new ArrayAdapter<String> (this, 
					android.R.layout.simple_spinner_item,lengthUnits);
			sp1 = (Spinner) findViewById(R.id.spinner1);
			sp1.setAdapter(lengthAdapter);
			sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
				   public void onItemSelected(AdapterView<?> argo0, View arg1,
						   int arg2, long arg3)   {
					      int item1 = sp1.getSelectedItemPosition();
					      
					      //Toast.makeText(getBaseContext(),"You have selected: " +
					      //lengthUnits[item1], Toast.LENGTH_SHORT).show();
				   }
			
				    public void onNothingSelected(AdapterView<?> arg0) {
					}							
					});
			sp2 = (Spinner) findViewById(R.id.spinner2);
			sp2.setAdapter(lengthAdapter);
			sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
				   public void onItemSelected(AdapterView<?> argo0, View arg1,
						   int arg2, long arg3)   {
					      int item2 = sp2.getSelectedItemPosition();
					      
					      //Toast.makeText(getBaseContext(),"sp2:You have selected: " +
					      //lengthUnits[item2], Toast.LENGTH_SHORT).show();
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
			int item2 = sp2.getSelectedItemPosition();
			double value = lengthConversion[item1][item2];
			double convertedValue = inputValue * value;
			//Toast.makeText(getBaseContext(),"Value is: " +
				      //value, Toast.LENGTH_SHORT).show();
			txtConvertedValue.setText(String.valueOf(convertedValue));;
			
		}
		
		public void home(View view) {
			final Context context  = this;		
		    Intent intent = new Intent(context, MainActivity.class);
		    startActivity(intent);
		}
		
}