/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducerConsumerProblem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author JackSparrow
 */
class Q { 
    // an item 
    int item; 
  
    // semCon initialized with 0 permits 
    // to ensure put() executes first 
    static Semaphore semCon = new Semaphore(0); 
  
    static Semaphore semProd = new Semaphore(1); 
  
    // to get an item from buffer 
    void get() 
    { 
        try { 
            // Before consumer can consume an item, 
            // it must acquire a permit from semCon 
            semCon.acquire(); 
        } 
        catch (InterruptedException e) { 
            System.out.println("InterruptedException caught"); 
        } 
  
        // consumer consuming an item 
        System.out.println("Consumer consumed item : " + item); 
  
        // After consumer consumes the item, 
        // it releases semProd to notify producer 
        semProd.release(); 
    } 
  
    // to put an item in buffer 
    void put(int item) 
    { 
        try { 
            // Before producer can produce an item, 
            // it must acquire a permit from semProd 
            semProd.acquire(); 
        } 
        catch (InterruptedException e) { 
            System.out.println("InterruptedException caught"); 
        } 
  
        // producer producing an item 
        this.item = item; 
  
        System.out.println("Producer produced item : " + item); 
  
        // After producer produces the item, 
        // it releases semCon to notify consumer 
        semCon.release(); 
    } 
} 