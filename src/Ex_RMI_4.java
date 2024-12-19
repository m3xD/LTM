import RMI.CharacterService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Ex_RMI_4 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        CharacterService characterService = (CharacterService)
                Naming.lookup("rmi://203.162.10.109/RMICharacterService");

        String qCode = "s8EyxLSU";
        String msv = "B21DCVT246";

        String req = characterService.requestCharacter(msv, qCode);

        System.out.println(req);
        String res = process(req);
        characterService.submitCharacter(msv, qCode, res);
        System.out.println(res);
    }

    private static String process(String s) {
        StringBuilder sb = new StringBuilder();
        int d = s.length() % 7;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c = (char) (c - 'a');
            if (c - d < 0) {
                sb.append((char) ((26 - Math.abs(c - d)) + 'a'));
            } else {
                sb.append((char) ((c - d) % 26 + 'a'));
            }
        }
        return sb.toString();
    }
}
