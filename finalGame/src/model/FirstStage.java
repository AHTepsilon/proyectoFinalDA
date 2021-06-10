package model;

import processing.core.PApplet;
import processing.core.PImage;
import view.Main;

public class FirstStage extends stages
{
	PApplet app;
	PImage background, floor, smallGap, smallGapWater, longGap, platform;

	public FirstStage(PApplet app) 
	{
		background = app.loadImage("stageThreeBack.png");
		floor = app.loadImage("floor.gif");
		smallGap = app.loadImage("smallGap.gif");
		smallGapWater = app.loadImage("water.gif");
		longGap = app.loadImage("longGap.gif");
		platform = app.loadImage("platform.gif");
	}

	@Override
	public void loadStage(PApplet app) 
	{
		app.image(background, 0, 0);
		
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
			case 2:
				Main.subStageNum = 3;
				Player.posX = 0;
				break;
			case 3:
				Main.subStageNum = 4;
				Player.posX = 0;
				break;
			case 4:
				Main.subStageNum = 5;
				Player.posX = 0;
				break;
			case 5:
				Main.subStageNum = 6;
				Player.posX = 0;
				break;
			case 6:
				Main.stageNum = 2;
				Main.subStageNum = 0;
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
			case 3:
				Main.subStageNum = 2;
				Player.posX = 790;
				break;
			case 4:
				Main.subStageNum = 3;
				Player.posX = 790;
				break;
			case 5:
				Main.subStageNum = 4;
				Player.posX = 790;
				break;
			case 6:
				Main.subStageNum = 5;
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
		case 3:
			app.image(longGap, 0, -100);
			
			app.imageMode(app.CENTER);
			platform.resize(0, 250);
			app.image(platform, 342, 376);
			app.image(platform, 542, 376);
			app.image(platform, 742, 376);
			break;
		case 4:
			app.image(smallGapWater, 0, -100);
			break;
		case 5:
			app.image(smallGap, 0, -100);
			break;
		case 6:
			app.image(floor, 0, -100);
			break;
		}
		
	}
	
	public void switchSubStage()
	{

	}

}
