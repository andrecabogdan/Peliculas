/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.clientePeliculas.service;


import es.uah.clientePeliculas.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 *
 * @author Bogdan
 */
public interface IActoresService {

    Page<Actor> buscarTodos(Pageable pageable);

    Actor buscarActoresPorId(Integer idActor);

    Page<Actor> buscarActoresPorNombre(String nombre,Pageable pageable);

    void altaActor(Actor actor);

    void bajaActor(Integer identificadorActor);

}
