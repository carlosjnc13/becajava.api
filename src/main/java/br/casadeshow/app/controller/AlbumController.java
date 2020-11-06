package br.casadeshow.app.controller;

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

import br.casadeshow.app.model.Album;
import br.casadeshow.app.service.AlbumService;

@RestController
@RequestMapping("/albuns")
public class AlbumController {

	public AlbumService _service;

	@Autowired
	public AlbumController(AlbumService service) {
		_service = service;
	}
	@PostMapping

	public ResponseEntity inserir(@RequestBody Album album) {
		
		try {
			_service.inserir(album);
			return ResponseEntity.status(HttpStatus.CREATED).body("Album Inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Album> album = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(album);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			Optional<Album> album = _service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(album);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Album album, @PathVariable Long id) {
		try {
			_service.atualizar(album, id);
			return ResponseEntity.status(HttpStatus.OK).body("Album atualizada com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		try {
			_service.deletar(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

}
