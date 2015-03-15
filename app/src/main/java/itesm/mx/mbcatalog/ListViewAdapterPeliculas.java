package itesm.mx.mbcatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ZyanyaVE on 3/13/15.
 */
public class ListViewAdapterPeliculas extends ArrayAdapter<Pelicula> {

    private Context context;
    int layoutResourceId;
    List<Pelicula> listaPeliculas;


    public ListViewAdapterPeliculas(Context context, int idResource, List<Pelicula> peliculas){
        super(context, idResource, peliculas);
        this.context = context;
        this.layoutResourceId = idResource;
        this.listaPeliculas = peliculas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;

        // convertView --> vista a reusar, si es nulo se crea
        if (row == null){
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);
        }

        // Obtiene las referencias a los objetos de renglon
        TextView titulo = (TextView) row.findViewById(R.id.tituloTV);
        TextView year = (TextView) row.findViewById(R.id.yearTV);
        ImageView peliImagen = (ImageView) row.findViewById(R.id.imagenIV);
        RatingBar rate = (RatingBar) row.findViewById(R.id.calificacionRB);

        // Obtiene el libro que se encuentra en position y modifica los valores de los objetos de la vista
        Pelicula pelicula = listaPeliculas.get(position);
        titulo.setText(pelicula.getTitulo());
        year.setText(String.valueOf(pelicula.getYear()));
        peliImagen.setImageResource(R.drawable.ic_launcher);
        rate.setRating(pelicula.getRate());

        // Regresa renglon con los datos actualizados
        return row;
    }
}
