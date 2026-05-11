package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario guardar(Usuario usuario);

    Usuario buscarPorId(Long id);

    void eliminar(Long id);
}