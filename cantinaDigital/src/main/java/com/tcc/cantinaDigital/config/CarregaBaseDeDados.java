package com.tcc.cantinaDigital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tcc.cantinaDigital.model.Usuario;
import com.tcc.cantinaDigital.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoderSenha;
	@Bean
	CommandLineRunner executar() {
	    return args -> {
	        Usuario adm = new Usuario();
	        adm.setNomeUsuario("adm");
	        adm.setEmail("adm@adm");
	        adm.setSenha(encoderSenha.encode("senha123"));
	        usuarioRepository.save(adm);
	    };
	}
}