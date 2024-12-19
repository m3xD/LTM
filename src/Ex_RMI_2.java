import RMI.ByteService;
import RMI.CharacterService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class Ex_RMI_2 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ByteService byteService = (ByteService)
                Naming.lookup("rmi://203.162.10.109/RMIByteService");

        String qCode = "aRuACFHw";
        String msv = "B21DCVT246";

        byte[] req = byteService.requestData(msv, qCode);

        System.out.println(Arrays.toString(req));

        byte[] res = process(req);

        System.out.println(Arrays.toString(res));

        byteService.submitData(msv, qCode, res);
    }

    private static byte[] process(byte[] b) {
       byte[] res = new byte[b.length * 2];
       byte cur = b[0];
       int c = 0;
       int index = 0;
       for (int i = 0; i < b.length; i++) {
           if (b[i] == cur) {
               c++;
           } else {
               res[index] = cur;
               res[index + 1] = (byte) (c);
               index += 2;
               cur = b[i];
               c = 1;
           }
       }
       res[index] = cur;
       res[index + 1] = (byte) (c);
       index += 2;
       byte[] finalAns = Arrays.copyOfRange(res, 0, index);
       return finalAns;
    }
}
