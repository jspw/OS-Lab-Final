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
// Driver class 
class PC { 
    public static void main(String args[]) 
    { 
        // creating buffer queue 
        Q q = new Q(); 
  
        // starting consumer thread 
        new Consumer(q); 
  
        // starting producer thread 
        new Producer(q); 
    } 
} 