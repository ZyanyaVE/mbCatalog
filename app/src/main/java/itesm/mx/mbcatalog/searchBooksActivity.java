package itesm.mx.mbcatalog;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class searchBooksActivity extends ActionBarActivity {

    // Declaración de variables
    private static final int REQUEST_CODE = 1;
    String titulo, autor, fecha = " - ";
    EditText tituloTV, autorTV;
    final Calendar cal = Calendar.getInstance();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // the string representation of date (month/day/year)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);

        // Linkeo de variables con objetos de pantalla
        tituloTV = (EditText) findViewById(R.id.tituloTV);
        autorTV = (EditText) findViewById(R.id.autorTV);

    // Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();
    // Using DateFormat format method we can create a string
    // representation of a date with the defined format.
        fecha = df.format(today);
    }

    public void onClickAdd(View v){
        Intent intent = new Intent();

        if (tituloTV.getText().toString().equals("") || autorTV.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Error, faltan datos", Toast.LENGTH_LONG).show();
        } else
        {
            // Agrega los datos recolectados de los EditTexts a los datos de los intents
            intent.putExtra("titulo", tituloTV.getText().toString());
            intent.putExtra("autor", autorTV.getText().toString());
            intent.putExtra("fecha", fecha);

            setResult(RESULT_OK, intent);
            finish();
            Toast.makeText(getApplicationContext(), "Operacion exitosa", Toast.LENGTH_SHORT).show();
        }
    }
}
