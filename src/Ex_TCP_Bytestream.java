import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Ex_TCP_Bytestream {
    public static void main(String[] args) throws IOException {
        // Khong được write new line, phai doc = mang array
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        output.write("B21DCVT246;6zQ52g54".getBytes());
        output.flush();

        byte[] buffer = new byte[1024];
        int l = input.read(buffer);
        String[] sp = new String(buffer, 0, l).split(",");

        List<Pair> list = new ArrayList<>();
        int index = 0;
        for (var i : sp) list.add(new Pair(Integer.parseInt(i), index++));

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.getX(), o2.getX());
            }
        });

        String res = list.get(list.size() - 2).getX() + "," + list.get(list.size() - 2).getY();
        System.out.println(res);
        output.write(res.getBytes());

        input.close();
        output.close();
        socket.close();

}
}

class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
