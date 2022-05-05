package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.ProdutosFarmacia;

      @Repository
      public interface ProdutosRepository extends JpaRepository<ProdutosFarmacia, Long> {
	  public List <ProdutosFarmacia> findAllByNomeProdutosContainingIgnoreCase (@Param("nomeProduto")String nome);
}
