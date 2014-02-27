package com.example.piedrapapeltijeralagartospock;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends Activity {
	ArrayList<String> score = new ArrayList<String>();
	private static final String TAG = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		TextView texto = (TextView) findViewById(R.id.Jugadores);

		FileInputStream archivo = null;

		try {
			archivo = openFileInput("test.xml");
		

		XmlPullParser parser = Xml.newPullParser();

			parser.setInput(archivo, "UTF-8");

			int event = parser.next();
			while (event != XmlPullParser.END_DOCUMENT) {
				if (event == XmlPullParser.START_TAG) {
					// rankin.add( "<" + parser.getName() + ">");
					for (int i = 0; i < parser.getAttributeCount(); i++) {
						score.add(("\t" + parser.getAttributeName(i) + " = " + parser
								.getAttributeValue(i)));
					}
				}
				if (event == XmlPullParser.TEXT
						&& parser.getText().trim().length() != 0)
					Log.d(TAG, "\t\t" + parser.getText());

				if (event == XmlPullParser.END_TAG)
					Log.d(TAG, "</" + parser.getName() + ">");

				event = parser.next();
			}
			archivo.close();

			Toast.makeText(this, "Leido correctamente", Toast.LENGTH_LONG)
					.show();
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}

		for (int i = 0; i < score.size(); i++) {
			texto.append(score.get(i).toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
