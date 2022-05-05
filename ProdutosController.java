package com.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.farmacia.model.ProdutosFarmacia;
import com.generation.farmacia.repository.ProdutosRepository;

@RestController
@RequestMapping ("/produtos")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ProdutosController {
    
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutosFarmacia>> GetAll (){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	@GetMapping ("/{id}")
	public ResponseEntity<ProdutosFarmacia>getById(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map (resposta-> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND ).build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutosFarmacia>> getByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeProdutosContainingIgnoreCase(nome));

    }
   @PostMapping 
    public ResponseEntity<ProdutosFarmacia> post (@RequestBody ProdutosFarmacia produto ){
	    return ResponseEntity.status(HttpStatus.CREATED).body (produtosRepository.save(produto));
    }
   @PutMapping
    public ResponseEntity<ProdutosFarmacia> put (@RequestBody ProdutosFarmacia produto){
	    return ResponseEntity.status(HttpStatus.OK).body (produtosRepository.save(produto));

    }
   @ResponseStatus(HttpStatus.NO_CONTENT)
   @DeleteMapping("/{id}")
   public void delete(@PathVariable long id) {
	   java.util.Optional<ProdutosFarmacia> Produto =produtosRepository.findById(id);
		
		if(Produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		produtosRepository.deleteById(id);
	   
   }
}
