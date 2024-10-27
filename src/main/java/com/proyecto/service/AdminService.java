package com.proyecto.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.AdministradorEntity;

public interface AdminService {

	void crearAdmin(AdministradorEntity adminEntity, MultipartFile foto);
	List<AdministradorEntity> listarAdmins();
	AdministradorEntity buscarPorId(Integer IdAdmin);
	boolean validarAdmin (AdministradorEntity adminEntity);
	void actualizarAdmin(Integer idAdmin, AdministradorEntity administradorEntity);
	void eliminarAdmin(Integer IdAdmin);
}
