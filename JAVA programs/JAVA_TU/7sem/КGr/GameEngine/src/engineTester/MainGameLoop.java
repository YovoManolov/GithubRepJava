package engineTester;

import org.lwjgl.opengl.Display;

import models.RawModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Render;
import shaders.StaticShader;

public class MainGameLoop {
	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader=new Loader();
		Render render=new Render();
		StaticShader shader = new StaticShader();

		float[] vertices = {
				/*-0.5f,  0.5f, 0, //V0
				-0.5f, -0.5f, 0, //V1
				 0.5f, -0.5f, 0, //V2
				 0.5f,  0.5f, 0  //V3
*/				 
				//1 триъгълник
					-0.5f, 0.5f, 0f,
					-0.5f, -0.5f, 0f,
					0.5f, -0.5f, 0f,
				//2 триъгълник
					0.5f, -0.5f, 0f,
					0.5f,0.5f,0f,
					-0.5f,0.5f,0f

		};
		int[] indices= {
			0,1,3,
			3,1,2
		};
		RawModel model = loader.loadToVAO(vertices, indices);
		
		while(!Display.isCloseRequested()) {
			render.prepare();
			shader.start();
			
			// game logic
			render.render(model);
			shader.stop();
			DisplayManager.updateDisplay();

		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
