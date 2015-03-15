package itesm.mx.mbcatalog;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class LibrosActivity extends ActionBarActivity {

    // Declaracion de variables
    Button addBT;
    ListView librosLV;
    ListViewAdapter miAdaptador;
    String titulo = "hola", autor = "crayola", fecha = "12/12/12";
    List<Libro> listLibros = new ArrayList<Libro>();
    private static final int REQUEST_CODE = 1;
    float calificacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);

        // Linkeo de variable con elementos en pantalla
        addBT = (Button) findViewById(R.id.addBT);
        librosLV = (ListView) findViewById(R.id.librosLV);

        // Adaptador de Arreglo
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        };
        librosLV.setOnItemClickListener(itemListener);

        // Creacion de adaptador de arreglo
        miAdaptador = new ListViewAdapter(getApplicationContext(), R.layout.rowl, getDataForListView());
        librosLV.setAdapter(miAdaptador);
    }

    // Agrega cada libro a la lista que se utiliza para la variable miAdaptador
    public List<Libro> getDataForListView(){
        Libro libro;

        libro = new Libro ("Hello Kitty", "Jo Rowling", "12/12/2012", 4);
        listLibros.add(libro);
        libro = new Libro ("Harry Potter and the Deathly Hallows", "J.K. Rowling", "12/12/2012", 5);
        listLibros.add(libro);
        libro = new Libro ("The Secrets of the Immortal Nicholas Flammel: The Necromancer", "Michael Scott", "12/12/2012", 3.5f);
        listLibros.add(libro);
        libro = new Libro ("The Fault in Our Stars", "John Green", "12/12/2012", 2);
        listLibros.add(libro);
        libro = new Libro ("The Name of The Wind", "Patrick Rothfuss", "12/12/2012", 2.5f);
        listLibros.add(libro);
        libro = new Libro ("Percy Jackson: The Son of Neptune", "Rick Riordan", "12/12/2012", 4.5f);
        listLibros.add(libro);
        libro = new Libro ("Angels and Demons", "Dan Brown", "12/12/2012", 5);
        listLibros.add(libro);
        libro = new Libro ("The Lord of the Rings: The Two Towers", "J.R.R Tolkien", "12/12/2012", 1);
        listLibros.add(libro);

        return listLibros;
    }

    public Libro nuevoLibro(){
        Libro libro;
        libro = new Libro (titulo, autor, fecha, calificacion);
        return libro;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode== RESULT_OK) {
            titulo = data.getExtras().get("titulo").toString();
            autor = data.getExtras().get("autor").toString();
            fecha = data.getExtras().get("fecha").toString();
            calificacion = data.getExtras().getFloat("rate");


            listLibros.add(nuevoLibro());

            miAdaptador.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Exito", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSearch (View v){
        Intent searchIntent = new Intent(LibrosActivity.this, searchBooksActivity.class);
        startActivityForResult(searchIntent, REQUEST_CODE);
    }
}
