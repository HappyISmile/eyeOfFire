import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

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

        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(".jpg", img, buf);

        ImageIcon ic = new ImageIcon(buf.toArray());

        screen.setIcon(ic);
        window.getContentPane().add(screen);
        window.pack();
    }
}
