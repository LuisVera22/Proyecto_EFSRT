package com.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.ClienteEntity;
import com.proyecto.repository.ClienteRepository;
import com.proyecto.service.ClienteService;
import com.proyecto.utils.Utilitarios;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    
    @Override
    public List<ClienteEntity> listadoClients() {
        // TODO Auto-generated method stub
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity buscarClientePorId(Integer id) {
        // TODO Auto-generated method stub
        return clienteRepository.findById(id).get();
    }

	@Override
	public void crearCliente(ClienteEntity clienteEntity, MultipartFile foto) {
		String urlFoto = Utilitarios.guardarImagen(foto);
		clienteEntity.setUrlImagen(urlFoto);
		String hashearPassword = Utilitarios.hashPassword(clienteEntity.getContrasenia());
		clienteEntity.setContrasenia(hashearPassword);
		clienteRepository.save(clienteEntity);
		
	}
    
}
