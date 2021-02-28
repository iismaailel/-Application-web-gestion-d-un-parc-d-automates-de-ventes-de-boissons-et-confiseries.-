package fr.pwa.webservice.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("unused")

@XmlRootElement

@Entity
@IdClass(ArticleId.class)
@Table(name="Article")
public class Article {
	@Id
	@Column(name="NUM_SERIE", unique = false, nullable = true)
	private String numSerie;
	@Id
	@Column(name="NOM", unique = false, nullable = true)
	private String nom;
	@Column(name="QUANTITE", unique = false, nullable = true)
	private int quantite;
	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String numSerie, String nom, int quantite) {
		super();
		this.numSerie = numSerie;
		this.nom = nom;
		this.quantite = quantite;
	}
	@XmlAttribute(name="numSerie")
	public String getNum_serie() {
		return numSerie;
	}
	
	public void setNum_serie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	@XmlAttribute(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlAttribute(name="quantite")
	public int getQuantite() {
		return quantite;
	}
	
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "Article [numSerie=" + numSerie + ", nom=" + nom + ", quantite=" + quantite + "]";
	}
	
	}

	

