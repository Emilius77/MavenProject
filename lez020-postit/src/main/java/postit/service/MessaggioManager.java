/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import postit.entity.Messaggio;

/**
 *
 * @author tss
 */

@Stateless
public class MessaggioManager {
    
    @PersistenceContext
    EntityManager em;
    
    //salva un messaggio
    public Messaggio save(Messaggio tosave) {
        System.out.println("save: " + tosave.toString());
        return em.merge(tosave);
    }
    
    //trova tutti i messaggi
    public List <Messaggio> findAll() {
        return em.createNamedQuery("Messaggio.findAll").getResultList();
    }
    
    //trova il messaggio tramite ID
    public Messaggio findId(Long id) {
        return em.find(Messaggio.class, id);
    }
    
    //cancella un messaggio
    public void delete(Long id) {
        Messaggio finded = em.find(Messaggio.class, id);
        em.remove(finded);
    }
    
}
