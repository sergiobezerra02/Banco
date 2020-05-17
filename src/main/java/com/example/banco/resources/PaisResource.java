package com.example.banco.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.banco.domain.Pais;
import com.example.banco.dto.PaisDTO;
import com.example.banco.responses.Response;
import com.example.banco.services.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisResource {
	
	@Autowired
	private PaisService paisService;
	
	
	@PostMapping(value = "/{cadastrar}")
	public ResponseEntity<Response<PaisDTO>> cadastrarPais(@Valid @RequestBody PaisDTO paisDTO,
			                                                                   BindingResult result){
		
		Response<PaisDTO> response = new Response<PaisDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(erros -> response.getErros().add(erros.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		paisDTO = PaisDTO.converterPaisemPaisDTO(paisService.cadastrarPais(paisDTO));
		
		if(paisDTO != null) {
			response.setData(paisDTO);
			return ResponseEntity.ok(response);
		}else {
		    response.setMsg("Ateção! País já cadastrado");
		    return ResponseEntity.unprocessableEntity().body(response);
		}
		
	}
	

}
