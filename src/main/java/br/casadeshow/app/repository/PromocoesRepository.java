package br.casadeshow.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.casadeshow.app.model.*;

@Repository
public interface PromocoesRepository extends JpaRepository<Promocoes,Long> {

}