package Socket;


/**
 *
 * @author JackSparrow
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class UDPclient {

    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = new DatagramSocket();

        while(true){
            try {

                byte buf1[] = null;

                Scanner input = new Scanner(System.in);
                String msg = input.nextLine();
                buf1 = msg.getBytes();

                DatagramPacket packet = new DatagramPacket(buf1, buf1.length, InetAddress.getLocalHost(),8877);
                socket.send(packet);

                byte buf2[] = new byte[3000];
                DatagramPacket packet2 = new DatagramPacket(buf2,buf2.length);
                socket.receive(packet2);

                System.out.println("Server: "+ data(buf2));

            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static StringBuilder data(byte[] a){
        if(a == null)
            return  null;
        StringBuilder msg = new StringBuilder();
        int i=0;
        while(a[i] != 0)
        {
            msg.append( (char)a[i]);
            i++;
        }
        return msg;
    }
}
