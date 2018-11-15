
package modelos;

public class Profesores {
    private int id_profesor;
    private String nombre;
    private int id_colegio;
    private int id_asignatura;
    private String activo;
    
    public Profesores() {
    }

    public Profesores(String nombre, int id_colegio, int id_asignatura, String activo) {
        this.nombre = nombre;
        this.id_colegio = id_colegio;
        this.id_asignatura = id_asignatura;
        this.activo = activo;
    }

    public Profesores(int id_profesor, String nombre, int id_colegio, int id_asignatura, String activo) {
        this.id_profesor = id_profesor;
        this.nombre = nombre;
        this.id_colegio = id_colegio;
        this.id_asignatura = id_asignatura;
        this.activo = activo;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(int id_colegio) {
        this.id_colegio = id_colegio;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }


}