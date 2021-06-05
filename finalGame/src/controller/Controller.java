package controller;

import model.Player;
import processing.core.PApplet;

public class Controller 
{
	Player player;
	
	PApplet app;

	public Controller() 
	{
		player = new Player();
	}
	
	public void drawPlayer(PApplet app)
	{
		player.drawPlayer(app);
	}
	
	public void movement(PApplet app)
	{
		player.movement(app);
	}
	
	public void collision(PApplet app)
	{
		player.collisions(app);
	}
	
	public void parallax(PApplet app)
	{
		player.parallax(app);
	}
	
	public void keyMovement(PApplet app)
	{
		player.keyMovement(app);
	}
	
	public void keyPress(PApplet app)
	{
		player.keyPress(app);
	}

}
