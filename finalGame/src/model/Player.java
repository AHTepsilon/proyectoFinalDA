package model;

import processing.core.PApplet;

public class Player 
{
	float posX, posY;
	float velocityX, velocityY;
	float speed;
	float jumpVel;
	double gravity;
	boolean onGround;
	
	int size;
	
	float upKey, leftKey, rightKey, downKey;
	
	PApplet app;	

	public Player() 
	{
		posX = 31;
		posY = 324;
		velocityX = 0;
		velocityY = 0;
		speed = 5;
		jumpVel = 5;
		gravity = 1.8;
		
		size = 25;
	}
	
	@SuppressWarnings("static-access")
	public void drawPlayer(PApplet app)
	{	
		app.rectMode(app.CENTER);
		app.fill(255, 0, 0);
		app.square(posX, posY, size);
	}
	
	public void movement(PApplet app)
	{
		velocityY += gravity;
		velocityX = (rightKey - leftKey) * speed;
		float nextY = posY + velocityY;
		float nextX = posX;		
		boolean onGroundTemp = false;
		
		posX += velocityX;
		posY += velocityY;
		onGround = onGroundTemp;
		
		if(velocityY > 0 && posY < (351-(size/2)))
			{
				velocityY = 0;
				onGroundTemp = true;
			}

	}
	
	public void collisions(PApplet app)
	{
		if(posY > (351-(size/2)))
			{
				posY = (350-(size/2));
			}
	}
	
	public void parallax(PApplet app)
	{
		if(posX > 669)
		{
			posX = 669;
		}
	}
	
	
	@SuppressWarnings("static-access")
	public void keyMovement(PApplet app) //goes in keyReleased
	{
		if(app.key == app.CODED)
		{
			if(app.keyCode == app.LEFT)
			{
				leftKey = 0;
			}
			
			if(app.keyCode == app.RIGHT)
			{
				rightKey = 0;
			}
			
			if(app.keyCode == app.DOWN)
			{
				downKey = 0;
			}
			
			if(app.keyCode == app.UP)
			{
				upKey = 0;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void keyPress(PApplet app) //goes in keyPressed
	{
		if(app.key == ' ' && onGround)
		{
			velocityY = jumpVel;
		}
		
		if(app.key == app.CODED)
		{
			if(app.keyCode == app.LEFT)
			{
				leftKey = 1;
			}
			
			if(app.keyCode == app.RIGHT)
			{
				rightKey = 1;
			}
			
			if(app.keyCode == app.UP)
			{
				upKey = 1;
				System.out.println("jumps");
				posY -= 200;
			}
			
			if(app.keyCode == app.DOWN)
			{
				downKey = 1;
			}
		}
	}
	
	

}
