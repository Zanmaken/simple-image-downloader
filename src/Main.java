import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://dank-svt-memes.tumblr.com/");
        URLReader urlReader = new URLReader(url);
        ImageFinder imageFinder = new ImageFinder(urlReader);
        ImageDownloader imageDownloader = new ImageDownloader(imageFinder);
    }
}
