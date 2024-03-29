package com.example.piedrapapeltijeralagartospock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ElegirNombre extends Activity {
	private EditText nombre2, nombre1;
	private Button siguiente, atras;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elegir_nombre);
		
		nombre1 = (EditText)findViewById(R.id.cajaJ1);
		nombre2 = (EditText)findViewById(R.id.cajaJ2);
		TextView texto = (TextView)findViewById(R.id.nombreJ1);
		TextView texto2 = (TextView)findViewById(R.id.nombreJ2);
		
		final boolean tipoJuego = getIntent().getExtras().getBoolean("tipoJuego");
		
		if(tipoJuego==true){
			texto.setVisibility(1);
			nombre1.setVisibility(1);		
			nombre2.setText("CPU");
		}	
		else{
			texto.setVisibility(1);
			nombre1.setVisibility(1);			
			texto2.setVisibility(1);
			nombre2.setVisibility(1);
		}
		
		siguiente = (Button)findViewById(R.id.siguiente);
		siguiente.setText("Siguiente");
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.example.piedrapapeltijeralagartospock.PanelJuegoActivity");
				i.putExtra("nombre1", nombre1.getText().toString());
				i.putExtra("nombre2", nombre2.getText().toString());
				i.putExtra("tipoJuego", tipoJuego);
				startActivity(i);
			}
		});
		
		atras = (Button) findViewById(R.id.atras);
		atras.setOnClickListener(new OnClickListener() {
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
