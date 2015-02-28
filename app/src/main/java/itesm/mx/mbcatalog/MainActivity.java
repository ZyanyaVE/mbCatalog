package itesm.mx.mbcatalog;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button librosBT, peliculasBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linkeo de variables con elementos en pantalla
        librosBT = (Button) findViewById(R.id.librosBT);
        peliculasBT = (Button) findViewById(R.id.peliculasBT);
    }

    public void onClickPeliculas(View v){
        Intent intentPeliculas = new Intent(MainActivity.this, PeliculasActivity.class);

        startActivity(intentPeliculas);
    }

    public void onClickLibros (View v){
        Intent intentLibros = new Intent(MainActivity.this, LibrosActivity.class);

        startActivity(intentLibros);
    }
}
