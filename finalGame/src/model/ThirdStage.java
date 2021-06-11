package model;

import processing.core.PApplet;
import processing.core.PImage;
import view.Main;

public class ThirdStage extends stages
{
	PApplet app;
	PImage background;
	PImage floor, smallGap, smallGapWater, longGap, platform, gaping;

	public ThirdStage(PApplet app) 
	{
		background = app.loadImage("stageTwoBack.png");
		
		floor = app.loadImage("floor.gif");
		smallGap = app.loadImage("smallGap.gif");
		smallGapWater = app.loadImage("water.gif");
		longGap = app.loadImage("longGap.gif");
		platform = app.loadImage("platform.gif");
		gaping = app.loadImage("gapAndBig.png");
	}

	@Override
	public void loadStage(PApplet app) 
	{
		app.image(background, 0, 0);
		
		if(Player.posY < 0)
		{
			switch(Main.subStageNum)
			{
			case 1:
				Main.subStageNum = 2;
				Player.posY = 498;
				break;
			}
		}
		
		if(Player.posY > 500)
		{
			switch(Main.subStageNum)
			{
			case 2:
				Main.subStageNum = 1;
				Player.posY = 2;
				break;
			}
		}
		
		if(Player.posX > 817)
		{
			switch(Main.subStageNum)
			{
			case 0:
				Main.subStageNum = 1;
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
				Main.subStageNum = 7;
				Player.posX = 0;
				break;
			case 7:
				Main.stageNum = 4;
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
			case 7:
				Main.subStageNum = 6;
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
			app.image(longGap, 0, -100);
			
			app.imageMode(app.CENTER);
			platform.resize(0, 250);
			app.image(platform, 371, 366);
			app.image(platform, 571, 266);
			app.image(platform, 771, 166);
			
			app.textAlign(app.CENTER);
			app.fill(0);
			app.text("go up!", 689, 100);
			break;
			
		case 2:
			app.imageMode(app.CENTER);
			platform.resize(0, 250);
			app.image(platform, 771, 530);
			app.image(platform, 801, 530);
			app.image(platform, 841, 530);
			app.image(platform, 881, 530);
			break;
			
		case 3:
			app.imageMode(app.CENTER);
			platform.resize(0, 250);
			app.image(platform, 10, 530);
			app.image(platform, 50, 530);
			app.image(platform, 90, 530);
			app.image(platform, 130, 530);
			app.image(platform, 170, 530);
			
			app.image(platform, 270, 430);
			app.image(platform, 310, 430);
			app.image(platform, 350, 430);
			app.image(platform, 390, 430);
			app.image(platform, 430, 430);
			
			app.image(platform, 520, 330);
			app.image(platform, 560, 330);
			app.image(platform, 600, 330);
			app.image(platform, 640, 330);
			app.image(platform, 680, 330);
			app.image(platform, 720, 330);
			app.image(platform, 760, 330);
			app.image(platform, 800, 330);
			app.image(platform, 840, 330);
			app.image(platform, 880, 330);
			break;
			
		case 4:
			app.image(smallGap, 0, -100);
			break;
		
		case 5:
			app.image(longGap, 0, -100);
			
			app.imageMode(app.CENTER);
			platform.resize(0, 250);
			app.image(platform, 371, 366);
			app.image(platform, 571, 266);
			app.image(platform, 771, 166);
			break;
			
		case 6:
			app.image(smallGapWater, 0, -100);
			break;
		
		case 7:
			app.image(gaping, 0, -100);
			break;
		}
		
	}

}
