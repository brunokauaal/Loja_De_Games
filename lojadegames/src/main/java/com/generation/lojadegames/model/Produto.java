package com.generation.lojadegames.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message= "O Nome Do Produto é  Obrigatorio!")
	@Size(min= 5, max= 100,message= "O Nome Do Produto deve ter no mínimo 05  e no máximo 100 caracteres")
	private String nomedoproduto;
	
	@NotBlank(message= "A descrição Do Produto é  Obrigatorio!")
	@Size(min= 5 , max= 500,message= "A descrição Do Produto deve ter mínimo 05  e no máximo 500 caracteres")
	private String descricaodoproduto;
	
	
	@NotNull(message= "O Preço é  Obrigatorio!")
	@Positive(message= "O Preço Deve ser maior que zero!")
	private BigDecimal preco;
	
	private int quantidade;
	
	private String foto;
	
	private Long curtir;
	
	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	//GETERS E SETERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomedoproduto() {
		return nomedoproduto;
	}

	public void setNomedoproduto(String nomedoproduto) {
		this.nomedoproduto = nomedoproduto;
	}

	public String getDescricaodoproduto() {
		return descricaodoproduto;
	}

	public void setDescricaodoproduto(String descricaodoproduto) {
		this.descricaodoproduto = descricaodoproduto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getCurtir() {
		return curtir;
	}

	public void setCurtir(Long curtir) {
		this.curtir = curtir;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
