package com.tpete.client.data;

import java.util.ArrayList;

import com.tpete.client.model.Adresse;
import com.tpete.client.model.Client;
import com.tpete.client.model.Commande;
import com.tpete.client.model.Facture;

public class Data 
{
	 private  ArrayList<Client> clients = new ArrayList<>();

	 private  int idCommande;
	 
	 public Data() {
		 Client c;
		 Facture f;
		 
		 idCommande=0;
		 
		 c = new Client("Cole","India");
		 c.addAdresse(new Adresse("Chemin de Pont-Ceard 24", "1290"));
		 c.addAdresse(new Adresse("Alstettenstrasse 140", "8048"));
		 c.addAdresse(new Adresse("Chemin de Pont-Ceard 36", "1290"));
		 clients.add(c);
		 
		 f = new Facture("1");
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"10"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"112"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"212"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"133"));
		 c.addFacture(f);
		 f = new Facture("2");
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"2220"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"3121"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"522"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"623"));
		 c.addFacture(f);
		 
		 c = new Client("Valentine","Joshua");
		 c.addAdresse(new Adresse("Chemin des verdiers 8", "1226"));
		 c.addAdresse(new Adresse("Chemin des verdiers 36", "1226"));
		 c.addAdresse(new Adresse("Chemin des verdiers 19", "1226"));
		 clients.add(c);
		 f = new Facture("3");
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"3440"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"351"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"3762"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"3223"));
		 c.addFacture(f);
		 f = new Facture("4");
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"1420"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"1441"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"332"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"43"));
		 c.addFacture(f);
		 
		 c = new Client("Chelsea","Neville");
		 c.addAdresse(new Adresse("Chemin des verdiers 1", "1226"));
		 c.addAdresse(new Adresse("Chemin des verdiers 2", "1226"));
		 c.addAdresse(new Adresse("Chemin des verdiers 3", "1226"));
		 clients.add(c);
		 f = new Facture("5");
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"570"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"518"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"252"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"531"));
		 c.addFacture(f);
		 
		 c = new Client("Cherokee","Deborah");
		 c.addAdresse(new Adresse("Alstettenstrasse 1", "8048"));
		 c.addAdresse(new Adresse("Alstettenstrasse 12", "8048"));
		 c.addAdresse(new Adresse("Alstettenstrasse 123", "8048"));
		 c.addAdresse(new Adresse("Alstettenstrasse 4", "8048"));
		 c.addAdresse(new Adresse("Alstettenstrasse 5", "8048"));
		 c.addAdresse(new Adresse("Alstettenstrasse 6", "8048"));
		 f = new Facture("6");
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"120"));
		 idCommande++;
		 f.addCommandes(new Commande(idCommande,"1233"));
		 c.addFacture(f);
		 clients.add(c); 
	 }
	

	public ArrayList<Client> getClients() {
		return clients;
	}
	public Client getClient(String nom) {
		for(Client c : clients)
			if(c.getNom().equals(nom)) return c;
		return null;
	}
	public Client getClient(int idCommande) 
	{
		for(Client c : clients)
			for(Facture f : c.getFactures())
				for(Commande co : f.getCommandes())
					if(co.getNumero()==(idCommande)) return c;
		return null;
	}
	
}
