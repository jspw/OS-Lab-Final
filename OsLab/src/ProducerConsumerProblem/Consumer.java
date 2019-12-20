/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducerConsumerProblem;

/**
 *
 * @author JackSparrow
 */
// Consumer class 
class Consumer implements Runnable { 
    Q q; 
    Consumer(Q q) 
    { 
        this.q = q; 
        new Thread(this, "Consumer").start(); 
    } 
  
    public void run() 
    { 
        for (int i = 0; i < 5; i++) 
            // consumer get items 
            q.get(); 
    } 
} 
