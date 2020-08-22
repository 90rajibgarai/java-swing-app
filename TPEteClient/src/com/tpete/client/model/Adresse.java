package com.tpete.client.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Adresse 
{	
	String rue;	
	String NPA;
	
	public Adresse( String rue, String nPA) {
		super();
		this.rue = rue;
		NPA = nPA;
	}

	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNPA() {
		return NPA;
	}

	public void setNPA(String nPA) {
		NPA = nPA;
	}
	
	
}
