package controller;

import model.FirstStage;
import model.Player;
import model.stages;
import model.startScreen;
import processing.core.PApplet;

public class Controller 
{
	Player player;
	startScreen screenOne;
	FirstStage stageOne;
	PApplet app;
	

	public Controller(PApplet app) 
	{
		player = new Player(app);
		screenOne = new startScreen(app);
		stageOne = new FirstStage(app);
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
	
	public void runPlayer()
	{
		player.start();
	}
	
	public void obstacles()
	{
		player.obstacles();
	}
	
	public void loadStage1(PApplet app)
	{
		screenOne.loadStage(app);
	}
	
	public void loadStage2(PApplet app)
	{
		stageOne.loadStage(app);
		stageOne.switchSubStage();
	}

}
