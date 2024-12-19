import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider;

public class WS_C {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("203.162.10.109/JNPWS/CharacterService?wsdl");
        QName qName = new QName("203.162.10.109", "CharacterService");
    }
}
