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

public class PanelJuegoActivity extends Activity implements
		View.OnClickListener {

	private ImageButton piedra, papel, tijera, lagarto, spock, jug1, jug2;
	private Button reiniciar, atras;
	private TextView text;
	private boolean turno;
	private int op1, op2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_panel_juego);

		turno = true;

		text = (TextView) findViewById(R.id.text);
		text.setText(new Bundle(getIntent().getExtras()).getString("nombre1"));

		piedra = (ImageButton) findViewById(R.id.piedra);
		papel = (ImageButton) findViewById(R.id.papel);
		tijera = (ImageButton) findViewById(R.id.tijera);
		lagarto = (ImageButton) findViewById(R.id.lagarto);
		spock = (ImageButton) findViewById(R.id.spock);
		jug1 = (ImageButton) findViewById(R.id.jugador1);
		jug2 = (ImageButton) findViewById(R.id.jugador2);

		piedra.setOnClickListener(this);
		papel.setOnClickListener(this);
		tijera.setOnClickListener(this);
		lagarto.setOnClickListener(this);
		spock.setOnClickListener(this);

		reiniciar = (Button) findViewById(R.id.buttonReiniciar);
		reiniciar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onCreate(null);
			}
		});

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

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.MnuOpc1:
			startActivity(new Intent(PanelJuegoActivity.this,
					InstruccionesActivity.class));
			break;
		case R.id.MnuOpc2:
			startActivity(new Intent(PanelJuegoActivity.this,
					Desarrollador.class));
			break;

		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		ImageButton button = (ImageButton) findViewById(v.getId());
		boolean tipoJuego = getIntent().getExtras().getBoolean("tipoJuego");

		if (turno == true) {
			if (button.getId() == R.id.piedra) {
				jug1.setBackgroundResource(R.drawable.piedra);
				op1 = 1;
			} else if (button.getId() == R.id.papel) {
				jug1.setBackgroundResource(R.drawable.papel);
				op1 = 2;
			} else if (button.getId() == R.id.tijera) {
				jug1.setBackgroundResource(R.drawable.tijeras);
				op1 = 3;
			} else if (button.getId() == R.id.lagarto) {
				jug1.setBackgroundResource(R.drawable.lagarto);
				op1 = 4;
			} else if (button.getId() == R.id.spock) {
				jug1.setBackgroundResource(R.drawable.spock);
				op1 = 5;
			}
			if (tipoJuego == true) {
				op2 = (int) Math.random() * 5 + 1;
				if (op2 == 1) {
					jug2.setBackgroundResource(R.drawable.piedra);
				} else if (op2 == 2) {
					jug2.setBackgroundResource(R.drawable.papel);
				} else if (op2 == 3) {
					jug2.setBackgroundResource(R.drawable.tijeras);
				} else if (op2 == 4) {
					jug2.setBackgroundResource(R.drawable.lagarto);
				} else if (op2 == 5) {
					jug2.setBackgroundResource(R.drawable.spock);
				}
				comprobarGanador();
			} else
				setTurno();
		} else {
			if (button.getId() == R.id.piedra) {
				jug2.setBackgroundResource(R.drawable.piedra);
				op2 = 1;
			} else if (button.getId() == R.id.papel) {
				jug2.setBackgroundResource(R.drawable.papel);
				op2 = 2;
			} else if (button.getId() == R.id.tijera) {
				jug2.setBackgroundResource(R.drawable.tijeras);
				op2 = 3;
			} else if (button.getId() == R.id.lagarto) {
				jug2.setBackgroundResource(R.drawable.lagarto);
				op2 = 4;
			} else if (button.getId() == R.id.spock) {
				jug2.setBackgroundResource(R.drawable.spock);
				op2 = 5;
			}
			comprobarGanador();
		}
	}

	public void setTurno() {
		if (turno == true) {
			text.setText(new Bundle(getIntent().getExtras())
					.getString("nombre2"));
			turno = false;
		}

	}

	public void comprobarGanador() {
		if (op1 == 1 && (op2 == 3 || op2 == 4) || op1 == 2
				&& (op2 == 1 || op2 == 5) || op1 == 3 && (op2 == 2 || op2 == 4)
				|| op1 == 4 && (op2 == 2 || op2 == 5) || op1 == 5
				&& (op2 == 1 || op2 == 3)) {
			text.setText("GANADOR: "
					+ new Bundle(getIntent().getExtras()).getString("nombre1"));
		} else if (op1 == 1 && (op2 == 2 || op2 == 5) || op1 == 2
				&& (op2 == 3 || op2 == 4) || op1 == 3 && (op2 == 1 || op2 == 5)
				|| op1 == 4 && (op2 == 1 || op2 == 3) || op1 == 5
				&& (op2 == 2 || op2 == 4)) {
			text.setText("GANADOR: "
					+ new Bundle(getIntent().getExtras()).getString("nombre2"));
		} else {
			text.setText("EMPATE");
		}
		piedra.setEnabled(false);
		papel.setEnabled(false);
		tijera.setEnabled(false);
		lagarto.setEnabled(false);
		spock.setEnabled(false);
		jug1.setVisibility(View.VISIBLE);
		jug2.setVisibility(View.VISIBLE);
		reiniciar.setVisibility(View.VISIBLE);

	}
}
