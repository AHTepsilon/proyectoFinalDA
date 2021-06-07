package model;

import processing.core.PApplet;
import processing.core.PImage;

public class SecondStage extends stages
{
	PApplet app;
	PImage background;

	public SecondStage(PApplet app) 
	{
		background = app.loadImage("stageTwoBack.png");
	}

	@Override
	public void loadStage(PApplet app) 
	{
		app.image(background, 0, 0);
		
	}

}
