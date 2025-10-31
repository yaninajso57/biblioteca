package com.example.biblioteca.controller;

import com.example.biblioteca.entity.Libro;
import com.example.biblioteca.service.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class LibroController {
    @Autowired
    private LibroServiceImpl libroServiceImpl; //Se inyecta la dependendia

    @GetMapping
    public List<Libro> obtenerTodos(){
        return this.libroServiceImpl.getLibros();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibros(@PathVariable Long id){
        return this.libroServiceImpl.getLibro(id);
    }

    @PostMapping
    void guardarOActualizarLibro(@RequestBody Libro libro)
    {
        this.libroServiceImpl.guardarOActualizarLibro(libro);
    }

    @DeleteMapping("/{libroId}")
    void eliminarLibro(@PathVariable("libroId")Long libroId){
        this.libroServiceImpl.eliminarLibro(libroId);
    }
    {}

}
