package model;

import processing.core.PApplet;
import processing.core.PImage;
import view.Main;

public class startScreen
{
	PApplet app;
	PImage background;

	public startScreen(PApplet app) 
	{
		background = app.loadImage("land.jpg");
	}

	public void loadStage(PApplet app) 
	{
		app.image(background, Main.landscapeX, -1300);
		app.fill(0);
		app.rect(0, 0, 800, 500);
	}
	
	public void stageLoader(PApplet app)
	{
		
	}

}
