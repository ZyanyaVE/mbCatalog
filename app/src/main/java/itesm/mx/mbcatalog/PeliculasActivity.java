package itesm.mx.mbcatalog;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PeliculasActivity extends ActionBarActivity {

    // Declaracion de variables
    Button addBT;
    ListView peliculasLV;
    ListViewAdapterPeliculas miAdaptador;
    String titulo, year = "0000";
    List<Pelicula> listPeliculas = new ArrayList<Pelicula>();
    private static final int REQUEST_CODE = 1;
    float calificacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        // Linkeo de variable con elementos en pantalla
        addBT = (Button) findViewById(R.id.addBT);
        peliculasLV = (ListView) findViewById(R.id.peliculasLV);


        // Adaptador de Arreglo
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        };
        peliculasLV.setOnItemClickListener(itemListener);

        // Creacion de adaptador de arreglo
        miAdaptador = new ListViewAdapterPeliculas(getApplicationContext(), R.layout.rowp, getDataForListView());
        peliculasLV.setAdapter(miAdaptador);
    }

    // Agrega cada libro a la lista que se utiliza para la variable miAdaptador
    public List<Pelicula> getDataForListView(){
        Pelicula peli;
        peli = new Pelicula ("Hello Kitty 90", "2000", 3);
        listPeliculas.add(peli);
        peli = new Pelicula ("Barbie y el Cascanueces", "2000", 3);
        listPeliculas.add(peli);
        peli = new Pelicula ("El Camino hacia el Dorado", "2000", 3.5f);
        listPeliculas.add(peli);
        peli = new Pelicula ("Bambi", "2000", 3);
        listPeliculas.add(peli);
        peli = new Pelicula ("Harry Potter y el Caliz de Fuego", "2000", 2.5f);
        listPeliculas.add(peli);
        peli = new Pelicula ("Hercules", "2000", 5);
        listPeliculas.add(peli);
        peli = new Pelicula ("Paranormal Activity", "2000", 3);
        listPeliculas.add(peli);
        peli = new Pelicula ("The Fault in Our Stars", "2000", 4);
        listPeliculas.add(peli);
        peli = new Pelicula ("The Hangover", "2000", 1);
        listPeliculas.add(peli);
        peli = new Pelicula ("The Perks of Being a Wallflower", "2000", .5f);
        listPeliculas.add(peli);

        return listPeliculas;
    }

    // Crea una nueva película a partir de los datos del ActivityOnResult
    public Pelicula nuevaPelicula(){
        Pelicula peli;
        peli = new Pelicula (titulo, "(" + year + ")", calificacion);
        return peli;
    }

    // Toma del resultado del search las variales y las agrega a la listaPeliculas
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode== RESULT_OK) {
            titulo = data.getExtras().get("titulo").toString();
            year = data.getExtras().get("year").toString();
            calificacion = data.getExtras().getFloat("rate");


            listPeliculas.add(nuevaPelicula());

            miAdaptador.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), year, Toast.LENGTH_SHORT).show();
        }
    }

    // Inicia un intent que lleva a la activity de SearchPeliculas
    public void onClickSearch (View v){
        Intent searchIntent = new Intent(PeliculasActivity.this, searchPeliculasActivity.class);
        startActivityForResult(searchIntent, REQUEST_CODE);
    }
}
