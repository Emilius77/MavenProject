/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author tss
 */

//serve per rendere la classe accessibile da una pagina .jsf, se non viene specificato nulla il nome corrisponde 
//a quello della classe java con la lettera minuscola (in questo caso diventa "index")
@Named       
//prendere SEMPRE quella di (javax.enterprise.content)
@RequestScoped  
public class Index {
    
    private String usr;
    private String pwd;

    public Index() {
        System.out.println("chiamata al costruttore () ....");
    }
    
    public String hello() {
        
        return "hello message ...." + System.currentTimeMillis();
    }
    
    public void onInvia() {
        System.out.println("onInvia: " + usr + " - " + pwd);
        usr = "";
    }
    
    public String getMessage() {
        
        return "dynamic getMessage ...." + System.currentTimeMillis();
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
}
