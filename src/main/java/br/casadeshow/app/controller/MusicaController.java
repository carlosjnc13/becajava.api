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

import br.casadeshow.app.model.Musica;
import br.casadeshow.app.service.MusicaService;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

	public MusicaService _service;

	@Autowired
	public MusicaController(MusicaService service) {
		_service = service;
	}

	@PostMapping

	public ResponseEntity inserir(@RequestBody Musica musica) {
		
		try {
			_service.inserir(musica);
			return ResponseEntity.status(HttpStatus.CREATED).body("Musica Inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Musica> musica = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(musica);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			Optional<Musica> musica = _service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(musica);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Musica musica, @PathVariable Long id) {
		try {
			_service.atualizar(musica, id);
			return ResponseEntity.status(HttpStatus.OK).body("Musica atualizada com sucesso!");
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
