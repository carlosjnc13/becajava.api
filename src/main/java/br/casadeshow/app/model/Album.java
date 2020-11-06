package br.casadeshow.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private Long Ano;
	private String Gravadora;
	
	@ManyToOne
	@JoinColumn(name = "BandaId")
	private Banda banda;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getAno() {
		return Ano;
	}

	public void setAno(Long ano) {
		Ano = ano;
	}

	public String getGravadora() {
		return Gravadora;
	}

	public void setGravadora(String gravadora) {
		Gravadora = gravadora;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	

}
