import RMI.ByteService;
import RMI.CharacterService;
import RMI.DataService;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;

public class Ex_RMI_3 {
    public static void main(String[] args) throws IOException, NotBoundException, ClassNotFoundException {
        DataService dataService = (DataService)
                Naming.lookup("rmi://203.162.10.109/RMIDataService");

        String qCode = "UEpOdCRX";
        String msv = "B21DCVT246";

        String s = (String) dataService.requestData(msv, qCode);

        System.out.println(s);

        String[] input = s.split(";");

        List<Integer> list = new ArrayList<>();

        String[] nums = input[0].split(",");


        for (String num : nums) {
            list.add(Integer.parseInt(num.trim()));
        }


        int k = Integer.parseInt(input[1].trim());

        var res = process(list, k);

        System.out.println(res);

        dataService.submitData(msv, qCode, res);
    }

    private static List<List<Integer>> process(List<Integer> list, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Integer> integerList = new ArrayList<Integer>();
                integerList.add(list.get(i));
                if (j + k  - 1 <= list.size()) {
                    for (int f = j; f < j + k - 1; f++) {
                        integerList.add(list.get(f));
                    }
                    ans.add(integerList);
                }
            }
        }
        return ans;
    }
}
