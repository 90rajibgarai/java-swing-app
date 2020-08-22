package com.tpete.client.model;


public class Commande 
{
	int numero;
	
	String montant;
	
	public Commande(int numero, String montant) {
		super();
		this.numero = numero;
		this.montant = montant;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int Numero) {
		this.numero = Numero;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}
	
	
}
