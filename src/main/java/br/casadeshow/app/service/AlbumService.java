package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class AlbumService {

	final AlbumRepository _repository;
	
	@Autowired
	public AlbumService(AlbumRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Album album) {
		album.setId(0L);
		_repository.save(album);
	}
	
	public List<Album> listar(){
		return _repository.findAll();
	}
	
	public Optional<Album> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Album album,Long id) {
		album.setId(id);
		_repository.save(album);
	}
	
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
	
}
