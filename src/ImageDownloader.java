import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ImageDownloader {
    private ImageFinder imageFinder;
    private ArrayList<String> imgList;
    private ArrayList<byte[]> responseList;

    public ImageDownloader(ImageFinder imageFinder) {
        this.imageFinder = imageFinder;
        imgList = this.imageFinder.getImgList();
        responseList = new ArrayList<>();
        for (String str : imgList) {
            try {
                InputStream inputStream = new BufferedInputStream(new URL(str).openStream());
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int n = 0;
                while(-1 != (n = inputStream.read(buffer))){
                    outputStream.write(buffer, 0, n);
                }
                inputStream.close();
                outputStream.close();
                byte[] response = outputStream.toByteArray();
                responseList.add(response);

                FileOutputStream fileOutputStream = new FileOutputStream(response.length + str.substring(str.length() - 4));
                fileOutputStream.write(outputStream.toByteArray());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
