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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

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
    
    public Utente findByUserPwd(String usr, String pwd) {
        Utente result = null;
        
        //usiamo il try & catch per evitare che, in caso il parametro ".getSingleResult" mandi in crash
        //il sistema perchè non abbiamo passato i parametri
        try{
        return em.createNamedQuery(Utente.FIND_BY_USER_PWD, Utente.class)
                .setParameter("usr", usr)
                .setParameter("pwd", pwd)
                .getSingleResult();
    }catch(NoResultException ex) {       
    }
        return result;
    }
    
    //cancella un utente
    public void delete(Long id) {
        Utente finded = em.find(Utente.class, id);
        em.remove(finded);
    }
    
}
