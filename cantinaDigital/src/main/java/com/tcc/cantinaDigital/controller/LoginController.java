package com.tcc.cantinaDigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcc.cantinaDigital.model.Papel;
import com.tcc.cantinaDigital.model.Usuario;
import com.tcc.cantinaDigital.repository.PapelRepository;
import com.tcc.cantinaDigital.repository.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired
    private BCryptPasswordEncoder encoderSenha;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String vazio() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Usuario usuario, Model modelo) {
	    return "redirect:/menuPedidos";
	}
	
	@GetMapping("/criarConta")
	public String criarConta(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "CriarConta";
	}
	
	@PostMapping("/criarConta")
	public String registrarUsuario(@ModelAttribute Usuario usuario, Model modelo) {
	    if (usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario()) != null) {
	        modelo.addAttribute("mensagem", "Nome de usuário já existe!");
	        return "registrar";
	    }
	    usuario.setSenha(encoderSenha.encode(usuario.getSenha()));
	    Papel papelUsuario = papelRepository.findByNomePapel("ROLE_USER");
	    usuario.getPapeis().add(papelUsuario);
	    usuarioRepository.save(usuario);

	    return "redirect:/login";
	}
}