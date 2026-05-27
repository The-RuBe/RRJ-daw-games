package com.daw.web.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.daw.persistence.entities.JuegoEntity;
import com.daw.persistence.enums.Tipo;
import com.daw.services.JuegoService;

@RestController
@RequestMapping("/juego")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @GetMapping
    public List<JuegoEntity> listarTodos() {
        return juegoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public JuegoEntity obtenerUno(@PathVariable Integer id) {
        return juegoService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JuegoEntity crear(@RequestBody JuegoEntity juego) {
        return juegoService.crear(juego);
    }

    @PutMapping("/{id}")
    public JuegoEntity modificar(@PathVariable Integer id, @RequestBody JuegoEntity juego) {
        return juegoService.modificar(id, juego);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        juegoService.borrar(id);
    }

    @GetMapping("/buscar/genero")
    public List<JuegoEntity> buscarPorGenero(@RequestParam String genero) {
        return juegoService.buscarPorGenero(genero);
    }

    @GetMapping("/buscar/nombre")
    public List<JuegoEntity> buscarPorNombre(@RequestParam String nombre) {
        return juegoService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar/plataforma")
    public List<JuegoEntity> buscarPorPlataforma(@RequestParam String plataforma) {
        return juegoService.buscarPorPlataforma(plataforma);
    }

    @GetMapping("/buscar/tipo")
    public List<JuegoEntity> buscarPorTipo(@RequestParam Tipo tipo) {
        return juegoService.buscarPorTipo(tipo);
    }

    @GetMapping("/dlc")
    public List<JuegoEntity> listarDlc() {
        return juegoService.buscarPorTipo(Tipo.DLC);
    }

    @GetMapping("/base")
    public List<JuegoEntity> listarBase() {
        return juegoService.buscarPorTipo(Tipo.BASE);
    }

    @GetMapping("buscar/precio")
    public List<JuegoEntity> buscarPorPrecio(@RequestParam Double min, @RequestParam Double max) {
        return juegoService.buscarPorRangoPrecio(min, max);
    }

    @GetMapping("/exitos")
    public List<JuegoEntity> topExitos() {
        return juegoService.obtenerTop5Exitos();
    }

    @PutMapping("/{id}/alternar-completado")
    public JuegoEntity alternarCompletado(@PathVariable Integer id) {
        return juegoService.alternarCompletado(id);
    }

    @PutMapping("/descuento-masivo")
    public void aplicarDescuentoMasivo(@RequestParam String genero, @RequestParam Double porcentaje) {
        juegoService.aplicarDescuentoMasivo(genero, porcentaje);
    }
}