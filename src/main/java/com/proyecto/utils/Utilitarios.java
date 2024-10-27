package com.proyecto.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.multipart.MultipartFile;

public class Utilitarios {
    public static String guardarImagen(MultipartFile foto){
        try {
            Path pathDire = Paths.get("src/main/resources/static/img/guardados/");
            if (!Files.exists(pathDire)) {
                Files.createDirectories(pathDire);
            }
            
            byte[] fotoBytes= foto.getBytes();
    		Path pathImagen = Paths.get("src/main/resources/static/img/guardados/" + 
    				foto.getOriginalFilename());
    		
    			Files.write(pathImagen, fotoBytes);
    			return foto.getOriginalFilename();
    			
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("error al cargar la foto"+e.getMessage());
            return null;
        }
        
    }
    
    public static String hashPassword(String password) {
    	return BCrypt.hashpw(password, BCrypt.gensalt());
    }

	public static boolean checkPassword(String passwordFormulario, String hashPassword) {
		
		return BCrypt.checkpw(passwordFormulario, hashPassword);
	}
}
