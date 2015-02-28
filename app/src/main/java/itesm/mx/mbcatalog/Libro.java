package itesm.mx.mbcatalog;

/**
 * Created by ZyanyaVE on 2/23/15.
 */
public class Libro {

    private String titulo;
    private String fecha_adicion;

    // Constructores de clase
    public Libro(){
        super();
    }

    public Libro (String titulo, String fecha_adicion){
        this.titulo = titulo;
        this.fecha_adicion = fecha_adicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha_publicacion() {
        return fecha_adicion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_adicion(String fecha_adicion) {
        this.fecha_adicion = fecha_adicion;
    }
}
