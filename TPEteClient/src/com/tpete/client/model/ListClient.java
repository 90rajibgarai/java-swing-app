package com.tpete.client.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="clients")
public class ListClient 
{
	private List<Client> listClients = new ArrayList<>();

	@XmlElement(name="client")
	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}
	
	
}
