package model;

import processing.core.PApplet;
import view.Main;

public class Player extends Thread
{
	public static float posX, posY;
	float velocityX, velocityY;
	float speed;
	float jumpVel;
	double gravity;
	boolean onGround;
	
	int jumpable;
	
	int size;
	
	float upKey, leftKey, rightKey, downKey;
	
	PApplet app;	

	public Player() 
	{
		posX = 132;
		posY = 324;
		velocityX = 0;
		velocityY = 0;
		speed = 5;
		jumpVel = 5;
		gravity = 1.8;
		
		size = 25;
		
		jumpable = 1;
	}
	
	public void run()
	{
		jumpable *= -1;
		
		try {
			Player.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jumpable *= -1;
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
	
	public void obstacles()
	{
		
	}
	
	public void collisions(PApplet app)
	{
		//System.out.println(jumpable);
		
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 0)
			{
				posY = (350-(size/2));
			}
		
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 1 && posX < 359 || posX > 565)
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 2 && posX < 359 || posX > 565)
		{
			posY = (350-(size/2));
		}
	}
	
	public void parallax(PApplet app)
	{
		
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
				
				if(jumpable == 1)
				{
					posY -= 200;
				}
			}
			
			if(app.keyCode == app.DOWN)
			{
				downKey = 1;
			}
		}
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getJumpVel() {
		return jumpVel;
	}

	public void setJumpVel(float jumpVel) {
		this.jumpVel = jumpVel;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	
	
	

}
