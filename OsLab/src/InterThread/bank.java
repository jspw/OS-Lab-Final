
package InterThread;

/**
 *
 * @author JackSparrow
 */
public class bank {
    public static void main(String args[]){
    final customer c = new customer();
    
    new Thread(){
        public void run(){
            c.withdraw(150000);
        }
    }.start();
    
    new Thread(){
        public void run(){
            c.deposit(100000);
        }
    }.start();
    
    
    
    }
    
}
