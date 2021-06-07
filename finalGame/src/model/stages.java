package model;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class stages 
{
	static public int landscapeX;
	PImage tilemap;
	PApplet app;
	
	public stages() 
	{
		
	}
	
	public abstract void loadStage(PApplet app);

}
