package kgr.shaders;

import kgr.final_exam.Light;

public class StaticShader extends ShaderProgram  {
	
	private static final String VERTEX_FILE = "src/shaders/vetex.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";

	private int locationOfLightPosition;
	private int locationOfLightColour;

	
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
		super.bindAttribute(2, "normal");

		
	}
	
	protected void getAllUniformLocations() {
		locationOfLightPosition = super.getUniformLocation("lightPosition");
		locationOfLightColour = super.getUniformLocation("lightColour");
	}
	
	public void loadLight(Light light) {
		super.loadVector(locationOfLightPosition, light.getPosition());
		super.loadVector(locationOfLightColour, light.getColour());
	}


}
