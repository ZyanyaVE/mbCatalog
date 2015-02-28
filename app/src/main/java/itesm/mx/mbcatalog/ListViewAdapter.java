package itesm.mx.mbcatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZyanyaVE on 2/23/15.
 */
public class ListViewAdapter extends ArrayAdapter <Libro> {
    private Context context;
    int layoutResourceId;
    List<Libro> listaLibros;

    public ListViewAdapter(Context context, int idResource, List<Libro> libros){
        super(context, idResource, libros);
        this.context = context;
        this.layoutResourceId = idResource;
        this.listaLibros = libros;
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
        TextView fecha_adicion = (TextView) row.findViewById(R.id.fechaAdicionTV);
        ImageView libro_imagen = (ImageView) row.findViewById(R.id.imagenIV);

        // Obtiene el libro que se encuentra en position y modifica los valores de los objetos de la vista
        Libro libro = listaLibros.get(position);
        titulo.setText(libro.getTitulo());
        fecha_adicion.setText(libro.getFecha_publicacion());
        libro_imagen.setImageResource(R.drawable.ic_launcher);

        // Regresa renglon con los datos actualizados
        return row;
    }

}
