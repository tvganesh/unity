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

public class velocityActivity extends Activity {
	  private EditText text1;
	  private TextView txtConvertedValue;
	   Button button;
	   Spinner sp1,sp2;
	   int item1,item2;
	   String[]  velocityUnits = {"km/hr","miles/hr"};
	   
	  
	   
	   
	   double velocityConversion[][] = new double [][]{
		   {1,0.6214},
		   {1.609,1},
		  
	   };
	   
	   protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.velocity);
			ArrayAdapter<String>  velocityAdapter = new ArrayAdapter<String> (this, 
					android.R.layout.simple_spinner_item,velocityUnits);
			sp1 = (Spinner) findViewById(R.id.spinner1);
			sp1.setAdapter(velocityAdapter);
			sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
				   public void onItemSelected(AdapterView<?> argo0, View arg1,
						   int arg2, long arg3)   {
					      int item = sp1.getSelectedItemPosition();
					      
					      //Toast.makeText(getBaseContext(),"You have selected: " +
					      //velocityUnits[item], Toast.LENGTH_SHORT).show();
				   }
			
				    public void onNothingSelected(AdapterView<?> arg0) {
					}							
					});
			sp2 = (Spinner) findViewById(R.id.spinner2);
			sp2.setAdapter(velocityAdapter);
			sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
				   public void onItemSelected(AdapterView<?> argo0, View arg1,
						   int arg2, long arg3)   {
					      int item = sp2.getSelectedItemPosition();
					      
					      //Toast.makeText(getBaseContext(),"sp2:You have selected: " +
					      //velocityUnits[item], Toast.LENGTH_SHORT).show();
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
			double value = velocityConversion[item1][item2];
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