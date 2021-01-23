package templateMatching;
import org.opencv.core.Core;

public class MatchTemplateDemo {
	public static void main(String[] args) {
       
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new MatchTemplateDemoRun().run(args);
    }
}
