package com.generation.lojadegames.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name="tb_usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull (message = "O Atributo Nome é Obrigatorio!")
	private String nome;
	
	
	@NotNull (message = "O Atributo Usuario é Obrigatorio!")
	@Email (message = "O Atributo Usuario deve ser um email valido!")
	private String usuario;
	
	
	@NotNull (message = "O Atributo Senha é Obrigatorio!")
	@Size (min= 5, message="O Atributo Senha deve ter no minimo 5 caracteres!")
	private String senha;
	
	
	
	@Size (max= 5000, message= "A Foto não poder ter mais que  5000 caracteres!")
	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	

}
