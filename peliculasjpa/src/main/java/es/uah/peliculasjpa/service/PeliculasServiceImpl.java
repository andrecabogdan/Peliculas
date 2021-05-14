/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.service;

import es.uah.peliculasjpa.dao.IPeliculasDAO;
import es.uah.peliculasjpa.model.Peliculas;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bogdan
 */
@Service
public class PeliculasServiceImpl implements IPeliculasService {

    @Autowired
    IPeliculasDAO peliculasDAO;

    @Override
    public List<Peliculas> buscarTodos() {
        return peliculasDAO.buscarTodos();
    }

    @Override
    public Peliculas buscarPeliculasPorId(Integer idPelicula) {
        return peliculasDAO.buscarPeliculasPorId(idPelicula);
    }

    @Override
    public List<Peliculas> buscarPeliculasPorTitulo(String titulo) {
        return peliculasDAO.buscarPeliculasPorTitulo(titulo);
    }

    @Override
    public List<Peliculas> buscarPeliculasPorGenero(String genero) {
        return peliculasDAO.buscarPeliculasPorGenero(genero);
    }

    @Override
    public boolean altaPelicula(Peliculas pelicula) {
        if (peliculasDAO.buscarPeliculasPorId(pelicula.getIdentificador()) == null) {
            peliculasDAO.altaPelicula(pelicula);
            return true;
        }
        return false;
    }

    @Override
    public boolean bajaPelicula(Integer identificadorPelicula) {
        if (peliculasDAO.buscarPeliculasPorId(identificadorPelicula) != null) {
            peliculasDAO.bajaPelicula(identificadorPelicula);
            return true;
        }
        return false;
    }

    @Override
    public void modificarPelicula(Peliculas pelicula) {
        if (peliculasDAO.buscarPeliculasPorId(pelicula.getIdentificador()) != null) {
            peliculasDAO.modificarPelicula(pelicula);
        }
    }
}
