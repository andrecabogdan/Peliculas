/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.service;

import es.uah.peliculasjpa.model.Actores;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public interface IActoresService {

    List<Actores> buscarTodos();

    Actores buscarActoresPorId(Integer idActor);

    Actores buscarActoresPorNombre(String nombre);

    void altaActor(Actores actor);

    void bajaActor(Integer identificadorActor);

    void modificarActor(Actores actor);

}
