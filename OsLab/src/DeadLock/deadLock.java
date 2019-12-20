/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeadLock;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JackSparrow
 */
public class deadLock {
    public static void main(String [] args){
        final String st1= "Mehedi Hasan Shifat";
        final String st2 = "Bal sal lab";
        
        Thread t1;
        t1 = new Thread(){
            @Override
            public void run(){
                synchronized (st1){
                    System.out.println("This is thread 1 trying to lock resource 1");
                    
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(deadLock.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
                
                synchronized (st2){
                    System.out.println("This is thread 1 trying to lock resource 2");
                    
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(deadLock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                }
                
                
                
            }
        };
        
        
        
        Thread t2;
        t2 = new Thread(){
            @Override
            public void run(){
                synchronized (st2){
                    System.out.println("This is thread 2 trying to lock resource 2");
                    
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(deadLock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                
                synchronized (st1){
                    System.out.println("This is thread 2 trying to lock resource 1");
                    
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(deadLock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                }
                
                
                
            }
        };
        
        
        t1.start();
        t2.start();
    }
    
}
