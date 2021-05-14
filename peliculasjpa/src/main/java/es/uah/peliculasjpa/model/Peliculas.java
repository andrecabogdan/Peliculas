/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bogdan
 */
@Entity
@Table(name = "peliculas", schema = "peliculasactoresdb")
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private String titulo;
    private int anno;
    private int duracion;
    private String pais;
    private String direccion;
    private String genero;
    private String sinopsis;
    private String imagen;
    
    @ManyToMany(mappedBy = "peliculas")
    @JsonIgnoreProperties("peliculas")
    private List<Actores> actores;

    public Peliculas() {
    }

    public Peliculas(Integer identificador) {
        this.identificador = identificador;
    }

    public Peliculas(Integer identificador, String titulo, int anno, int duracion, String pais, String direccion, String genero, String sinopsis, String imagen) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.anno = anno;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = direccion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
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

    @XmlTransient
    public List<Actores> getActores() {
        return actores;
    }

    public void setActoresList(List<Actores> actores) {
        this.actores = actores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.peliculasjpa.model.Peliculas[ identificador=" + identificador + " ]";
    }
    
    public void addActor(Actores actor) {
        if (actor != null) {
            getActores().add(actor);
        }
    }

    public void removeAlumno(Actores actor) {
        if (actor != null) {
            getActores().remove(actor);
        }
    }
    
}
