package com.tcc.cantinaDigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tcc.cantinaDigital.model.Usuario;
import com.tcc.cantinaDigital.repository.UsuarioRepository;
import com.tcc.cantinaDigital.service.CarrinhoService;

@Controller
public class PagamentoController {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CarrinhoService carrinhoService;
	
	@GetMapping("/escolhaPagamento")
	public String escolhaPagamento() {
		return "EscolhaPagamento";
	}
	
	 @GetMapping("/pagamentoPix")
	    public String pagamentoPix(Model modelo) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String nomeUsuario = authentication.getName();
	        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
	        
	        float totalCarrinho = carrinhoService.calcularTotalCarrinho(usuario.getIdUsuario());

	        modelo.addAttribute("totalCarrinho", totalCarrinho);

	        return "pagamentoPix";
	    }
}