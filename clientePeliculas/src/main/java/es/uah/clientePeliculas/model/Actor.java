/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.clientePeliculas.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Actor {

    private Integer identificador;
    private String nombre;
    private String fechaNacimiento;
    private String paisNacimiento;

    private List<Pelicula> peliculas;

    public Actor() {
    }

    public Actor(Integer identificador) {
        this.identificador = identificador;
    }

    public Actor(String nombre,String fechaNacimiento,String paisNacimiento) {
        this.identificador = 0;
        this.nombre=nombre;
        this.fechaNacimiento=fechaNacimiento;
        this.paisNacimiento=paisNacimiento;
        this.peliculas=new ArrayList<>();
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

}
