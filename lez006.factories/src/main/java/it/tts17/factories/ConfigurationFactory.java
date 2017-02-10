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
public class ConfigurationFactory {
    
    public static Configuration create() {
        return new EnvConfiguration();
    }
    
}
