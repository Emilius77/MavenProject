/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez002.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Program start ..." + System.currentTimeMillis());
        
        ExecutorService pool = Executors.newFixedThreadPool(20);
        
        for (int i = 0; i < 100; i++) {
            System.out.println("--- " +i);
            pool.submit(App2::doWork);
        }
        System.out.println("-- fine ciclo");
    }
    
    public static void doWork () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(".... working ...." + System.currentTimeMillis());
    }
    
}
