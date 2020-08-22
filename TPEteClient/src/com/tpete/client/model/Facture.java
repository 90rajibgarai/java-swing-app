package com.tpete.client.model;

import java.util.ArrayList;

public class Facture {
	
	String numero;
	
	ArrayList<Commande> commandes;
	
	public Facture(String numero) {
		super();
		this.numero = numero;
		commandes = new ArrayList<>();
	}

	public Facture() {
		// TODO Auto-generated constructor stub
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<Commande> getCommandes() {
		return commandes;
	}

	public void addCommandes(Commande commande) {
		commandes.add(commande);
	}

	public void setCommandes(ArrayList<Commande> commandes) {
		this.commandes = commandes;
	}
		
}
