package com.tcc.cantinaDigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
	
	@GetMapping("/cadastrarProduto")
	public String cadastrarProduto() {
		return "CadastroProduto";
	}
	
	@GetMapping("/listaLanches")
	public String listaLanches() {
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