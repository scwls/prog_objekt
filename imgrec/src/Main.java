import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        {
            ImageProcessor processor = new ImageProcessor();
            processor.load("image.jpg");
            long start = System.currentTimeMillis();
            processor.addBrightnessThreaded(-100);
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            processor.save("image1.jpg");
        }
        {
            ImageProcessor processor = new ImageProcessor();
            processor.load("image.jpg");
            long start = System.currentTimeMillis();
            processor.addBrightness(-100);
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            processor.save("image1.jpg");
        }
    }
}