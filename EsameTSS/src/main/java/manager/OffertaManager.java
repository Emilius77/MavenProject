/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Offerta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Emilio Fucà
 * 
 */

@Stateless
public class OffertaManager {
    
    @PersistenceContext
    EntityManager em;
    
    //salva un'offerta
    public Offerta save (Offerta tosave) {
        return em.merge(tosave);
    }
    
    //trova tutti i prodotti
    public List <Offerta> findAll() {
        return em.createNamedQuery("Offerta.findAll").getResultList();
    }
    
    public Offerta findById(Long id) {
        return em.find(Offerta.class, id);
    }
    
    //cancella prodotto
    public void delete (Long id) {
        Offerta finded = em.find(Offerta.class, id);
        em.remove(finded);
    }
    
}
