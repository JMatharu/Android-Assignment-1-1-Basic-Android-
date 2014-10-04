package com.jmatharu.jagdeep.assign11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/*
 * Created By - Jagdeep Matharu (300710666) ->Assign 1-1
 */

public class SecondActivity extends Activity {

	Button back;
	TextView clock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);

		Thread myThread = null;

		Runnable runnable = new CountDownRunner();
		myThread = new Thread(runnable);
		myThread.start();

		back = (Button) findViewById(R.id.Back);
		clock = (TextView) findViewById(R.id.textView3);

		this.back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mainAct = new Intent(SecondActivity.this,
						MainActivity.class);
				SecondActivity.this.startActivity(mainAct);
			}
		});
	}

	class CountDownRunner implements Runnable {
		// @Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					doWork();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (Exception e) {
				}
			}
		}

		public void doWork() {
			runOnUiThread(new Runnable() {
				public void run() {
					try {
						TextView txtCurrentTime = (TextView) findViewById(R.id.textView3);
						Calendar c = Calendar.getInstance();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss", Locale.CANADA);
				        String formattedDate = df.format(c.getTime());
				       
				        txtCurrentTime.setText("Current Date and Time : \n"+formattedDate);
				        txtCurrentTime.setGravity(Gravity.CENTER);
					} catch (Exception e) {
					}
				}
			});
		}

	}
}
