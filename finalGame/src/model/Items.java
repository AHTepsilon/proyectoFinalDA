package model;

import processing.core.PApplet;
import processing.core.PImage;
import view.Main;

public class Items 
{
	PApplet app;
	
	PImage cake, sushi, yarn, lasagna, item;
	int posX, posY;
	
	public Items(PApplet app, int posX, int posY) 
	{
		this.posX = posX;
		this.posY = posY;
		
		cake = app.loadImage("itemCake.png");
		sushi = app.loadImage("itemSushi.png");
		yarn = app.loadImage("itemYarnBall.png");
		lasagna = app.loadImage("itemLasagna.png");
	}
	
	public void paint(PApplet app)
	{
		switch(Player.randomCatValue)
		{
		case 0:
			item = cake;
			break;
		case 1:
			item = cake;
			break;
		case 2:
			item = yarn;
			break;
		case 3:
			item = sushi;
			break;
		case 4:
			item = lasagna;
			break;
		}
		
		this.posX = posX;
		this.posY = posY;
		
		app.image(item, posX, posY);
		item.resize(0, 75);
	}
	
	public void collect()
	{
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	

}
