package Socket;



/**
 *
 * @author JackSparrow
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPserver {
    public static void main(String[] args) throws SocketException {


            DatagramSocket socket = new DatagramSocket(8877);

            while (true){
                try {
                byte buf1[] = new byte[3000];
                DatagramPacket packet1 = new DatagramPacket(buf1, buf1.length);
                socket.receive(packet1);

                System.out.println("Client: "+UDPclient.data(buf1));

                InetAddress ip = packet1.getAddress();
                int port = packet1.getPort();
                byte[] buff = null;
                Scanner input = new Scanner(System.in);
                String msg2 = input.nextLine();
                buff = msg2.getBytes();
                DatagramPacket packet2 = new DatagramPacket(buff, buff.length, ip, port);

                socket.send(packet2);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }


    }

}