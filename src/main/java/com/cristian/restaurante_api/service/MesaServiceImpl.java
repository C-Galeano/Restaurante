package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Mesa;
import com.cristian.restaurante_api.repository.MesaRepository;
import com.cristian.restaurante_api.service.MesaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServiceImpl implements MesaService {

    private final MesaRepository mesaRepository;

    public MesaServiceImpl(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @Override
    public List<Mesa> listar() {
        return mesaRepository.findAll();
    }

    @Override
    public Mesa guardar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public Mesa buscarPorId(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }
}