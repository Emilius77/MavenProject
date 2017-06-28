/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entity.Prodotto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import manager.ProdottoManager;

/**
 *
 * @author Emilio Fucà
 * 
 */

@Stateless
@Path("prodotti")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ProdottoResources {
    
    @Inject
    ProdottoManager prodottoManager;
    
    @GET
    public List<Prodotto> findAll() {
    	return prodottoManager.findAll();
    }
    
    /* ---- TEST RESOURCES ---- */
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String prova() {
		System.out.println("ok Prodotti");
		return "ok Prodotti";
	}
    /* ---- TEST RESOURCES ---- */
    
}
