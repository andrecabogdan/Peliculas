/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.clientePeliculas.controller;

import es.uah.clientePeliculas.model.Actor;
import es.uah.clientePeliculas.paginator.PageRender;
import es.uah.clientePeliculas.service.IActoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bogdan
 */
@Controller
@RequestMapping("/cactores")
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping(value = {"/", "/home", ""})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/listado")
    public String listadoAlumnos(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> listado = actoresService.buscarTodos(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/cactores/listado", listado);
        model.addAttribute("titulo", "Listado de todos los actores");
        model.addAttribute("listadoActores", listado);
        model.addAttribute("page", pageRender);
        return "actores/listActor";
    }

    @GetMapping("/alta")
    public String alta(Model model) {
        model.addAttribute("titulo", "Alta actor");
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "actores/altaActor";
    }

    @GetMapping("/baja")
    public String baja(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> listadoActoresBaja = actoresService.buscarTodos(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/cactores/baja", listadoActoresBaja);
        model.addAttribute("titulo", "Baja actor");
        model.addAttribute("listadoActores", listadoActoresBaja);
        model.addAttribute("page", pageRender);
        return "actores/bajaActor";
    }

    @GetMapping("/modificar")
    public String modificacion(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> listadoActoresModificar = actoresService.buscarTodos(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/cactores/modificar", listadoActoresModificar);
        model.addAttribute("titulo", "Moficacion actor");
        model.addAttribute("listadoActores", listadoActoresModificar);
        model.addAttribute("page", pageRender);
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "actores/modificacionActor";
    }

    @GetMapping("/buscar")
    public String buscar(Model model) {
        return "actores/searchActor";
    }

    @GetMapping("/identificador/{identificador}")
    public String buscarActoresPorId(Model model, @PathVariable("identificador") Integer identificador) {
        Actor actor = actoresService.buscarActoresPorId(identificador);
        model.addAttribute("actor", actor);
        return "actores/listActor";
    }

    @PostMapping("/guardar/")
    public String altaActor(Model model, Actor actor, RedirectAttributes attributes) {
        if (actor != null) {
            System.out.println(actor.getNombre());
        }
        actoresService.altaActor(actor);
        model.addAttribute("titulo", "Nuevo Actor");
        attributes.addFlashAttribute("msg", "Los datos del actor fueron guardados!");
        return "redirect:/cactores/listado";
    }

    @GetMapping("/borrar/{idetificador}")
    public String bajaActor(Model model, @PathVariable("idetificador") Integer idetificador, RedirectAttributes attributes) {
        actoresService.bajaActor(idetificador);
        attributes.addFlashAttribute("msg", "Los datos del actor fueron borrados!");
        return "redirect:/cactores/listado";
    }

    @GetMapping("/modificar/{idetificador}")
    public String modificarActor(Model model, @PathVariable("idetificador") Integer idetificador, RedirectAttributes attributes) {
        Actor actor = actoresService.buscarActoresPorId(idetificador);
        model.addAttribute("titulo", "Editar actor");
        model.addAttribute("actor", actor);
        return "actores/altaActor";
    }

}
