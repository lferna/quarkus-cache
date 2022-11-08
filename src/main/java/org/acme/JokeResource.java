package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.rest.client.JokeService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheResult;

@Path("/jokes")
public class JokeResource {

	@Inject
	Logger log;
	
    @Inject
    @RestClient
    JokeService jokeService;
	
    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return this.getJoke();
    }
    
    @GET
    @Path("/invalidate")
    @Produces(MediaType.TEXT_PLAIN)
    public String invalidate() {
        this.invalidateCache();
        return "OK";
    }
    
    
    @CacheResult(cacheName = "joke-cache")    
    protected String getJoke() {
    	return jokeService.getJoke();
    }
    

	@CacheInvalidate(cacheName = "joke-cache") 
	protected void invalidateCache(){
		log.info("Caché invalidada");
	}

}
 


