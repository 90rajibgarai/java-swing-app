package com.tpete.client.ws;
/*
import javax.ws.rs.core.*;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;
import com.tpete.client.model.ListClient;

public class RestFulClient
{
	private WebResource webResource;	
	private Client client;	
	private static final String BASE_URL = "http://localhost:8080/TPEte/";
	
		
	public RestFulClient()
	{
		client = Client.create(new DefaultClientConfig());
		webResource = client.resource(BASE_URL).path("rest");
	}
	
	public ListClient getAllClients() throws UniformInterfaceException
	{
		return webResource.path("clients").accept(MediaType.APPLICATION_ATOM_XML)
				.get(ListClient.class);
	}
	
	public com.tpete.client.model.Client findByClientName(String name) throws UniformInterfaceException
	{
		return webResource.path("clients").path("/"+name).accept(MediaType.APPLICATION_ATOM_XML)
					.get(com.tpete.client.model.Client.class);
	}
		
	public com.tpete.client.model.Client findByOrderId(int id) throws UniformInterfaceException
	{
		return webResource.path("clients").path("/commandes/"+id).accept(MediaType.APPLICATION_ATOM_XML)
					.get(com.tpete.client.model.Client.class);
	}
	
	public void close()	{
		client.destroy();
	}
}*/
