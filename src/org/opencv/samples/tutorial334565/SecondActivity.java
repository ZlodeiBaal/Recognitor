package org.opencv.samples.tutorial334565;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.opencv.android.OpenCVLoader;
import org.opencv.samples.tutorial334565.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SecondActivity extends Activity{

	TextView textView;
	LinearLayout layout1;
	ImageView imageView1;
	ImageView imageView2;
	EditText editText1;
	
    int MAXLENGTH=9;

	Button b0;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button b6;
	Button b7;
	Button b8;
	
	List<Button> buttons=null;
	String ID="";
	int timesWas=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.secondlayout);
	    

	   layout1=(LinearLayout)this.findViewById(R.id.layout1);
	    imageView1=(ImageView)this.findViewById(R.id.imageView1);
	    imageView2=(ImageView)this.findViewById(R.id.imageView2);
	    editText1=(EditText)this.findViewById(R.id.editText1);
	    textView=(TextView)this.findViewById(R.id.textBoxWas);
	    
	    
	    buttons=new ArrayList<Button>();
	    b0=(Button)this.findViewById(R.id.but0);buttons.add(b0);
	    b1=(Button)this.findViewById(R.id.but1);buttons.add(b1);
	    b2=(Button)this.findViewById(R.id.but2);buttons.add(b2);
	    b3=(Button)this.findViewById(R.id.but3);buttons.add(b3);
	    b4=(Button)this.findViewById(R.id.but4);buttons.add(b4);
	    b5=(Button)this.findViewById(R.id.but5);buttons.add(b5);
	    b6=(Button)this.findViewById(R.id.but6);buttons.add(b6);
	    b7=(Button)this.findViewById(R.id.but7);buttons.add(b7);
	    b8=(Button)this.findViewById(R.id.but8);buttons.add(b8);
	    
	    Bundle extras = getIntent().getExtras();
	    if (extras != null) {
	        String value = extras.getString("BMP");
	        imageView1.setImageBitmap(BitmapFactory.decodeFile(value));
	        
	        value = extras.getString("TEXT");
	        
	        timesWas=extras.getInt("times");
	        ID=extras.getString("ID");
	        
	        textView.setText("Уже обозвали раз: "+Integer.toString(timesWas));
	        
	        
	        if(value.length()<10)
	        {
	        	int k = 10-value.length();
	        	for(int i=0;i<k;i++)
	        		value+=" ";
	        }
	        
	        editText1.setText(value);
	        
	        int l=0;
	        for(int i=0;i<value.length();i++)
	        {
	        	if(value.charAt(i)!=' ')
	        	{
	        		
	        		if(l<MAXLENGTH)
	        		{
	        			buttons.get(l).setText(Character.toString(value.charAt(i)));
	        			
	        		}
	        		l++;
	        	}
	        }
	    }
	    
	    editText1.addTextChangedListener(new TextWatcher() {

	        public void onTextChanged(CharSequence s, int start, int before,
	                int count) {
	            if(!s.equals("") )
	                    {
	            			CheckPlate();
	                    }
	            }

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

	    });
	    
	    imageView2.setImageResource(R.drawable.close);
	    	    
	    /*Drawable drawing=imageView1.getDrawable();
	    Bitmap bitmap = ((BitmapDrawable)drawing).getBitmap();
	    ImageHeight = bitmap.getHeight();*/
	    
	    imageView2.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	            ((Activity)v.getContext()).finish();
	        }
	    });
	    
	}

	
	
	//Swear
	public void buttonSwear(View view) {
		HttpClient httpclient = new DefaultHttpClient();

        final HttpParams httpParameters = httpclient.getParams();

        HttpConnectionParams.setConnectionTimeout(httpParameters, 10 * 1000);
        HttpConnectionParams.setSoTimeout        (httpParameters, 10 * 1000);
        
        HttpPost httppost = new HttpPost("http://193.138.232.71:10000/swear");
         InputStreamEntity reqEntity;
         
         try {
        	 httppost.setEntity(new StringEntity( editText1.getText().toString()));    
        	 HttpResponse resp = httpclient.execute(httppost);
        	 HttpEntity ent = resp.getEntity();
        
	 
				String ans = EntityUtils.toString(ent);
				
				textView.setText("Обозван");
				
		        
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	public void button0(View view) {
		
        
		Intent myIntent = new Intent( view.getContext(), ChangeLetterActivity.class);
		startActivityForResult(myIntent, 0);
	}
	public void button1(View view) {
		Intent myIntent = new Intent( view.getContext(), ChangeDigitActivity.class);
		startActivityForResult(myIntent, 1);
	}
	public void button2(View view) {
		
		Intent myIntent = new Intent( view.getContext(), ChangeDigitActivity.class);
		startActivityForResult(myIntent, 2);
	}
	public void button3(View view) {
		Intent myIntent = new Intent( view.getContext(), ChangeDigitActivity.class);
		startActivityForResult(myIntent, 3);
	}
	public void button4(View view) {
		Intent myIntent = new Intent( view.getContext(), ChangeLetterActivity.class);
		startActivityForResult(myIntent, 4);
	    
	}
	public void button5(View view) {
		Intent myIntent = new Intent( view.getContext(), ChangeLetterActivity.class);
		startActivityForResult(myIntent, 5);
	}
	public void button6(View view) {
		Intent myIntent = new Intent( view.getContext(), ChangeDigitActivity.class);
		startActivityForResult(myIntent, 6);
	    
	}
	public void button7(View view) {
		Intent myIntent = new Intent( view.getContext(), ChangeDigitActivity.class);
		startActivityForResult(myIntent, 7);
	    
	}
	public void button8(View view) {
		Intent myIntent = new Intent( view.getContext(), ChangeDigitActivity.class);
		startActivityForResult(myIntent, 8);
	    
	}
	
	void CheckPlate()
	{
		HttpClient httpclient = new DefaultHttpClient();

        final HttpParams httpParameters = httpclient.getParams();

        HttpConnectionParams.setConnectionTimeout(httpParameters, 10 * 1000);
        HttpConnectionParams.setSoTimeout        (httpParameters, 10 * 1000);
        
        HttpPost httppost = new HttpPost("http://193.138.232.71:10000/checkplate");
         InputStreamEntity reqEntity;
         
         try {
        	 httppost.setEntity(new StringEntity( editText1.getText().toString()+"\r\n"+ID));    
        	 HttpResponse resp = httpclient.execute(httppost);
        	 HttpEntity ent = resp.getEntity();
        
				String ans = EntityUtils.toString(ent);
				timesWas=Integer.parseInt(ans);
				textView.setText("Уже обозвали раз: "+Integer.toString(timesWas));
		        
				
		        
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	
	protected void onActivityResult(int requestCode, int resultCode,
	          Intent data) {
	      if ((requestCode==1)||(requestCode==2)||(requestCode==3)||(requestCode==6)||(requestCode==7)||(requestCode==8)) {
	    	  
	          if (resultCode == RESULT_OK) {
	            String val = data.getStringExtra("digit");
	            if( val.equals("_"))
	            {
	            	val=" ";
	            }
	            
	            buttons.get(requestCode).setText(val);
	            
	            if(requestCode>5)requestCode++;
	            
	            editText1.getText().replace(requestCode,requestCode+1, val);
	            
	            
	            // use 'myValue' return value here
	          }
	      }
	      
	      if ((requestCode==0)||(requestCode==4)||(requestCode==5)) {
	    	  
	          if (resultCode == RESULT_OK) {
	            String val = data.getStringExtra("letter");
	            
	            buttons.get(requestCode).setText(val);
	            
	            if(requestCode>5)requestCode++;
	            
	            editText1.getText().replace(requestCode,requestCode+1, val);
	            
	            
	            // use 'myValue' return value here
	          }
	          
	      }
	      
	      CheckPlate();
	}
}
