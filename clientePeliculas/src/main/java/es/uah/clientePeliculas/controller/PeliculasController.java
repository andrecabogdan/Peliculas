/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.clientePeliculas.controller;

import es.uah.clientePeliculas.model.Pelicula;
import es.uah.clientePeliculas.paginator.PageRender;
import es.uah.clientePeliculas.service.IPeliculasService;
import es.uah.clientePeliculas.service.IUploadFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author Bogdan
 */
@Controller
@RequestMapping("/ppeliculas")
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @Autowired
    private IUploadFileService uploadFileService;

    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

        Resource recurso = null;

        try {
            recurso = uploadFileService.load(filename);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
                .body(recurso);
    }

    @GetMapping(value = {"/", "/home", ""})
    public String home(Model model) {
        return "home";
    }

    @GetMapping(value = "/ver/{identificador}")
    public String ver(Model model, @PathVariable("identificador") Integer identificador, RedirectAttributes attributes) {
        Pelicula pelicula = peliculasService.buscarPeliculasPorId(identificador);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("titulo", "Detalle de la pelicula: " + pelicula.getTitulo());
        return "peliculas/verPelicula";
    }

    @GetMapping("/listado")
    public String listadoPeliculas(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado = peliculasService.buscarTodos(pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/ppeliculas/listado", listado);
        model.addAttribute("titulo", "Listado de todas las peliculas");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @GetMapping("/alta")
    public String alta(Model model
    ) {
        model.addAttribute("titulo", "Alta pelicula");
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        return "peliculas/altaPelicula";
    }

    @GetMapping("/baja")
    public String baja(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listadoPeliculasBaja = peliculasService.buscarTodos(pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/ppeliculas/baja", listadoPeliculasBaja);
        model.addAttribute("titulo", "Baja pelicula");
        model.addAttribute("listadoPeliculas", listadoPeliculasBaja);
        model.addAttribute("page", pageRender);
        return "peliculas/bajaPelicula";
    }

    @GetMapping("/modificar")
    public String modificacion(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listadoPeliculasModificar = peliculasService.buscarTodos(pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/ppeliculas/modificar", listadoPeliculasModificar);
        model.addAttribute("titulo", "Moficacion pelicula");
        model.addAttribute("listadoPeliculas", listadoPeliculasModificar);
        model.addAttribute("page", pageRender);
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        return "peliculas/modificacionPelicula";
    }

    @GetMapping("/buscar")
    public String buscar(Model model) {
        return "peliculas/searchPelicula";
    }

    @GetMapping("/identificador/{identificador}")
    public String buscarPeliculasPorId(Model model, @PathVariable("identificador") Integer identificador) {
        Pelicula pelicula = peliculasService.buscarPeliculasPorId(identificador);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/listPelicula";
    }

    @GetMapping("/titulo")
    public String buscarPeliculasPorTitulo(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam("titulo") String titulo) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado = peliculasService.buscarPeliculasPorTitulo(titulo, pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de peliculas por título");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @GetMapping("/genero")
    public String buscarPeliculasPorGenero(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam("genero") String genero) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Pelicula> listado = peliculasService.buscarPeliculasPorGenero(genero,
                pageable);
        PageRender<Pelicula> pageRender = new PageRender<Pelicula>("/listado", listado);
        model.addAttribute("titulo", "Listado de peliculas por género");
        model.addAttribute("listadoPeliculas", listado);
        model.addAttribute("page", pageRender);
        return "peliculas/listPelicula";
    }

    @PostMapping("/guardar/")
    public String altaPelicula(Model model, Pelicula pelicula, @RequestParam("file") MultipartFile foto, RedirectAttributes attributes) {
        if (pelicula != null) {
            System.out.println(pelicula.getTitulo());
        }
        if (!foto.isEmpty()) {

            if (pelicula.getIdentificador() != null && pelicula.getIdentificador() > 0 && pelicula.getImagen() != null
                    && pelicula.getImagen().length() > 0) {

                uploadFileService.delete(pelicula.getImagen());
            }

            String uniqueFilename = null;
            try {
                uniqueFilename = uploadFileService.copy(foto);
            } catch (IOException e) {
                e.printStackTrace();
            }

            attributes.addFlashAttribute("msg", "Has subido correctamente '" + uniqueFilename + "'");

            pelicula.setImagen(uniqueFilename);
        }
        peliculasService.altaPelicula(pelicula);
        model.addAttribute("titulo", "Nueva pelicula");
        attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron guardados!");
        return "redirect:/ppeliculas/listado";
    }

    @GetMapping("/borrar/{idetificador}")
    public String bajaPelicula(Model model, @PathVariable("idetificador") Integer idetificador, RedirectAttributes attributes) {
        peliculasService.bajaPelicula(idetificador);
        attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron borrados!");
        return "redirect:/ppeliculas/listado";
    }

    @GetMapping("/modificar/{idetificador}")
    public String modificarPelicula(Model model, @PathVariable("idetificador") Integer idetificador, RedirectAttributes attributes) {
        Pelicula pelicula = peliculasService.buscarPeliculasPorId(idetificador);
        if (uploadFileService.delete(pelicula.getImagen())) {
            attributes.addFlashAttribute("msg", "Imagen " + pelicula.getImagen() + " eliminada con exito!");
        }
        model.addAttribute("titulo", "Editar pelicula");
        model.addAttribute("pelicula", pelicula);
        return "peliculas/altaPelicula";
    }


}
