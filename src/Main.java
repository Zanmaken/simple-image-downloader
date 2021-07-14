import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://pl.wikipedia.org/wiki/World_Trade_Center_(1973%E2%80%932001)");
        URLReader urlReader = new URLReader(url);
        System.out.println(urlReader);
    }
}
