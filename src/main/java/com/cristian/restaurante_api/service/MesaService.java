package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Mesa;

import java.util.List;

public interface MesaService {

    List<Mesa> listar();

    Mesa guardar(Mesa mesa);

    Mesa buscarPorId(Long id);

    void eliminar(Long id);
}