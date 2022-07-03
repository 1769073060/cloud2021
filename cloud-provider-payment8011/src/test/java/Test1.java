import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws IOException {
        ValidateUtil validateUtil  = new ValidateUtil();
        BufferedImage bufferedImage = validateUtil.creatImage();
        File outputfile  = new File("D:\\ASUS\\slide1.png");
        ImageIO.write(bufferedImage,"png",outputfile);
    }
    static BufferedImage getImageFromFile(String path){
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }


}
