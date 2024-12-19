import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class TCP_DataStream {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream  = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF("B21DCVT246;kjUOyOUL");
        dataOutputStream.flush();

        int n = dataInputStream.readInt();
        System.out.println(n);
        int[] count = new int[10];
        for (int i =0 ; i < n; i++) {
            count[dataInputStream.readInt()]++;
        }
        for (int i = 1; i <= 6; i++) {
            dataOutputStream.writeFloat((float) count[i] / n);
            dataOutputStream.flush();
        }

        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
    }
}
