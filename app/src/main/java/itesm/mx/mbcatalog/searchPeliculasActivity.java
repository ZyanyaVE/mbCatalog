package itesm.mx.mbcatalog;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;



public class searchPeliculasActivity extends ActionBarActivity {
    // Declaración de variables
    private static final int REQUEST_CODE = 1;
    String titulo;
    int year;
    EditText tituloTV, yearTV;
    RatingBar calificacionRB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_peliculas);

        // Linkeo de variables con objetos de pantalla
        tituloTV = (EditText) findViewById(R.id.tituloTV);
        yearTV = (EditText) findViewById(R.id.yearTV);
        calificacionRB = (RatingBar) findViewById(R.id.calificacionRB);

    }

    public void onClickAdd(View v){
        Intent intent = new Intent();

        if (tituloTV.getText().toString().equals("") || yearTV.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Error, faltan datos", Toast.LENGTH_LONG).show();
        } else
        {
            // Agrega los datos recolectados de los EditTexts a los datos de los intents
            intent.putExtra("titulo", tituloTV.getText().toString());
            intent.putExtra("year", yearTV.getText().toString());
            intent.putExtra("rate",calificacionRB.getRating());

            setResult(RESULT_OK, intent);
            finish();
            Toast.makeText(getApplicationContext(), "Operacion Exitosa", Toast.LENGTH_SHORT).show();
        }
    }
}
