package fr.pwa.webservice.model;

import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="Rapport")
public class Rapport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID" , unique = true, nullable = false)
	 private int id;
	@Column(name="DATE", unique = false, nullable = true)
	 private String date;
	@Column(name="STATUT", unique = false, nullable = true)
	 private String statut;
	@Column(name="ETAT", unique = false, nullable = true)
	 private String etat;
	 @Column(name="MONAIE", unique = false, nullable = true)
	 private String monaie; 
	 @Column(name="MONTANT", unique = false, nullable = true)
	 private int montant;
	 @Column(name="CARTE", unique = false, nullable = true)
	 private String carte;	 
	 @Column(name="TEMPERATURE", unique = false, nullable = true)
	 private int temperature;
	 @Column(name="SansContact", unique = false, nullable = true)
	 private String sansContact;
	 @Column(name="ERREURS", unique = false, nullable = true)
	 private String erreurs;
	 @Column(name="NumSerie", unique = false, nullable = true)
	 private String numSerieR;
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL
		        )
	 private List<Article> articles= new ArrayList<>();

	 public Rapport(String numSerie,String date,String statut,String etat,int temp,String mona,String carte,String sansContact,int mont,List<Article> articles){
		 this.numSerieR=numSerie;
		 this.date=date;
		 this.statut=statut;
		 this.etat=etat;
		 this.temperature=temp;
		 this.monaie=mona;
		 this.carte=carte;
		 this.sansContact=sansContact;
		 this.montant=mont;
		ListIterator<Article> it = articles.listIterator();
		     while(it.hasNext()) {
					this.articles.add(it.next());
	         }
	 }
	 @XmlElement(name="numSerieR") 
	public String getNumero_serie() {
		return numSerieR;
	}
	
	public void setNumero_serie(String numSerieR) {
		this.numSerieR = numSerieR;
	}
	@XmlElement(name="date")
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	@XmlElement(name="statut")
	public String getStatut() {
		return statut;
	}
	
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@XmlElement(name="etat")
	public String getEtat() {
		return etat;
	}
	
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@XmlElement(name="temperature")
	public int getTemperature() {
		return temperature;
	}
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	@XmlElement(name="monaie")
	public String getMonaie() {
		return monaie;
	}

	public void setMonaie(String monaie) {
		this.monaie = monaie;
	}
	@XmlElement(name="carte")
	public String getCarte() {
		return carte;
	}
	
	public void setCarte(String carte) {
		this.carte = carte;
	}
	@XmlElement(name="sansContact")
	public String getSans_contact() {
		return sansContact;
	}
	
	public void setSans_contact(String sansContact) {
		this.sansContact = sansContact;
	}
	@XmlElement(name="erreurs")
	public String getErreurs() {
		return erreurs;
	}
	
	public void setErreurs(String erreurs) {
		this.erreurs = erreurs;
	}
	@XmlElementWrapper(name="articles")
	@XmlElement(name="article")
	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@XmlElement(name="montant")
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setIdrapp(int id) {
		this.id = id;
	}
	public Rapport() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	@Override
	public String toString() {
		return "Rapport [id=" + id + ", numSerieR=" + numSerieR + ", statut=" + statut + ", etat=" + etat
				+ ", articles=" + articles + "]";
	}

	
}
