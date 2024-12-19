import RMI.CharacterService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Ex_RMI_1 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        CharacterService characterService = (CharacterService)
                Naming.lookup("rmi://203.162.10.109/RMICharacterService");

        String qCode = "Ld7MinUC";
        String msv = "B21DCVT246";

        String req = characterService.requestCharacter(msv, qCode);

        System.out.println(req);
        String res = process(req);
        characterService.submitCharacter(msv, qCode, res);
        System.out.println(res);
    }

    private static String process(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("+");
            } else if (!Character.isLetter(c) && !Character.isDigit(c) && c != '*') {
                sb.append("%" + (Integer.toHexString(c)).toUpperCase());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
