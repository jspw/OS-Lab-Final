/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiningPhiosopher;

/**
 *
 * @author JackSparrow
 */
public class dinner_philosopherMain {
    public static void main(String argv[]) {
		
			int philosophersNumber = 5;
		  
		   final philosopher philosophers[] = new philosopher[philosophersNumber];
		   Fork forks[] = new Fork[philosophersNumber];
	   

	    for (int i = 0; i < philosophersNumber; i++) {
	      forks[i] = new Fork();
	    }

	    for (int i = 0; i < philosophersNumber; i++) {
	    	
	    	Fork leftfork = forks[i];
	    	Fork rightfork = forks[(i+1)% philosophersNumber];
	    	
	        if (i == philosophers.length - 1) {
                
                // The last philosopher picks up the right fork first
                philosophers[i] = new philosopher(i,rightfork, leftfork); 
            } else {
                philosophers[i] = new philosopher(i,leftfork, rightfork);
            }
             
	    		
	    	Thread t = new Thread( philosophers[i],"Philosopher "+ (i+1));
	    	t.start();
    	

	    }

//	    while (true) {
//	      try {
//	        
//	        Thread.sleep(500);
//
//	        // check for deadlock
//	        boolean deadlock = true;
//	        for (Fork f : forks) {
//	          if (f.isUsed()==false) {
//	            deadlock = false;
//	            break;
//	          }
//	        }
//	        if (deadlock) {
//	          Thread.sleep(500);
//	          System.out.println("Deadlock!");
//	          break;
//	        }
//	      }
//	      catch (Exception e) {
//	        e.printStackTrace(System.out);
//	      }
//	    }
//	    System.exit(0);
	  }
}
