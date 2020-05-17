package com.example.banco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banco.domain.Pais;
import com.example.banco.dto.PaisDTO;
import com.example.banco.repositories.PaisRepository;
import com.example.banco.services.exception.ObjetoNaoEncontrado;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository paisRepository;
	
	
	public Pais cadastrarPais(PaisDTO paisDTO) {
		
		Pais pais = buscarPais(paisDTO.getNome());
		
		if(pais == null) {
			paisRepository.save(new Pais(null, paisDTO.getNome()));			
			pais = null;		
			pais = buscarPais(paisDTO.getNome());
			return pais;
		}else {
			return null;
		}
		
	}
	
	
	private Pais buscarPais(String nome) {
		
		Pais pais = paisRepository.buscarPaisPorNome(nome);
		return pais;
	}
	
	
	public Pais buscaPaisPorId(PaisDTO paisDTO) {
		
		Optional<Pais> obj = paisRepository.findById(paisDTO.getId());
		return obj.orElseThrow(() -> new ObjetoNaoEncontrado("Objeto id: " + paisDTO.getId() +
				                          " não encontrado. Tipo: " + Pais.class.getName()));
		
	}

}
