package model;

import processing.core.PApplet;
import processing.core.PImage;

public class ThirdStage extends stages
{
	PApplet app;
	PImage background;

	public ThirdStage(PApplet app) 
	{
		background = app.loadImage("stageTwoBack.png");
	}

	@Override
	public void loadStage(PApplet app) 
	{
		app.image(background, 0, 0);
		
	}

}
