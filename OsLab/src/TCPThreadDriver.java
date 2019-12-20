
/**
 *
 * @author JackSparrow
 */
public class TCPThreadDriver {
    public static void main(String[] args){
        TCPclient c = new TCPclient();
        c.start();
        
        try{
            c.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
