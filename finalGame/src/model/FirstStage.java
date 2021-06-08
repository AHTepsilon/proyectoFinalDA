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
		background = app.loadImage("stageOneBack.png");
		floor = app.loadImage("floor.gif");
		smallGap = app.loadImage("smallGap.gif");
		smallGapWater = app.loadImage("water.gif");
		
	}

	@Override
	public void loadStage(PApplet app) 
	{
		app.image(background, 0, 0);
		System.out.println(Main.subStageNum);
		System.out.println(Player.posX);
		
		if(Player.posX > 817)
		{
			switch(Main.subStageNum)
			{
			case 0:
				Main.subStageNum = 1;
				Player.posX = 0;
				break;
			case 1:
				Main.subStageNum = 2;
				Player.posX = 0;
				break;
			}
		}
		
		if(Player.posX < -10)
		{
			switch(Main.subStageNum)
			{
			case 0:
				Player.posX = -9;
				break;
			case 1:
				Main.subStageNum = 0;
				Player.posX = 790;
				break;
			case 2:
				Main.subStageNum = 1;
				Player.posX = 790;
				break;
			}
		}
	
		switch(Main.subStageNum)
		{
		case 0:
			app.image(floor, 0, -100);
			break;
		case 1:
			app.image(smallGap, 0, -100);
			break;
		case 2:
			app.image(smallGapWater, 0, -100);
			break;
		}
		
	}
	
	public void switchSubStage()
	{

	}

}
