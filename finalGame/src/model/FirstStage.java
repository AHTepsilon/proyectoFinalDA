package model;

import processing.core.PApplet;
import processing.core.PImage;
import view.Main;

public class FirstStage extends stages
{
	PApplet app;
	PImage background, floor, smallGap, smallGapWater;

	public FirstStage(PApplet app) 
	{
		background = app.loadImage("land.jpg");
		floor = app.loadImage("floor.gif");
		smallGap = app.loadImage("smallGap.gif");
		smallGapWater = app.loadImage("water.gif");
		
	}

	@Override
	public void loadStage(PApplet app) 
	{
		app.image(background, Main.landscapeX, -1300);
		app.image(floor, Main.landscapeX, -100);
		app.image(smallGap, Main.landscapeX + 800, -100);
		app.image(smallGapWater, Main.landscapeX + 800 + 800, -100);
		
	}

}
