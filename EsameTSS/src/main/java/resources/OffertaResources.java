/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entity.Offerta;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import manager.OffertaManager;

/**
 *
 * @author Emilio Fucà
 * 
 */

@Stateless
@Path("offerte")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class OffertaResources {
    
    @Inject
    OffertaManager offertaManager;
    
    @GET
    public List<Offerta> findAll(){
        return offertaManager.findAll();
    }
    
    /* ---- TEST RESOURCES ---- */
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String prova() {
		System.out.println("ok Offerte");
		return "ok Offerte";
	}
    /* ---- TEST RESOURCES ---- */
    
    
}
