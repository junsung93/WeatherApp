package com.example.fch21.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
	Bitmap bitmap;
	
	public MyView(Context context) {
		super(context);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sun);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		
		canvas.drawBitmap(bitmap, 10, 10, paint);
	}
}
