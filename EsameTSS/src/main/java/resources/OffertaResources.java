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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Produces({MediaType.APPLICATION_JSON})
public class OffertaResources {
    
    @Inject
    OffertaManager offertaManager;
    
    @GET
    public List<Offerta> findAll(){
        return offertaManager.findAll();
    }
    
    @POST
    @Path("crea")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create (Offerta offerta) {
        System.out.println("metodo post .... " + offerta);
        offertaManager.save(offerta);
    }
    /* formato JSON - Inserimento nuova OFFERTA [testato con POSTMAN]
    {
    "importo":25000,
    "prodotto":{"idProdotto":1},
    "utente":{"idUtente":7}
    }
    */
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        System.out.println("metodo delete .... " + id);
        offertaManager.delete(id);
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
