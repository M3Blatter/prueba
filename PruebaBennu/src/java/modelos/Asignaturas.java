/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Martín Blatter
 */
public class Asignaturas {
    private int id_asignatura;
    private String nombre;

    public Asignaturas() {
    }

    public Asignaturas(String nombre) {
        this.nombre = nombre;
    }

    public Asignaturas(int id_asignatura, String nombre) {
        this.id_asignatura = id_asignatura;
        this.nombre = nombre;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
