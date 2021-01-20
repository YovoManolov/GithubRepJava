package threshold;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Threshold {
	private static int MAX_VALUE = 255;
	private static int MAX_TYPE = 4;
	private static int MAX_BINARY_VALUE = 255;
	private static final String WINDOW_NAME = "Threshold Demo";
	private static final String TRACKBAR_TYPE = "<html><body>Type: <br> 0: Binary <br> "
			+ "1: Binary Inverted <br> 2: Truncate <br> " + "3: To Zero <br> 4: To Zero Inverted</body></html>";
	private static final String TRACKBAR_VALUE = "Value";
	
	private static final int MAX_LOW_THRESHOLD = 100;
	private static final int RATIO = 3;
	private static final int KERNEL_SIZE = 3;
	private static final Size BLUR_SIZE = new Size(3, 3);
	
	private int thresholdValue = 0;
	private int thresholdType = 3;
	
	private int lowThresh = 0;
	
	private Mat src;
	
	private Mat srcBlur = new Mat();
	private Mat detectedEdges = new Mat();
	
	private Mat srcGray = new Mat();
	private Mat dst = new Mat();
	private JFrame frame;
	private JLabel imgLabel;
	private Image img;

	public Threshold() {
		
		String imagePath = "resources\\lena.jpg";
		src = Imgcodecs.imread(imagePath);
		
		if (src.empty()) {
			System.out.println("Empty image: " + imagePath);
			System.exit(0);
		}
		
		// Convert the image to Gray
		Imgproc.cvtColor(src, srcGray, Imgproc.COLOR_BGR2GRAY);
		// Create and set up the window.
		frame = new JFrame(WINDOW_NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set up the content pane.
		Image img = HighGui.toBufferedImage(srcGray);
		addComponentsToPane(frame.getContentPane(), img);
		// Use the content pane's default BorderLayout. No need for
		// setLayout(new BorderLayout());
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	private void addComponentsToPane(Container pane, Image img) {
		
		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}
		
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.PAGE_AXIS));
		
		sliderPanel.add(new JLabel(TRACKBAR_TYPE));
		JSlider sliderThreshType = new JSlider(0, MAX_TYPE, thresholdType);
		sliderThreshType.setMajorTickSpacing(1);
		sliderThreshType.setMinorTickSpacing(1);
		sliderThreshType.setPaintTicks(true);
		sliderThreshType.setPaintLabels(true);
		sliderPanel.add(sliderThreshType);
		sliderPanel.add(new JLabel(TRACKBAR_VALUE));
		
		JSlider sliderThreshValue = new JSlider(0, MAX_VALUE, 0);
		sliderThreshValue.setMajorTickSpacing(50);
		sliderThreshValue.setMinorTickSpacing(10);
		sliderThreshValue.setPaintTicks(true);
		sliderThreshValue.setPaintLabels(true);
		sliderPanel.add(sliderThreshValue);
		
		sliderThreshType.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				thresholdType = source.getValue();
				update();
			}
		});
		
		sliderThreshValue.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				thresholdValue = source.getValue();
				update();
			}
		});

		sliderPanel.add(new JLabel("Min Threshold:"));
		JSlider slider = new JSlider(0, MAX_LOW_THRESHOLD, 0);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				lowThresh = source.getValue();
				update();
			}
		});
		sliderPanel.add(slider);
		
		
		pane.add(sliderPanel, BorderLayout.PAGE_START);
		imgLabel = new JLabel(new ImageIcon(img));
		pane.add(imgLabel, BorderLayout.CENTER);
	}

	private void update() {
		Imgproc.threshold(srcGray, dst, thresholdValue, MAX_BINARY_VALUE, thresholdType);
        HighGui.toBufferedImage(dst);
		update1(dst);
	}
	
	private void update1(Mat src) {

		Imgproc.blur(src, srcBlur, BLUR_SIZE);
		Imgproc.Canny(srcBlur, detectedEdges, lowThresh, lowThresh * RATIO, KERNEL_SIZE, false);
		dst = new Mat(src.size(), CvType.CV_8UC3, Scalar.all(0));
		src.copyTo(dst, detectedEdges);
		img = HighGui.toBufferedImage(dst);
		imgLabel.setIcon(new ImageIcon(img));
		frame.repaint();
	}

	public static void main(String[] args) {
		// Load the native OpenCV library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Threshold();
			}
		});
	}
}