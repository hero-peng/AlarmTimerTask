package com.coder80.timer;

import com.coder80.timer.utils.ServiceUtil;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by coder80 on 2014/10/31.
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener{
	private TextView mTextView;
	private Button mBtnStart;
	private Button mBtnStop;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		mTextView = (TextView) findViewById(R.id.show);
		mBtnStart = (Button) findViewById(R.id.button1);
		mBtnStop = (Button) findViewById(R.id.button2);
		mBtnStart.setOnClickListener(this);
		mBtnStop.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch(id){
		case R.id.button1:
			ServiceUtil.invokeTimerPOIService(mContext);
			break;
		case R.id.button2:
			ServiceUtil.cancleAlarmManager(mContext);
			break;
		}
		
	}
}
