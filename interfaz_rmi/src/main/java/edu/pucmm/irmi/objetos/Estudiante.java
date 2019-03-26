package edu.pucmm.irmi.objetos;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Estudiante implements Serializable {

    @Id
    int matricula;
    String nombre;
    String carrera;

    public Estudiante() {
    }

    public Estudiante(int matricula, String nombre, String carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
