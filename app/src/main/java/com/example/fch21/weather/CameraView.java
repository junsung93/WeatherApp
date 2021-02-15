package com.example.fch21.weather;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class CameraView extends SurfaceView implements SurfaceHolder.Callback {
	SurfaceHolder holder;
	Camera camera;

	public CameraView(Context context) {
		super(context);
		
		holder = getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		camera = Camera.open();
		try {
			camera.setPreviewDisplay(holder);
		} catch (IOException exception) {
			camera.release();
			camera = null;
		}
	}
	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.stopPreview();
		camera.release();
		camera = null;
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		Camera.Parameters parameters = camera.getParameters();
		List<Camera.Size> previewSize = parameters.getSupportedPreviewSizes();
		parameters.set("orientation", "portrait");
		parameters.setPreviewSize(480, 320);
		camera.setDisplayOrientation(90);
		camera.setParameters(parameters);
		camera.startPreview();
	}

}
