package Socket;


import java.io.*;
import java.net.*;


/**
 *
 * @author JackSparrow
 */
public class TCPclient extends Thread {
    @Override
    public void run()
    {
        try{
        while(true){
            Socket s = new Socket("localhost",8877);
        
        BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
        String input= br.readLine();
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        out.println(input);
        
        BufferedReader brr = new BufferedReader (new InputStreamReader(s.getInputStream()));
        String msg = brr.readLine();
        System.out.println("Server: "+msg);
        }
        
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
