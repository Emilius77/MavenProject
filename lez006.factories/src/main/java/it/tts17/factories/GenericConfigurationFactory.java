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
public class GenericConfigurationFactory {
    
    public static Object create() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> clazz = Class.forName("it.tts17.factories.EnvConfiguration");
        return (Configuration) clazz.newInstance();
        
    }
    
}
