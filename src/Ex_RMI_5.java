import RMI.BookX;
import RMI.ObjectService;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

public class Ex_RMI_5 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ObjectService objectService = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");

        BookX bookX = (BookX) objectService.requestObject("B21DCVT246", "6MnIM1UW");

        String s1 = String.valueOf((bookX.getAuthor().charAt(0)) + "" + bookX.getAuthor().charAt(bookX.getAuthor().length() - 1));
        String s2 = String.valueOf(bookX.getYearPublished() % 100);
        String s3 = String.valueOf(bookX.getGenre().length());
        String s4 = String.valueOf(bookX.getTitle().length() % 10);

        bookX.setCode(s1 + s2 + s3 + s4);

        objectService.submitObject("B21DCVT246", "6MnIM1UW", bookX);
    }
}

