package com.tcc.cantinaDigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcc.cantinaDigital.model.Produto;
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
		modelo.addAttribute("produtos",produtoRepository.findAll());
		return "ListaLanches";
	}
	
	@GetMapping("/LanchesAdm")
	public String LanchesAdm() {
		return "LanchesAdm";
	}
	
	@GetMapping("/listaBebidas")
	public String listarBebidas() {
		return "ListarBebidas";
	}
	
	@GetMapping("/bebidasAdm")
	public String bebidasAdm() {
		return "BebidasAdm";
	}
	
	@GetMapping("/listaDoces")
	public String listarDoces() {
		return "ListarDoces";
	}
	
	@GetMapping("/docesAdm")
	public String docesAdm() {
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