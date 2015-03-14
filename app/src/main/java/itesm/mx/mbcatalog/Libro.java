package itesm.mx.mbcatalog;

/**
 * Created by ZyanyaVE on 2/23/15.
 */
public class Libro {

    private String titulo;
    private String fecha_adicion;
    private String autor;

    // Constructores de clase
    public Libro(){
        super();
    }

    public Libro (String titulo, String autor, String fecha_adicion){
        this.titulo = titulo;
        this.fecha_adicion = fecha_adicion;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha_publicacion() {
        return fecha_adicion;
    }

    public String getAutor() { return autor; }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_adicion(String fecha_adicion) {
        this.fecha_adicion = fecha_adicion;
    }

    public void setAutor() { this.autor = autor; }
}
