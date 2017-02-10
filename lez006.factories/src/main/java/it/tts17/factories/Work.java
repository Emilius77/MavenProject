/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tts17.factories;

/**
 *
 * @author tss
 */
public class Work {
    
    public void dowork (Configuration conf) {
        System.out.println("Sto eseguendo il lavoro con la configurazione: " + conf.getClass());
        System.out.println(conf.getValue("PATH"));
    }
    
}
