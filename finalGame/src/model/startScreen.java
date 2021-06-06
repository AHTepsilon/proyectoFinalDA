package model;

import processing.core.PApplet;

public class startScreen extends stages
{
	PApplet app;

	public startScreen() 
	{
		
	}

	@Override
	public void loadStage(PApplet app) 
	{
		app.fill(0);
		app.rect(0, 0, 800, 500);
	}

}
