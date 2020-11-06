package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class MusicaService {

	final MusicaRepository _repository;
	
	@Autowired
	public MusicaService(MusicaRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Musica musica) {
		musica.setId(0L);
		_repository.save(musica);
	}
	
	public List<Musica> listar(){
		return _repository.findAll();
	}
	
	public Optional<Musica> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Musica musica,Long id) {
		musica.setId(id);
		_repository.save(musica);
	}
	
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
	
}
