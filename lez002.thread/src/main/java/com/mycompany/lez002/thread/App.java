/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez002.thread;

/**
 *
 * @author tss
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Thread th = new Thread(App::doWork);
        Thread th1 = new Thread(App::doWork1);
            
        th.start();
        th1.start();

        for (long i = 0; i < Long.MAX_VALUE; i++) {
            System.out.println("°°°° main work in progress °°°°" + System.currentTimeMillis());
        }
    }
                

    public static void doWork() {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            System.out.println("---- other work in progress ----" + System.currentTimeMillis());
        }
    }
    
    public static void doWork1() {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            System.out.println("++++ sbarelliamo un po' ++++" + System.currentTimeMillis());
        }
    }

}
