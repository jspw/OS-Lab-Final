
package InterThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JackSparrow
 */
class customer {
    int amount = 10000;
    
    synchronized void withdraw(int amount){
        System.out.println("Going to WithDraw");
        
        if(this.amount<amount){
            System.out.println("Less balance ; Wait for deposit");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else
            this.amount-=amount;
        System.out.println("Withdraw completed");
    }
    
    synchronized void deposit(int amount){
        System.out.println("Going to Deposit");
        this.amount+=amount;
        System.out.println("Deposit Completed");
        notify();
    }
    
    
    
}
