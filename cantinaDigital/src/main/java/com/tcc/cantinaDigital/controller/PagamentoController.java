package com.tcc.cantinaDigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcc.cantinaDigital.model.Carrinho;
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
	    public String escolhaPagamento(Model modelo) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String nomeUsuario = authentication.getName();
	        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);

	        Carrinho carrinho = usuario.getCarrinho();
	        if (carrinho == null || carrinho.getProdutos().isEmpty()) {
	            modelo.addAttribute("mensagem", "Não é possível finalizar a compra com o carrinho vazio.");
	            return "redirect:/carrinho";
	        }

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

	    @PostMapping("/confirmarPagamentoPix")
	    public String confirmarPagamentoPix() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String nomeUsuario = authentication.getName();
	        Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);

	        carrinhoService.limparCarrinho(usuario.getIdUsuario());

	        return "redirect:/menuPedidos";
	    }
	    
	    @GetMapping("/pedidos")
		public String pedidos() {
			return "pedidos";
		}
}