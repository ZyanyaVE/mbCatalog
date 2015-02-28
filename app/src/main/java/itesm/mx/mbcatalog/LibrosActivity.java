package itesm.mx.mbcatalog;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class LibrosActivity extends ActionBarActivity {

    // Declaracion de variables
    Button addBT;
    ListView librosLV;
    ListViewAdapter miAdaptador;

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

    public List<Libro> getDataForListView(){
        Libro libro;

        List<Libro> listLibros = new ArrayList<Libro>();
        libro = new Libro("Android Programming", "23/10/2010");

        listLibros.add(libro);
        libro = new Libro("Beginning Android", "10/08/2011");

        listLibros.add(libro);
        libro = new Libro("Android in 24 hours, Teach Yourself", "25/03/2014");

        listLibros.add(libro);

        return listLibros;
    }

    public void onClickSearch (View v){
        Intent searchIntent = new Intent(LibrosActivity.this, searchBooksActivity.class);

        startActivity(searchIntent);
    }
}
