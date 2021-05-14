/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.service;

import es.uah.peliculasjpa.dao.IActoresDAO;
import es.uah.peliculasjpa.model.Actores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bogdan
 */
@Service
public class ActoresServiceImpl implements IActoresService{

    @Autowired
    IActoresDAO actoresDAO;

    @Override
    public List<Actores> buscarTodos() {
        return actoresDAO.buscarTodos();
    }

    @Override
    public Actores buscarActoresPorId(Integer idActor) {
        return actoresDAO.buscarActoresPorId(idActor);
    }

    @Override
    public Actores buscarActoresPorNombre(String nombre) {
        return actoresDAO.buscarActoresPorNombre(nombre);
    }

    @Override
    public void altaActor(Actores actor) {
        actoresDAO.altaActor(actor);
    }

    @Override
    public void bajaActor(Integer identificadorActor) {
        actoresDAO.bajaActor(identificadorActor);
    }

    @Override
    public void modificarActor(Actores actor) {
        actoresDAO.modificarActor(actor);
    }

}
