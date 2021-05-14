/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.dao;

import es.uah.peliculasjpa.model.Actores;
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
public class ActoresDAOImpl implements IActoresDAO{

    @Autowired
    IActoresJPA actoresJPA;

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Actores> buscarTodos() {
        return actoresJPA.findAll();
    }

    @Override
    public Actores buscarActoresPorId(Integer idActor) {
        Optional<Actores> optional = actoresJPA.findById(idActor);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Actores buscarActoresPorNombre(String nombre) {
        Optional<Actores> optional = Optional.ofNullable(actoresJPA.findByNombre(nombre));
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void altaActor(Actores actor) {
        actoresJPA.save(actor);
    }

    @Override
    public void bajaActor(Integer identificadorActor) {
        Optional<Actores> optional = actoresJPA.findById(identificadorActor);
        if (optional.isPresent()) {
            Actores actor = optional.get();
            List<Peliculas> peliculas = actor.getPeliculas();
            for (Peliculas pelicula : peliculas) {
                peliculas.remove(actor);
            }
        }
        actoresJPA.deleteById(identificadorActor);
    }

    @Override
    public void modificarActor(Actores actor) {
        actoresJPA.save(actor);
    }

}
