/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import entity.Utente;
import manager.UtenteManager;
import com.airhacks.TokenNeeded_old;

/**
 * curl -i -X POST -H "Content-Type: application/json" -d '{"usr":"davide","pwd":"davide"}' http://localhost:8080/lez020-postit/resources/utenti/login

 *
 * @author tss
 */

@Stateless
@Path("utenti")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

public class UtenteResources {
    
    @Inject
    UtenteManager utenteManager;
    
    @GET
    @TokenNeeded_old
    public List <Utente> all() {
        return utenteManager.findAll();
    }
    
    @GET
    @TokenNeeded_old
    @Path("{id}")
    public Utente find(@PathParam ("id") Long id) {
        return utenteManager.findId(id);
    }
    
    @DELETE
    @TokenNeeded_old
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        utenteManager.delete(id);
    }
    
    @POST
    public void create(@FormParam("usr") String usr, 
            @FormParam("pwd") String pwd, 
            @FormParam("email") String email) {
        Utente u = new Utente(usr, pwd, email);
        utenteManager.save(u);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create (Utente utente) {
        utenteManager.save(utente);
    }
    
    @POST
    @Path("login")
    public Response login(Utente u) {
        if (u == null) {
            return Response.serverError()
                    .header("caused-by", "nessun dato per effettuare la login")
                    .build();
        }
        //System.out.println("login ..." + u);
        Utente finded = utenteManager.findByUserPwd(u.getUsr(), u.getPwd());
        
        if (finded == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .header("caused-by","login fallito")
                .build();
        }
        
        JsonObject json = Json.createObjectBuilder()
                .add("id_token", finded.getId())
                .build();
        return Response.ok(json).build();
    }
    
    /* ---- TEST RESOURCES ---- */
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String prova() {
		System.out.println("ok Utenti");
		return "ok Utenti";
	}
	/* ---- TEST RESOURCES ---- */
}
