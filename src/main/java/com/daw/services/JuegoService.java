package com.daw.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daw.persistence.entities.JuegoEntity;
import com.daw.persistence.enums.Tipo;
import com.daw.persistence.repositories.JuegoRepository;
import com.daw.services.exceptions.JuegoNotFoundException;

@Service
public class JuegoService {

    @Autowired
    private JuegoRepository juegoRepository;

    public List<JuegoEntity> obtenerTodos() {
        return juegoRepository.findAll();
    }

    public JuegoEntity obtenerPorId(Integer id) {
        return juegoRepository.findById(id)
                .orElseThrow(() -> new JuegoNotFoundException("Juego no encontrado: " + id));
    }

    public JuegoEntity crear(JuegoEntity juego) {
        if (juego.getFechaLanzamiento() == null) {
            juego.setFechaLanzamiento(LocalDate.now());
        }
        return juegoRepository.save(juego);
    }

    public JuegoEntity modificar(Integer id, JuegoEntity juegoActualizado) {
        JuegoEntity existente = obtenerPorId(id);
        existente.setNombre(juegoActualizado.getNombre());
        existente.setGenero(juegoActualizado.getGenero());
        existente.setPlataformas(juegoActualizado.getPlataformas());
        existente.setPrecio(juegoActualizado.getPrecio());
        existente.setDescargas(juegoActualizado.getDescargas());
        existente.setFechaLanzamiento(juegoActualizado.getFechaLanzamiento());
        existente.setTipo(juegoActualizado.getTipo());
        return juegoRepository.save(existente);
    }

    public void borrar(Integer id) {
        if (!juegoRepository.existsById(id)) {
            throw new JuegoNotFoundException("Juego no encontrado: " + id);
        }
        juegoRepository.deleteById(id);
    }

    public List<JuegoEntity> buscarPorGenero(String genero) {
        return juegoRepository.findByGeneroIgnoreCase(genero);
    }

    public List<JuegoEntity> buscarPorNombre(String nombre) {
        return juegoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<JuegoEntity> buscarPorPlataforma(String plataforma) {
        return juegoRepository.findByPlataformasContainingIgnoreCase(plataforma);
    }

    public List<JuegoEntity> buscarPorTipo(Tipo tipo) {
        return juegoRepository.findByTipo(tipo);
    }

    public List<JuegoEntity> buscarPorRangoPrecio(Double min, Double max) {
        return juegoRepository.findByPrecioBetween(min, max);
    }

    public List<JuegoEntity> obtenerTop5Exitos() {
        return juegoRepository.findTop5ByOrderByDescargasDesc();
    }

    public JuegoEntity alternarCompletado(Integer id) {
        JuegoEntity juego = obtenerPorId(id);
        juego.setCompletado(!juego.isCompletado());
        return juegoRepository.save(juego);
    }

    public void aplicarDescuentoMasivo(String genero, Double porcentaje) {
        List<JuegoEntity> juegos = buscarPorGenero(genero);
        for (JuegoEntity juego : juegos) {
            if (juego.getPrecio() != null) {
                double nuevoPrecio = juego.getPrecio() * (1 - porcentaje);
                juego.setPrecio(nuevoPrecio);
            }
        }
        juegoRepository.saveAll(juegos);
    }
}