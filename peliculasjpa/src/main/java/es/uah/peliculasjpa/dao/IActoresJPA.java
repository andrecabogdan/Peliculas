/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.dao;

import es.uah.peliculasjpa.model.Actores;
import es.uah.peliculasjpa.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Bogdan
 */
public interface IActoresJPA extends JpaRepository<Actores, Integer>{

    Actores findByNombre(String nombre);
}
