package momentsDemo;

import org.opencv.core.Core;

public class MomentsDemo {

	public static void main(String[] args) {
		// Load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MomentsClass(args);
            }
        });
	}

}
