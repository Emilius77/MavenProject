/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.service;

import clienti.entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class ClienteService {

    @PersistenceContext
    EntityManager em;

    
    //trova tutti i clienti
    public List<Cliente> findAll() {
        return em.createNamedQuery("Cliente.all").getResultList();
    }

    
    //salva un cliente
    public Cliente save(Cliente tosave) {
        return em.merge(tosave);
    }

    //cancella un cliente
    public void delete(Long id) {
        Cliente finded = em.find(Cliente.class, id);
        em.remove(finded);
    }
}
