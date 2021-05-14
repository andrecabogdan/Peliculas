/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.dao;

import es.uah.peliculasjpa.model.Peliculas;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bogdan
 */
@Repository
public class PeliculasDAOImpl implements IPeliculasDAO {

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Peliculas> buscarTodos() {
        return peliculasJPA.findAll();
    }

    @Override
    public Peliculas buscarPeliculasPorId(Integer idPelicula) {
        Optional<Peliculas> optional = peliculasJPA.findById(idPelicula);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Peliculas> buscarPeliculasPorTitulo(String titulo) {
        return peliculasJPA.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Peliculas> buscarPeliculasPorGenero(String genero) {
        peliculasJPA.findByGeneroContainingIgnoreCase(genero);
        peliculasJPA.findByGeneroContainingIgnoreCase(genero);
        return peliculasJPA.findByGeneroContainingIgnoreCase(genero);
    }

    @Override
    public void altaPelicula(Peliculas pelicula) {
        peliculasJPA.save(pelicula);
    }

    @Override
    public void bajaPelicula(Integer identificadorPelicula) {
        peliculasJPA.deleteById(identificadorPelicula);
    }

    @Override
    public void modificarPelicula(Peliculas pelicula) {
        peliculasJPA.save(pelicula);
    }

}
