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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Produces({MediaType.APPLICATION_JSON})
public class ProdottoResources {
    
    @Inject
    ProdottoManager prodottoManager;
    
    @GET
    public List<Prodotto> findAll() {
    	return prodottoManager.findAll();
    }
    
    @POST
    @Path("crea")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create (Prodotto prodotto) {
        System.out.println("metodo post .... " + prodotto);
        prodottoManager.save(prodotto);
    }
    /* formato JSON - Inserimento nuovo PRODOTTO [testato con POSTMAN]
    {
    "dataScadenza":"2017-07-15T00:00:00+02:00",
    "descrizione":"DescProdotto6",
    "immagine":"ImgProdotto6",
    "nome":"NomeProdotto6",
    "prezzoBase":500,
    "utente":{"idUtente":7}
    }
    */
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        System.out.println("metodo delete .... " + id);
        prodottoManager.delete(id);
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
