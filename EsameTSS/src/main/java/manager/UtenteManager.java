/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Utente;
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
public class UtenteManager {
    
    @PersistenceContext
    EntityManager em;
    
    //salva un utente
    public Utente save(Utente tosave) {
        return em.merge(tosave);
    }
    
    //trova tutti gli utenti
    public List <Utente> findAll() {
        return em.createQuery("select e from Utente e ORDER BY e.email", Utente.class).getResultList();
        //return em.createQuery("FROM Utente p", Utente.class).getResultList();
    }
    
    public Utente findId(Long id) {
        return em.find(Utente.class, id);
    }
    
    //cancella un utente
    public void remove(Long id) {
        Utente u = em.find(Utente.class, id);
        em.remove(u);
    }

    public Utente findByUserPwd(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
