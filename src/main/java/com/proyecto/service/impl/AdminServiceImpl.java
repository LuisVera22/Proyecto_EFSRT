package com.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.AdministradorEntity;
import com.proyecto.repository.AdminRepository;
import com.proyecto.service.AdminService;
import com.proyecto.utils.Utilitarios;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public void crearAdmin(AdministradorEntity adminEntity, MultipartFile foto) {
		//Guardando image
		String nombreFoto= Utilitarios.guardarImagen(foto);
		adminEntity.setFoto(nombreFoto);
		//Hash password
		String hashPassword = Utilitarios.hashPassword(adminEntity.getContrasenia());
		adminEntity.setContrasenia(hashPassword);
		
		
		adminRepository.save(adminEntity);
	}

	@Override
	public List<AdministradorEntity> listarAdmins() {
		
		return adminRepository.findAll();
	}

	@Override
	public AdministradorEntity buscarPorId(Integer idAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarAdmin(AdministradorEntity adminFormulario) {
		AdministradorEntity	adminEncontrado = adminRepository.findByEmail(adminFormulario.getEmail());
		if(adminEncontrado==null) {
			return false;
		}
		if(!Utilitarios.checkPassword(adminFormulario.getContrasenia(), 	
				adminEncontrado.getContrasenia())) {
			return false;
		}
		
		return true;
	}

	@Override
	public void actualizarAdmin(Integer idAdmin, AdministradorEntity administradorEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAdmin(Integer idAdmin) {
		// TODO Auto-generated method stub
		
	}

}
