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
import postit.entity.Utente;

/**
 *
 * @author tss
 */

@Stateless
public class UtenteManager {
    
    @PersistenceContext
    EntityManager em;
    
    //salva un utente
    public Utente save(Utente tosave) {
        return em.merge(tosave);
    }
    
    //trova tutti gli utenti
    public List <Utente> findAll() {
        return em.createNamedQuery("Utente.findAll").getResultList();
    }
    
    public Utente findId(Long id) {
        return em.find(Utente.class, id);
    }
        
    //cancella un utente
    public void delete(Long id) {
        Utente finded = em.find(Utente.class, id);
        em.remove(finded);
    }
    
}
