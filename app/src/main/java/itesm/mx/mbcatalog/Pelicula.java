package itesm.mx.mbcatalog;

/**
 * Created by ZyanyaVE on 3/13/15.
 */
public class Pelicula {
    String titulo;
    String year;
    Float rate;


    public Pelicula(){
        super();
    }

    public Pelicula(String titulo, String year, float rate) {
        this.titulo = titulo;
        this.year = year;
        this.rate = rate;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRate (Float rate) {this.rate = rate;}

    public float getRate() {return rate;}

}
