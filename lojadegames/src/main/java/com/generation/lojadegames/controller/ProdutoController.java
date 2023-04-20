package com.generation.lojadegames.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

import com.generation.lojadegames.model.Produto;
import com.generation.lojadegames.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins="*",allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	//LISTAR TODOS OS PRODUTOS
	@GetMapping
	public ResponseEntity <List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
		
	}
	//BUSCAR POR ID
	@GetMapping("/{id}")
	public ResponseEntity <Produto> getById(@PathVariable Long id){
		
		return produtoRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta) )
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	//BUSCAR POR TITULO
	@GetMapping("/nomeproduto/{nomeproduto}")
	public ResponseEntity<List<Produto>> getByNomeproduto(@PathVariable("nomeproduto") String nomeProduto)  {
		 return ResponseEntity.ok(produtoRepository.findAllByNomedoprodutoContainingIgnoreCase(nomeProduto));
	}
	
	
	//Fazer Metodo do buscar por maior preço
	
	@GetMapping("/preco/{precomaior}")
	public ResponseEntity<List<Produto>> getByPrecoMaior(@PathVariable("precomaior") BigDecimal precoMaior) {
	    List<Produto> produtos = produtoRepository.findAllByPrecoGreaterThanEqual(precoMaior);
	    return ResponseEntity.ok(produtos);
	}

	
	
	
	//CADASTRAR PRODUTO 
	
	@PostMapping
	public ResponseEntity <Produto> post(@Valid @RequestBody Produto produto){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity <Produto> put(@Valid   @RequestBody Produto produto){
		
		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Produto> produto= produtoRepository.findById(id);
		
		if(produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		produtoRepository.deleteById(id);
	}
	
}
