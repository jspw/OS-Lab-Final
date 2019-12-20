package Socket;

import java.io.*;
import java.net.*;

/**
 *
 * @author JackSparrow
 */
public class TCPserver {
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = new ServerSocket(8877);
        Socket s ;
        while( (s = ss.accept()) != null){         
        
        BufferedReader br = new BufferedReader (new InputStreamReader(s.getInputStream()));
        String msg = br.readLine();
        System.out.println("Client :" + msg);
        
        BufferedReader brr = new BufferedReader (new InputStreamReader(System.in));
        String msg2 = brr.readLine();
        PrintWriter send = new PrintWriter(s.getOutputStream(),true);
        send.println(msg2);
        }
        
                
    }
    
}
