package com.proyecto.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.ClienteEntity;

public interface ClienteService {
	void crearCliente(ClienteEntity clienteEntity, MultipartFile foto);
    List<ClienteEntity> listadoClients();
    ClienteEntity buscarClientePorId(Integer id);
}
