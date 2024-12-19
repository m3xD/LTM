import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class TCP_Character {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", Integer.parseInt("2208"));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        out.write("B21DCVT246;BwFsHDXf");
        out.newLine();
        out.flush();


        String s1 = in.readLine();
        String s2 = in.readLine();

        System.out.println(s1);
        System.out.println(s2);

        Map<Character, Boolean> m = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            m.put(s2.charAt(i), true);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (!m.containsKey(s1.charAt(i))) {
                res.append(s1.charAt(i));
            }
        }

        System.out.println(res);

        out.write(res.toString());
        out.newLine();
        out.flush();



        in.close();
        out.close();
        socket.close();
    }
}
