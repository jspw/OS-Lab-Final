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
// Producer class 
class Producer implements Runnable { 
    Q q; 
    Producer(Q q) 
    { 
        this.q = q; 
        new Thread(this, "Producer").start(); 
    } 
  
    public void run() 
    { 
        for (int i = 0; i < 5; i++) 
            // producer put items 
            q.put(i); 
    } 
} 