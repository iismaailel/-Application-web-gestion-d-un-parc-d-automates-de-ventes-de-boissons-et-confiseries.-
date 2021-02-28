package fr.pwa.webservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@Entity
@Table(name="Automate")
public class Automate{
	@Id
	@Column(name="NumSerie", unique = true, nullable = false)
	private String numSerie;
	@Column(name="TypeT", unique = true, nullable = false)
	private String typeT;
	@Column(name="TYPE" , unique = false, nullable = true)
	private String type;
	@Column(name="Adresse_Insta", unique = false, nullable = true)
	private String adresse_insta;
	@Column(name="DATE", unique = false, nullable = true)
	private String date_dern_intervention;
	@Column(name="EMPLACEMENT", unique = false, nullable = true) 
	private String emplacement;
	@Column(name="GpsLatitude", unique = false, nullable = true) 
	private double gpsLatitude;
	@Column(name="GpsLongitude", unique = false, nullable = true)
	private double gpsLongitude;
	@Column(name="NOTES", unique = false, nullable = true)
	private String notes;
	
	
	public Automate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Automate(String numSerie,String T, String type, String adresse, String emplacement, double gpsLatitude,
			double gpsLongitude, String date_dern_intervention, String notes) {
		super();
		this.numSerie = numSerie;
		this.typeT=T;
		this.type = type;
		this.adresse_insta = adresse;		
		this.date_dern_intervention = date_dern_intervention;
		this.emplacement = emplacement;
		this.gpsLatitude = gpsLatitude;
		this.gpsLongitude = gpsLongitude;
		this.notes = notes;
	}
	 

	
	public String getNumSerie() {
		return numSerie;
	}
	
	@XmlAttribute(name="numSerie")
	public void setNum_serie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	
	public String getTypeT() {
		return typeT;
	}

	public void setTypeT(String typeT) {
		this.typeT = typeT;
	}

	public String getType() {
		return type;
	}
	
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}

	public String getAdresse_insta() {
		return adresse_insta;
	}

	public void setAdresse_insta(String adresse_insta) {
		this.adresse_insta = adresse_insta;
	}

	public String getEmplacement() {
		return emplacement;
	}
	@XmlElement
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	
	public String getDate_dern_intervention() {
		return date_dern_intervention;
	}
	@XmlElement
	public void setDate_dern_intervention(String date_dern_intervention) {
		this.date_dern_intervention = date_dern_intervention;
	}
	public String getNotes() {
		return notes;
	}
	@XmlElement
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getGpsLatitude() {
		return gpsLatitude;
	}

	public void setGpsLatitude(double gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public double getGpsLongitude() {
		return gpsLongitude;
	}

	public void setGpsLongitude(double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}



	
	 
}

