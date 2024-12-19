import RMI.ByteService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex_RMI_6 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ByteService byteService = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");

        byte[] s = byteService.requestData("B21DCVT246", "rxWs7MkY");

        List<Byte> list = new ArrayList<>();
        System.out.println(Arrays.toString(s));
        for (byte b : s) {
            if (b % 2 == 0) {
                list.add(b);
            }
        }
        for (Byte b : s) {
            if (b % 2 != 0) {
                list.add(b);
            }
        }
        byte[] res = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        System.out.println(list);
        byteService.submitData("B21DCVT246", "rxWs7MkY", res);
    }
}
