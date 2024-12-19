import java.io.IOException;
import java.net.*;

public class UDP_DataType {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        socket.send(new DatagramPacket(";B21DCVT246;Fqck68MM".getBytes(), ";B21DCVT246;Fqck68MM".getBytes().length, inetAddress, 2207));

        byte[] res = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(res, res.length);
        socket.receive(datagramPacket);
        String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        String[] s1 = s.split(";");
        System.out.println(s1[1]);
        System.out.println(s);
        int ans = 0;

        for (int i = 0; i < s1[1].length(); i++) {
            ans += Integer.parseInt(s1[1].substring(i, i + 1));
        }
        System.out.println(ans);
        String ss = String.format("%s;%s", s1[0], ans);
        socket.send(new DatagramPacket(ss.getBytes(), ss.getBytes().length, inetAddress, 2207));
    }
}
