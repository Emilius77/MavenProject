/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez002.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO code application logic here

        System.out.println("Program start ..." + System.currentTimeMillis());

        Callable<String> messageProvider = App3::getMessage;
        List<Future<String>> results = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            Future<String> result = pool.submit(messageProvider);
            results.add(result);
        }

        for (Future<String> result : results) {
            String r = result.get();
            System.out.println("+++" + r);
        }

        pool.shutdownNow();
        System.out.println("Program stop ..." + System.currentTimeMillis());
    }

    public static String getMessage() throws InterruptedException {
        Thread.sleep(2000);
        return "--- message" + System.currentTimeMillis();
    }

}
