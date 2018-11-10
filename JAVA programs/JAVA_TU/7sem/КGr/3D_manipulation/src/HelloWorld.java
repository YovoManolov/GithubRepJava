
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class HelloWorld {
	
	private long               window;
	private final static short WIDTH = 1024;
	private final static short HEIGHT = 1024;
	
	private float rotateAngle = 1.0f;
	private float rotateX = 1.0f;
	private float rotateY = 1.0f;
	private float rotateZ = 1.0f;
	
	private float angleToRotate = 3.0f;
	boolean setStart = true;
	
	int flagA = 0;
	int flagX = 0;
	int flagY = 0;
	int flagZ = 0;
	
	protected GLFWKeyCallback  keyCallback;
	
	public void run(){
		try {
			InitGL();
			CreateWindow();
			Run();
			
			// Free the window callbacks and destroy the window
			glfwFreeCallbacks(window);
			glfwDestroyWindow(window);
		} finally {
			// Terminate GLFW and free the error callback
			glfwTerminate();
			glfwSetErrorCallback(null).free();
		}
	}
	
	private void InitGL() {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");

		// Configure our window
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
	}
	
	private void CreateWindow() {
		// Create the window.
		window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World!", NULL, NULL);
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");
		
		// Construct and bind the keyboard handler.
		glfwSetKeyCallback(window, keyCallback = new KeyboardHandler());

		// Get the resolution of the primary monitor.
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		
		// Center our window.
		glfwSetWindowPos(
			window,
			(vidmode.width() - WIDTH) / 2,
			(vidmode.height() - HEIGHT) / 2
		);

		// Make the OpenGL context current.
		glfwMakeContextCurrent(window);
		
		// Enable v-sync.
		glfwSwapInterval(1);

		// Make the window visible.
		glfwShowWindow(window);
	}
	
	public void update() {
		if (KeyboardHandler.isKeyDown(GLFW_KEY_ESCAPE)) {
			glfwSetWindowShouldClose(window, true); // We will detect this in our rendering loop
		}
		
		
		//rotate angle
		if(KeyboardHandler.isKeyDown(GLFW_KEY_F3)) {
			//glRotatef(angle,x,y,z);
			
			if(flagA == 0) {
					if(rotateAngle < 360) {
						rotateAngle += angleToRotate;
						glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
					}
					else if(rotateAngle >= 360) {
						flagA = 1;
					}
			}
				
			else if(flagA == 1){
				if(rotateAngle >= 1) {
					rotateAngle -= angleToRotate;
					glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
					
				}
				else if(rotateAngle < 1) {
					flagA = 0;
				}
		  }
		}
		
		//rotatef  X
		if(KeyboardHandler.isKeyDown(GLFW_KEY_F4)) {
		    
		    while (setStart) {
		    	while(rotateX > 1 ) rotateX --;
		    	while(rotateY > 0 ) rotateY --;
		    	while(rotateZ > 0 ) rotateZ --;
		    	setStart = false;
		    }

			if(flagX == 0) {
					if(rotateX < 360) {
						rotateX += angleToRotate;
						glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
					}
					else if(rotateX>= 360) {
						flagX = 1;
					}
			}
				
			else if(flagX == 1){
				if(rotateX >= 1) {
					rotateX -= angleToRotate;
					glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
					
				}
				else if(rotateX < 1) {
					flagX = 0;
				}
			}	
					
		}
			
		//rotatef  y
				if(KeyboardHandler.isKeyDown(GLFW_KEY_F5)) {
					//glRotatef(angle,x,y,z);
					    while (setStart) {
					    	while(rotateX > 0 ) rotateX --;
					    	while(rotateY > 1 ) rotateY --;
					    	while(rotateZ > 0 ) rotateZ --;
					    	setStart = false;
					    }
					
					if(flagY == 0) {
							if(rotateY < 360) {
								rotateY += angleToRotate;
								glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
							}
							else if(rotateY>= 360) {
								flagY = 1;
							}
					}
						
					else if(flagY == 1){
						if(rotateY >= 1) {
							rotateY -= angleToRotate;
							glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
							
						}
						else if(rotateY < 1) {
							flagY = 0;
						}
					}	
							
				}
				
				
				if(KeyboardHandler.isKeyDown(GLFW_KEY_F6)) {
					//glRotatef(angle,x,y,z);
					   while (setStart) {
					    	while(rotateX > 0 ) rotateX --;
					    	while(rotateY > 0 ) rotateY --;
					    	while(rotateZ > 1 ) rotateZ --;
					    	setStart = false;
					    }
					if(flagZ == 0) {
							if(rotateZ < 360) {
								rotateZ += angleToRotate;
								glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
							}
							else if(rotateZ>= 360) {
								flagZ = 1;
							}
					}
						
					else if(flagZ == 1){
						if(rotateZ >= 1) {
							rotateZ -= angleToRotate;
							glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
							
						}
						else if(rotateZ < 1) {
							flagZ = 0;
						}
					}	
							
				}	
			
    }
	
	private void Run() {
		GL.createCapabilities();

		while ( !glfwWindowShouldClose(window) ) {
		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);
		glLoadIdentity();

		GL11.glRotatef(rotateAngle,rotateX,rotateY,rotateZ);
		glColor3f(0.5f,0.5f,1.0f);
		
		glBegin(GL_QUADS);
		
			GL11.glColor3f(0.5f,0.5f,0.0f);
			GL11.glVertex3f(0.5f,0.5f,-0.5f);
			GL11.glVertex3f(-0.5f,0.5f,-0.5f);
			GL11.glVertex3f(-0.5f,0.5f,0.5f);
			GL11.glVertex3f(0.5f,0.5f,0.5f);
			
			GL11.glColor3f(0.5f,0.5f,0.0f);
			GL11.glVertex3f(0.5f,-0.5f,0.5f);
			GL11.glVertex3f(-0.5f,-0.5f,0.5f);
			GL11.glVertex3f(-0.5f,-0.5f,-0.5f);
			GL11.glVertex3f(0.5f,-0.5f,-0.5f);
			
			GL11.glColor3f(0.5f,0.0f,0.0f);
			GL11.glVertex3f(0.5f,0.5f,0.5f);
			GL11.glVertex3f(-0.5f,0.5f,0.5f);
			GL11.glVertex3f(-0.5f,-0.5f,0.5f);
			GL11.glVertex3f(0.5f,-0.5f,0.5f);
			
			GL11.glColor3f(0.5f,0.5f,0.0f);
			GL11.glVertex3f(0.5f,-0.5f,-0.5f);
			GL11.glVertex3f(-0.5f,-0.5f,-0.5f);
			GL11.glVertex3f(-0.5f,0.5f,-0.5f);
			GL11.glVertex3f(0.5f,0.5f,-0.5f);
			
			GL11.glColor3f(0.0f,0.0f,0.5f);
			GL11.glVertex3f(-0.5f,0.5f,0.5f);
			GL11.glVertex3f(-0.5f,0.5f,-0.5f);
			GL11.glVertex3f(-0.5f,-0.5f,-0.5f);
			GL11.glVertex3f(-0.5f,-0.5f,0.5f);
			
			GL11.glColor3f(0.5f,0.0f,0.5f);
			GL11.glVertex3f(0.5f,0.5f,-0.5f);
			GL11.glVertex3f(0.5f,0.5f,0.5f);
			GL11.glVertex3f(0.5f,-0.5f,0.5f);
			GL11.glVertex3f(0.5f,-0.5f,-0.5f);
		
		glEnd();
		
		glfwSwapBuffers(window); // swap the color buffers

		glfwPollEvents();
		update();	
			
			// Poll for window events. The key callback above will only be
			// invoked during this call.
		}
	}

	public static void main(String[] args) {
		new HelloWorld().run();
	}

}