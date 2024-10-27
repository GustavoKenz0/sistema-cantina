package com.tcc.cantinaDigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.cantinaDigital.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto,Long>{
	
}