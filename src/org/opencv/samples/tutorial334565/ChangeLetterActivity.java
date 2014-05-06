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




public class ChangeLetterActivity extends Activity {


	
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.change_letter);
	    

	   
	    
	}
	
	public void buttonA(View view) {
	    
		Intent resultData = new Intent();
		resultData.putExtra("letter", "A");
		setResult(Activity.RESULT_OK, resultData);
		
	    finish();
	}
	public void buttonB(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "B");
		setResult(Activity.RESULT_OK, resultData);
		
		finish();
	}
	public void buttonC(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "C");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	    
	}
	public void buttonE(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "E");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void buttonH(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "H");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void buttonK(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "K");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void buttonM(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "M");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void buttonO(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "O");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void buttonP(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "P");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	
	public void buttonT(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "T");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}

	public void buttonX(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "X");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
	public void buttonY(View view) {
		Intent resultData = new Intent();
		resultData.putExtra("letter", "Y");
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}

}
