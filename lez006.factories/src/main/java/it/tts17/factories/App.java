/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tts17.factories;

import java.util.Map;

/**
 *
 * @author tss
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // TODO code application logic here
        
        Configuration conf = (Configuration) GenericConfigurationFactory.create();
        
        Work work = new Work();
        work.dowork(conf);
        
    }
    
}
