/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tts17.thread.sync;

/**
 *
 * @author tss
 */
public class Counter {
    
    private int c = 0;

    public synchronized void increment() throws InterruptedException {
        Thread.sleep(100);
        c++;
    }

    public synchronized void decrement() throws InterruptedException {
        Thread.sleep(100);
        c--;
    }

    public int value() {
        return c;
    }
    
}
