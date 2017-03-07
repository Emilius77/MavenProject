/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import postit.entity.Messaggio;


/**
 *
 * @author tss
 */

@Stateless
@Path("messaggi")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

public class MessaggioResources {
    
    @Inject
    MessaggioManager messaggioManager;
    
    @Inject
    UtenteManager utenteManager;
    
    @GET
    public List <Messaggio> all() {
        return messaggioManager.findAll();
    }
    
    @GET
    @Path("{id}")
    public Messaggio find(@PathParam ("id") Long id) {
        return messaggioManager.findId(id);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        messaggioManager.delete(id);
    }
    
    @POST
    public void create(@FormParam("titolo") String titolo, 
            @FormParam("contenuto") String contenuto, 
            @HeaderParam("usr_id") Long user_id ) {
        Messaggio m = new Messaggio(titolo, contenuto, utenteManager.findId(user_id));
        System.out.println(m.toString());
        messaggioManager.save(m);
    }
    
    
}
