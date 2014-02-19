package com.example.piedrapapeltijeralagartospock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PanelJuegoActivity extends Activity implements View.OnClickListener {

	private ImageButton piedra,papel,tijera,lagarto,spock,jug1,jug2;
	private Button reiniciar, atras;
	private TextView text;
	private boolean turno;
	private String eleccion1, eleccion2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_panel_juego);
		
		turno = true;
		
		text = (TextView)findViewById(R.id.text);
		
		piedra = (ImageButton) findViewById(R.id.piedra);
		papel = (ImageButton) findViewById(R.id.papel);
		tijera = (ImageButton) findViewById(R.id.tijeras);
		lagarto = (ImageButton) findViewById(R.id.lagarto);
		spock = (ImageButton) findViewById(R.id.spock);
		jug1 = (ImageButton) findViewById(R.id.jugador1);
		jug2 = (ImageButton) findViewById(R.id.jugador2);
		
		piedra.setOnClickListener(this);
		papel.setOnClickListener(this);
		tijera.setOnClickListener(this);
		lagarto.setOnClickListener(this);
		spock.setOnClickListener(this);
		jug1.setOnClickListener(this);
		jug2.setOnClickListener(this);
		
		reiniciar = (Button) findViewById(R.id.buttonReiniciar);
		reiniciar.setOnClickListener(this);
		atras = (Button) findViewById(R.id.buttonAtras);
		atras.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case R.id.MnuOpc1:		
			startActivity(new Intent(PanelJuegoActivity.this,InstruccionesActivity.class));
			break;
			
//		case R.id.MnuOpc2:
//			Intent i2 = new Intent(PptlsActivity.this,ReglasEsc.class);
//			
//			startActivity(i2);
//			break;
//		case R.id.MnuOpc3:
//			Intent i3 = new Intent(PptlsActivity.this,Score.class);
//			
//			startActivity(i3);
//			break;
//		case R.id.MnuOpc4:
//			Intent i4 = new Intent(PptlsActivity.this,Desarrollador.class);
//			
//			startActivity(i4);
//			break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onClick(View v) {
//		ImageButton button = (ImageButton)findViewById(v.getId());
//		setTurno();
//		if(turno == true){
//			if(button.getId() == R.id.piedra)
//				eleccion1 = "Piedra";
//			else if(button.getId() == R.id.papel)
//				eleccion1 = "Papel";
//			else if(button.getId() == R.id.tijera)
//				eleccion1 = "Tijera";
//			else if(button.getId() == R.id.lagarto)
//				eleccion1 = "Lagarto";
//			else if(button.getId() == R.id.spock)
//				eleccion1 = "Spock";
//			text.setText(eleccion1);
//		}
//		else{
//			if(button.getId() == R.id.piedra)
//				eleccion2 = "Piedra";
//			else if(button.getId() == R.id.papel)
//				eleccion2 = "Papel";
//			else if(button.getId() == R.id.tijeras)
//				eleccion2 = "Tijera";
//			else if(button.getId() == R.id.lagarto)
//				eleccion2 = "Lagarto";
//			else if(button.getId() == R.id.spock)
//				eleccion2 = "Spock";
//			text.setText(eleccion2);
//		}
	}
	
	public void setTurno(){
		if(turno == true)
			text.setText(new Bundle(getIntent().getExtras()).getString("nombre1"));
		else{
			text.setText(new Bundle(getIntent().getExtras()).getString("nombre2"));
			turno = true;
		}
		turno = false;
	}

}

