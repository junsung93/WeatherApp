package com.example.fch21.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button kangBtn;
	Button jejuBtn;
	Button kyungpookBtn;
	Button kyungnamBtn;
	Button jeonnamBtn;
	Button jeonpookBtn;
	Button chungnamBtn;
	Button chungpookBtn;
	Button kyungkiBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		kangBtn=(Button)findViewById(R.id.kangwondo);
		jejuBtn=(Button)findViewById(R.id.jeju);
		kyungpookBtn=(Button)findViewById(R.id.kyungpook);
		kyungnamBtn=(Button)findViewById(R.id.kyungnam);
		jeonnamBtn=(Button)findViewById(R.id.jeonnam);
		jeonpookBtn=(Button)findViewById(R.id.jeonpook);
		
	}
	
	public void mClick(View v) {
		switch(v.getId()) {
		case R.id.kangwondo :
			Intent kangIntent = new Intent(MainActivity.this, KangActivity.class);
			startActivity(kangIntent);
			break;
		case R.id.jeju :
			Intent jejuIntent = new Intent(MainActivity.this, JejuActivity.class);
			startActivity(jejuIntent);
			break;
		case R.id.kyungpook :
			Intent kyungpookIntent = new Intent(MainActivity.this, KyungpookActivity.class);
			startActivity(kyungpookIntent);
			break;
		case R.id.kyungnam :
			Intent kyungnamIntent = new Intent(MainActivity.this, KyungnamActivity.class);
			startActivity(kyungnamIntent);
			break;
		case R.id.jeonnam : 
			Intent jeonnamIntent = new Intent(MainActivity.this, JeonnamActivity.class);
			startActivity(jeonnamIntent);
			break;
		case R.id.jeonpook :
			Intent jeonpookIntent = new Intent(MainActivity.this, JeonpookActivity.class);
			startActivity(jeonpookIntent);
			break;
		case R.id.chungnam :
			Intent chungnamIntent = new Intent(MainActivity.this, ChungnamActivity.class);
			startActivity(chungnamIntent);
			break;
		case R.id.chungpook :
			Intent chungpookIntent = new Intent(MainActivity.this, ChungpookActivity.class);
			startActivity(chungpookIntent);
			break;
		case R.id.kyungki :
			Intent kyungkiIntent = new Intent(MainActivity.this, KyungkiActivity.class);
			startActivity(kyungkiIntent);
			break;
		}
	}
}