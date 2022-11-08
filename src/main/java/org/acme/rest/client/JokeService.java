package org.acme.rest.client;

import javax.ws.rs.GET;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="jokes-api")
public interface JokeService {

    @GET
    public String getJoke();
	
}
