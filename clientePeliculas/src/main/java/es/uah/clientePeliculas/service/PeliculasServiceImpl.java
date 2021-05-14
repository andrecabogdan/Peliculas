/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.clientePeliculas.service;

import es.uah.clientePeliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Bogdan
 */
@Service
public class PeliculasServiceImpl implements IPeliculasService {

    @Autowired
    RestTemplate template;
    String url = "http://localhost:8080/peliculas";

    @Override
    public Page<Pelicula> buscarTodos(Pageable pageable) {
        Pelicula[] peliculas = template.getForObject(url, Pelicula[].class);
        List<Pelicula> cursosList = Arrays.asList(peliculas);
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Pelicula> list;
        if (cursosList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, cursosList.size());
            list = cursosList.subList(startItem, toIndex);
        }
        Page<Pelicula> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize),
                cursosList.size());
        return page;
    }

    @Override
    public Pelicula buscarPeliculasPorId(Integer identificador) {
        Pelicula pelicula = template.getForObject(url + "/" + identificador, Pelicula.class);
        return pelicula;
    }

    @Override
    public Page<Pelicula> buscarPeliculasPorTitulo(String titulo, Pageable pageable) {
        Pelicula[] peliculas = template.getForObject(url + "/titulo/" + titulo,
                Pelicula[].class);
        List<Pelicula> lista = Arrays.asList(peliculas);
        Page<Pelicula> page = new PageImpl<>(lista, pageable, lista.size());
        return page;
    }

    @Override
    public Page<Pelicula> buscarPeliculasPorGenero(String genero, Pageable pageable) {
        Pelicula[] peliculas = template.getForObject(url + "/genero/" + genero,
                Pelicula[].class);
        List<Pelicula> lista = Arrays.asList(peliculas);
        Page<Pelicula> page = new PageImpl<>(lista, pageable, lista.size());
        return page;
    }

    @Override
    public void altaPelicula(Pelicula pelicula) {
        if (pelicula.getIdentificador() != null && pelicula.getIdentificador() > 0) {
            template.put(url, pelicula);
        } else {
            pelicula.setIdentificador(0);
            template.postForObject(url, pelicula, String.class);
        }
    }

    @Override
    public void bajaPelicula(Integer idetificadorPelicula) {
        template.delete(url + "/" + idetificadorPelicula);
    }

}
