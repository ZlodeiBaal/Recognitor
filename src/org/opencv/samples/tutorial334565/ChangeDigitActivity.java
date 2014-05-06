package org.opencv.samples.tutorial334565;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;




public class ChangeDigitActivity extends Activity {


	
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.change_digit);
	    

	   
	    
	}
	
	public void button0(View view) {
	    
		Intent resultData = new Intent();
		resultData.putExtra("digit", "0");
		setResult(Activity.RESULT_OK, resultData);
		
	    finish();
	}
	public void button1(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "1");
		setResult(Activity.RESULT_OK, resultData);
		
		finish();
	}
	public void button2(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "2");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	    
	}
	public void button3(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "3");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void button4(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "4");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void button5(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "5");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void button6(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "6");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void button7(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "7");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void button8(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "8");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	
	public void button9(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "9");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}

	public void buttonNone(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("digit", "_");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}

}
