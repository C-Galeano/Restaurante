package com.cristian.restaurante_api.controller;

import com.cristian.restaurante_api.model.Mesa;
import com.cristian.restaurante_api.service.MesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
@CrossOrigin("*")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    // LISTAR
    @GetMapping
    public List<Mesa> listar() {
        return mesaService.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Mesa buscar(@PathVariable Long id) {
        return mesaService.buscarPorId(id);
    }

    // GUARDAR
    @PostMapping
    public Mesa guardar(@RequestBody Mesa mesa) {
        return mesaService.guardar(mesa);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        mesaService.eliminar(id);
    }
}