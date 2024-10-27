package com.tcc.cantinaDigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcc.cantinaDigital.model.Produto;
import com.tcc.cantinaDigital.model.Tipo;
import com.tcc.cantinaDigital.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/cadastrarProduto")
	public String cadastrarProduto(Model modelo) {
		modelo.addAttribute("produto", new Produto());
		return "CadastroProduto";
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/menuAdm";
	}
	
	@GetMapping("/listaLanches")
	public String listaLanches(Model modelo) {
	    modelo.addAttribute("produtos", produtoRepository.findByTipo(Tipo.Salgado));
	    return "ListaLanches";
	}
	
	@GetMapping("/LanchesAdm")
	public String LanchesAdm(Model modelo) {
		modelo.addAttribute("produtos", produtoRepository.findByTipo(Tipo.Salgado));
		return "LanchesAdm";
	}
	
	@GetMapping("/listaBebidas")
	public String listarBebidas(Model modelo) {
		modelo.addAttribute("produtos", produtoRepository.findByTipo(Tipo.Bebida));
		return "ListarBebidas";
	}
	
	@GetMapping("/bebidasAdm")
	public String bebidasAdm(Model modelo) {
		modelo.addAttribute("produtos", produtoRepository.findByTipo(Tipo.Bebida));
		return "BebidasAdm";
	}
	
	@GetMapping("/listaDoces")
	public String listarDoces(Model modelo) {
		modelo.addAttribute("produtos", produtoRepository.findByTipo(Tipo.Doce));
		return "ListarDoces";
	}
	
	@GetMapping("/docesAdm")
	public String docesAdm(Model modelo) {
		modelo.addAttribute("produtos", produtoRepository.findByTipo(Tipo.Doce));
		return "docesAdm";
	}
	
	@GetMapping("/menuPedidos")
	public String menuPedidos() {
		return "MenuPedidos";
	}
	
	@GetMapping("/menuAdm")
	public String menuAdm() {
		return "MenuAdm";
	}
}