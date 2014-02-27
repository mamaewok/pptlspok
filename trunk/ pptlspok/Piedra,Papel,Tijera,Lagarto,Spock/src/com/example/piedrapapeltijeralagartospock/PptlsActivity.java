package com.example.piedrapapeltijeralagartospock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class PptlsActivity extends Activity implements View.OnClickListener {

	private RadioButton rb1, rb2;
	private Button jugar, salir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pptls);

		rb1 = (RadioButton) findViewById(R.id.radioButton1);
		rb2 = (RadioButton) findViewById(R.id.radioButton2);
		jugar = (Button) findViewById(R.id.buttonJugar);
		jugar.setOnClickListener(this);
		salir = (Button) findViewById(R.id.buttonSalir);
		salir.setOnClickListener(new OnClickListener() {
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
			startActivity(new Intent(PptlsActivity.this,
					InstruccionesActivity.class));
			break;

		case R.id.MnuOpc2:
			startActivity(new Intent(PptlsActivity.this, Desarrollador.class));
			break;
			
		case R.id.MnuOpc3:
			startActivity(new Intent(PptlsActivity.this, Score.class));
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if (rb1.isChecked() == true) {
			Intent intent = new Intent(PptlsActivity.this, ElegirNombre.class);
			intent.putExtra("tipoJuego", true);
			startActivity(intent);
		} else if (rb2.isChecked() == true) {
			Intent intent = new Intent(
					"com.example.piedrapapeltijeralagartospock.ElegirNombre");
			intent.putExtra("tipoJuego", false);
			startActivity(intent);
		}

	}

}
