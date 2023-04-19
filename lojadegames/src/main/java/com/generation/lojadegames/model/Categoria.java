package com.generation.lojadegames.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message= "O Nome Da Categoria é  Obrigatorio!")
	@Size(min= 5, max= 100,message= "O Nome Da Categoria deve ter no mínimo 05  e no máximo 100 caracteres")
	private String nomedacategoria;
	
	@NotBlank(message= "A descrição Da Categoria é  Obrigatorio!")
	@Size(min= 5 , max= 250,message= "A descrição Da Categoria deve ter mínimo 05  e no máximo 250 caracteres")
	private String descricaodacategoria;

	
	@OneToMany(fetch= FetchType.LAZY, mappedBy= "categoria", cascade =  CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto>produto;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomedacategoria() {
		return nomedacategoria;
	}

	public void setNomedacategoria(String nomedacategoria) {
		this.nomedacategoria = nomedacategoria;
	}

	public String getDescricaodacategoria() {
		return descricaodacategoria;
	}

	public void setDescricaodacategoria(String descricaodacategoria) {
		this.descricaodacategoria = descricaodacategoria;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
	
	
}
