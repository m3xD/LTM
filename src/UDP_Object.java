import UDP.Customer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class UDP_Object {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        String req = String.format(";%s;%s", "B21DCVT246", "onkRwITN");
        socket.send(new DatagramPacket(req.getBytes(), req.getBytes().length, inetAddress, 2209));

        byte[] res = new byte[1024];
        DatagramPacket packet = new DatagramPacket(res, res.length);
        socket.receive(packet);

        String rqID = new String(packet.getData(), 0, 8);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData(), 8, packet.getLength()));

        Customer customer = (Customer) objectInputStream.readObject();
    }
}
