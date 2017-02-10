/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez002.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Program start ..." + System.currentTimeMillis());
        
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "----");
            new Thread(App1::doWork).start();
        }
    }
    
    public static void doWork () {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(".... working ...." + System.currentTimeMillis());
    }
    
}
