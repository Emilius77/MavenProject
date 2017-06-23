/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import entity.Utente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import manager.UtenteManager;

/**
 *
 * @author tss
 */
@RequestScoped
public class TokenManager {
    
    @Inject
    UtenteManager utentiManager;
    
    private Utente utente;

    public boolean validateToken(String token){
        boolean result = false;
        try{
            int id = Integer.parseInt(token);
            utente = utentiManager.findId(Long.MIN_VALUE);
            result=true;
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return result;
    }

    public Utente getCurrentUser() {
        return utente;
    }
    
    
}
