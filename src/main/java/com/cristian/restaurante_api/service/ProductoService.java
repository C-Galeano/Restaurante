package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listar();

    Producto guardar(Producto producto);

    Producto buscarPorId(Long id);

    void eliminar(Long id);
}