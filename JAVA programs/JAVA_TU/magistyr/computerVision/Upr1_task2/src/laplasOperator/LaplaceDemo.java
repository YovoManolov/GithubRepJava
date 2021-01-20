package laplasOperator;

import org.opencv.core.Core;

public class LaplaceDemo {
    public static void main(String[] args) {
        // Load the native library.
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new LaplaceDemoRun().run(args);
    }
}
