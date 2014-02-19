package com.example.piedrapapeltijeralagartospock;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class InstruccionesActivity extends Activity {

	private ImageButton aceptar;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instrucciones);
		
		aceptar = (ImageButton)findViewById(R.id.Aceptar);
		aceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	 }
    @Override
    public void onPause(){
        super.onPause();
        finish();
        }
    }
