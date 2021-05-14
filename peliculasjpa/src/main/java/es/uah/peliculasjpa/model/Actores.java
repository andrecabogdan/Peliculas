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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "actores", schema = "peliculasactoresdb")
public class Actores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private String nombre;
    private String fechaNacimiento;
    private String paisNacimiento;
    
    @JoinTable(name = "peliculas_has_actores", joinColumns = {
        @JoinColumn(name = "actores_identificador", referencedColumnName = "identificador")}, inverseJoinColumns = {
        @JoinColumn(name = "peliculas_identificador", referencedColumnName = "identificador")})
    
    @ManyToMany   
    @JsonIgnoreProperties("actores")
    private List<Peliculas> peliculas;

    public Actores() {
    }

    public Actores(Integer identificador) {
        this.identificador = identificador;
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

    @XmlTransient
    public List<Peliculas> getPeliculas() {
        return peliculas;
    }

    public void setPeliculasList(List<Peliculas> peliculasList) {
        this.peliculas = peliculas;
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
        if (!(object instanceof Actores)) {
            return false;
        }
        Actores other = (Actores) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.peliculasjpa.model.Actores[ identificador=" + identificador + " ]";
    }
    
    public void addPelicula(Peliculas pelicula) {
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.addActor(this);
        }
    }

    public void removePelicula(Peliculas pelicula) {
        if (pelicula != null) {
            pelicula.removeAlumno(this);
            getPeliculas().remove(pelicula);
        }
    }
    
}
