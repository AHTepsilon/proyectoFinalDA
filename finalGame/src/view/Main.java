package view;
import controlP5.ControlP5;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet
{
	private ControlP5 cp5;

	public static void main(String[] args) 
	{
		PApplet.main("view.Main");
	}
	
	@Override
	public void settings() //void Awake
	{
		size(800, 500);
	}
	
	int characterX, characterY;
	static public int landscapeX;
	
	PImage background;
	
	Controller controls;
	
	@Override
	public void setup() //void Start
	{
		cp5 = new ControlP5(this);
		
		background = loadImage("land.jpg");
		landscapeX = 0;
		
		characterX = 31;
		characterY = 324;
		
		controls = new Controller();
	}
	
	@Override
	public void draw() //void Update
	{
		//System.out.println(mouseX + ", " + mouseY);
		System.out.println(landscapeX);
		image(background, landscapeX, -1300);
		fill(90);
		noStroke();
		rectMode(CORNER);
		rect(0, 352, 800, 400);
		
		controls.drawPlayer(this);
		controls.movement(this);
		controls.collision(this);
		controls.parallax(this);
		
		/*rectMode(CENTER);
		fill(255, 0, 0);
		square(characterX, characterY, 25);*/
	}
	
	public void gravity()
	{
		
	}
	
	public void move()
	{
		
	}
	
	public void keyReleased()
	{
		controls.keyMovement(this);
	}
	
	public void parallax()
	{
		
	}
	
	public void keyPressed()
	{
		controls.keyPress(this);
	}

}
