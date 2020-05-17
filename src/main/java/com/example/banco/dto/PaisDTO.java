package com.example.banco.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.banco.domain.Pais;

public class PaisDTO {
	
	private Integer id;
	private String nome;
	
	public PaisDTO() {
		super();
	}
	
	public PaisDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public static PaisDTO converterPaisemPaisDTO(Pais pais) {
		if(pais != null) {
			return new PaisDTO(pais.getId(), pais.getNome());
		}else {
			return null;
		}
	}
	
	
	public static PaisDTO PaisParaPaisDTO(Pais pais) {
		return new PaisDTO(pais.getId(), pais.getNome());
	}
	
	//@Pattern(regexp = "[1-9]", message = "Atenção! Informe apenas número inteiro para a pesquisa.")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Pattern(regexp = "\\p{L}+", message = "Atenção! Nome do País não deve possuir números.")
	@NotEmpty(message = "Atenção!: Nome do País não pode ser nulo.")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "PaisDTO [id=" + id + ", nome=" + nome + "]";
	}
		

}
