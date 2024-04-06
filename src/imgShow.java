import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;

public class imgShow extends JFrame {
    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    System.out.println("Version: " + Core.VERSION);}

    public static void main(String[] args) {
        JFrame window = new JFrame();
        JLabel screen = new JLabel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Mat img = Imgcodecs.imread("src/fireOnBox.jpg");

        Mat imgEmpty = new Mat(img.size(), img.type());

        Mat kernel = new Mat(5, 5, CvType.CV_8UC1, new Scalar(1.0));

//        Imgproc.dilate(img, imgEmpty, kernel);
//        Imgproc.erode(img, imgEmpty, kernel);
//        Imgproc.cvtColor(img, imgEmpty, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.GaussianBlur(img, imgEmpty, new Size(15, 15), 0);
//        Imgproc.Canny(img, imgEmpty, 2, 2);

        Imgcodecs.imwrite("src\\saveImg.png", img);

        Mat imgCrop = img.rowRange(100, 250);

        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(".jpg", imgEmpty, buf);

        ImageIcon ic = new ImageIcon(buf.toArray());

        screen.setIcon(ic);
        window.getContentPane().add(screen);
        window.pack();
    }
}
