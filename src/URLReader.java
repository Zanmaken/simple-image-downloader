import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {
    URL url;
    URLConnection urlConnection;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;

    public URLReader(URL url){
        this.url = url;
        stringBuilder = new StringBuilder();

        try {
            urlConnection = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Website doesn't exist");
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
