import java.io.IOException;
import java.net.*;

public class UDP_String {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        String req = String.format(";%s;%s", "B21DCVT246", "2sOJXIlF");
        socket.send(new DatagramPacket(req.getBytes(), req.getBytes().length, inetAddress, 2208));

        byte[] res = new byte[1024];
        DatagramPacket packet = new DatagramPacket(res, res.length);
        socket.receive(packet);

        String[] s = new String(packet.getData(), 0, packet.getLength()).split(";");
        System.out.println(s[1]);

        StringBuilder ans = new StringBuilder();
        int[] count = new int[400];
        for (int i = 0; i < s[1].length(); i++) {
            count[s[1].charAt(i)]++;
            if (((s[1].charAt(i) >= 'a' && s[1].charAt(i) <= 'z') || (s[1].charAt(i) >= 'A' && s[1].charAt(i) <= 'Z')) && count[s[1].charAt(i)] == 1) {
                        ans.append(s[1].charAt(i));
            }
        }

        System.out.println(ans);
        String finalRes = s[0] + ";" + ans;
        socket.send(new DatagramPacket(finalRes.toString().getBytes(), finalRes.toString().getBytes().length, inetAddress, 2208));

        socket.close();
    }
}
