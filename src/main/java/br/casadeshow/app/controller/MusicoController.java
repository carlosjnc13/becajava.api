package br.casadeshow.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casadeshow.app.model.*;
import br.casadeshow.app.service.*;

@RestController
@RequestMapping("/Musicos")
public class MusicoController {
	
		public MusicoService _service;
		
		@Autowired
		public MusicoController(MusicoService service) {
			_service = service;
		}

		@PostMapping
		public ResponseEntity inserir(@RequestBody Musico musico) {
			try {
			_service.inserir(musico);
			return ResponseEntity.status(HttpStatus.CREATED).body("Musico Inserido com sucesso!");
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
		}
		
		@GetMapping
		public ResponseEntity listar() {
			try {
			Iterable<Musico> musico= _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(musico);
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
		}
		
		 @GetMapping(path = "/{id}") 
		 public ResponseEntity obter(@PathVariable Long id) {
			 try {
			 Optional<Musico> banda = _service.obter(id);
			 return ResponseEntity.status(HttpStatus.OK).body(banda);
			 }catch(Exception e) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
			}
		 }
		 
		    
		 @PutMapping(path = "/{id}") 
		 public ResponseEntity atualizar(@RequestBody Musico musico, @PathVariable Long id) {
			 try {
			 _service.atualizar(musico, id);
			 return ResponseEntity.status(HttpStatus.OK).body("Banda atualizada com sucesso!");
			 }catch(Exception e) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
			}
		 }
		     	        
		 @DeleteMapping(path = "/{id}")
		  public ResponseEntity delete(@PathVariable Long id) {
			 try {
			 _service.deletar(id);
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			 }catch(Exception e) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
			}
		        }
		
}
