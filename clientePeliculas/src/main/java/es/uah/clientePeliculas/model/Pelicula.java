/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.clientePeliculas.model;

import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Pelicula {

    private Integer identificador;
    private String titulo;
    private int anno;
    private int duracion;
    private String pais;
    private String direccion;
    private String genero;
    private String sinopsis;
    private String imagen;
    private List<Actor> actores;

    public Pelicula() {
    }

    public Pelicula(Integer identificador) {
        this.identificador = identificador;
    }

    public Pelicula(Integer identificador, String titulo, int anno, int duracion, String pais, String direccion, String genero, String sinopsis, String imagen, List<Actor> actores) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.anno = anno;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = direccion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        actores = actores;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "identificador=" + identificador + "titulo=" + titulo + "año" + anno + "duracion=" + duracion + "pais=" + pais + "ddireccion=" + direccion + "genero=" + genero + "sinopsis=" + sinopsis + "imgen=" + imagen;
    }

}
