
package DiningPhiosopher;

/**
 *
 * @author JackSparrow
 */
public class philosopher extends Thread {

    public int number;
    public Fork leftFork;
    public Fork rightFork;

    philosopher(int num, Fork left, Fork right) {
      number = num;
      leftFork = left;
      rightFork = right;
    }

    public void run()
    {
    	think();
    	eat();
    } 	 	
    
   
   
    void think()
    {
    		System.out.println("Philosopher philo"+number+ " thinking...");
    		Log.Delay(500);
    }
    
    public void take_fork()
    {
    	leftFork.getFork(); System.out.println("Philosopher philo"+number+ ": take left fork");
    	rightFork.getFork(); System.out.println("Philosopher philo"+number+ ": take right fork");
    				
    }
    public void put_fork()
    {
    	leftFork.putFork(); System.out.println("Philosopher philo"+number+ ": put left fork");
    	rightFork.putFork();System.out.println("Philosopher philo"+number+ ": put right fork");
    }

    public void eat()
	{
		if(!leftFork.isUsed())
		{
			if(!rightFork.isUsed())
			{
				take_fork();
				System.out.println("Philosopher philo"+number+ " eating...");
				Log.Delay(500);
				
				put_fork();
			}
		}
	}
    

  }
class Log{

		public static void msg(String msg){
			System.out.println(msg);
		}
		public static void Delay(int ms){
			try{
				Thread.sleep(ms);
			}
			catch(InterruptedException ex){ }
		}
	}

