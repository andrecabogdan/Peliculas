/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.dao;

import es.uah.peliculasjpa.model.Peliculas;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Bogdan
 */
public interface IPeliculasJPA extends JpaRepository<Peliculas, Integer> {

    List<Peliculas> findByTituloContainingIgnoreCase(String titulo);

    List<Peliculas> findByGeneroContainingIgnoreCase(String genero);

}
