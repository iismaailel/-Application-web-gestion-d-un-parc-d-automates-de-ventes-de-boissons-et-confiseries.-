package fr.pwa.webservice.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ArticleId implements Serializable{
	private static final long serialVersionUID = 1L;
	private String numSerie;
	private String nom;
	public ArticleId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleId(String numSerie, String nom) {
		super();
		this.numSerie = numSerie;
		this.nom = nom;
	}


	
}