/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Prodotto;
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
public class ProdottoManager {
    
    @PersistenceContext
    EntityManager em;
    
    //salva un prodotto
    public Prodotto save (Prodotto tosave) {
        return em.merge(tosave);
    }
    
    //trova tutti i prodotti
    public List <Prodotto> findAll() {
        return em.createQuery("select e from Prodotto e", Prodotto.class).getResultList();
    }
    
    public Prodotto findById(Long id) {
        return em.find(Prodotto.class, id);
    }
    
    //cancella prodotto
    public void delete (Long id) {
        Prodotto finded = em.find(Prodotto.class, id);
        em.remove(finded);
    }
    
    
    
    
    
    
    
    
    
    
}
