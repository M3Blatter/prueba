
package modelos;


public class Colegios {
    private int id_colegio;
    private String nombre,direccion;

    public Colegios() {
    }

    public Colegios(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Colegios(int id_colegio, String nombre, String direccion) {
        this.id_colegio = id_colegio;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(int id_colegio) {
        this.id_colegio = id_colegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
