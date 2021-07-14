import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageFinder {
    private String sourceText;
    private ArrayList<String> imgList;

    public ImageFinder(URLReader urlReader) {
        sourceText = urlReader.toString();
        imgList = new ArrayList<>();
        Pattern pattern = Pattern.compile("<img src=\"(.*?)\"");

        Matcher matcher = pattern.matcher(sourceText);

        while(matcher.find()){
            imgList.add(matcher.group(1));
        }

        System.out.println(imgList);
    }

    public ArrayList<String> getImgList() {
        return imgList;
    }

    @Override
    public String toString() {
        return imgList.toString();
    }
}
