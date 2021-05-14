/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.clientePeliculas.service;

import es.uah.clientePeliculas.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Bogdan
 */
public interface IPeliculasService {

    Page<Pelicula> buscarTodos(Pageable pageable);

    Pelicula buscarPeliculasPorId(Integer idPelicula);

    Page<Pelicula> buscarPeliculasPorTitulo(String titulo, Pageable pageable);

    Page<Pelicula> buscarPeliculasPorGenero(String genero, Pageable pageable);

    void altaPelicula(Pelicula pelicula);

    void bajaPelicula(Integer idetificadorPelicula);
}
