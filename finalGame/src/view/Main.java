package view;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import controlP5.ControlP5;
import controller.Controller;
import model.Items;
import model.Player;
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
	
	public static Mixer mixer;
	public static Clip clip, clip2;
	
	int characterX, characterY;
	static public int landscapeX;
	static public int stageNum, subStageNum;
	
	static public boolean gameOver;
	
	PImage gameOverScreen, startScreen, instScreen;
	
	boolean isScreenInst;
	
	int score;
	
	ArrayList<Items> itemList;
	
	//PImage background;
	
	Controller controls;
	
	@Override
	public void setup() //void Start
	{
		cp5 = new ControlP5(this);
		
		//background = loadImage("land.jpg");
		landscapeX = 0;
		stageNum = -1;
		subStageNum = 0;
		score = 0;
		
		characterX = 31;
		characterY = 324;
		
		gameOverScreen = loadImage("stageThreeBack.png");
		startScreen = loadImage("startScreen.png");
		instScreen = loadImage("inst.png");
		
		itemList = new ArrayList<Items>();
		
		for(int i = 0; i <= 90; i++)
		{
			itemList.add(new Items(this));
		}
		
		Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
		
		/*for(Mixer.Info info : mixerInfo)
		{
			System.out.println(info.getName() + "-------" + info.getDescription());
		}*/
		
		mixer = AudioSystem.getMixer(mixerInfo[0]);
		
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try
		{
			clip = (Clip)mixer.getLine(dataInfo);
			clip2 = (Clip)mixer.getLine(dataInfo);
		}
		catch(LineUnavailableException err)
		{
			err.printStackTrace();
		}
		
		try
		{
			URL soundURL = Main.class.getResource("/view/theme.wav");
			URL soundsURL2 = Main.class.getResource("/view/jump.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			AudioInputStream audioStreamTwo = AudioSystem.getAudioInputStream(soundsURL2);
			clip.open(audioStream);
			clip2.open(audioStreamTwo);
		}
		catch(LineUnavailableException lue)
		{
			lue.printStackTrace();
		}
		catch(UnsupportedAudioFileException uafe)
		{
			uafe.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(NullPointerException npe)
		{
			npe.printStackTrace();
		}
		
		clip.start();
		
		controls = new Controller(this);
		
		if(keyPressed)
		{
			if(key == CODED)
			{
				if(keyCode == UP)
				{
					controls.runPlayer();
				}
			}
		}
		
	}
	
	@Override
	public void draw() //void Update
	{
		System.out.println(mouseX + ", " + mouseY);
		noStroke();
		rectMode(CORNER);
		imageMode(CORNER);
		
		loadStages();
		
		switch(stageNum)
		{
		case -1:
			startScreen.resize(800, 500);
			image(startScreen, 0, 0);
			
			//584, 328
			
			if(mousePressed)
			{
				if(mouseX > 584 && mouseX < 703 && mouseY > 328 && mouseY < 372)
				{
					stageNum = 0;
				}
			}
			break;
		case 0:
			instScreen.resize(800, 500);
			image(instScreen, 0, 0);
			
			//584, 328
			
			if(mousePressed)
			{
				if(mouseX > 584 && mouseX < 703 && mouseY > 328 && mouseY < 372)
				{
					stageNum = 1;
				}
			}
			break;
		case 1:
			controls.drawPlayer(this);
			controls.movement(this);
			controls.collision(this);
			controls.parallax(this);
			break;
		case 2:
			controls.drawPlayer(this);
			controls.movement(this);
			controls.collision(this);
			controls.parallax(this);
			break;
		case 3:
			controls.drawPlayer(this);
			controls.movement(this);
			controls.collision(this);
			controls.parallax(this);
			break;
		}
		
		intface();
		paintItems();
		catchItems();
		gameOver();
	}
	
	public void paintItems() 
	{
		
		for(int i = 0; i < itemList.size(); i++)
		{
			Items actual = itemList.get(i);
			
			if(stageNum == 1)
			{
				switch(subStageNum)
				{
				case 0:
					actual.paint(this, 450, 245);
					actual.paint(this, 550, 245);
					actual.paint(this, 650, 245);
					break;
				case 1:
					actual.paint(this, 339, 245);
				}
			}
		}
	}
	
	public void catchItems()
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			Items actual = itemList.get(i);
			System.out.println(actual.getPosX());
			
			if(dist(Player.posX, Player.posY, actual.getPosX(), actual.getPosY()) < 30)
			{
				itemList.remove(i);
				score++;
			}
		}
	}
	
	public void keyReleased()
	{
		controls.keyMovement(this);
	}
	
	public void loadStages() 
	{
		switch(stageNum)
		{
		case 0:
			controls.loadStage1(this);
			break;
		case 1:
			controls.loadStage2(this);
			break;
		case 2:
			controls.loadStage3(this);
			break;
		case 3:
			controls.loadStage4(this);
			break;
		case 4:
			imageMode(CORNER);
			image(gameOverScreen, 0, 0);
		
			textAlign(CENTER);
			fill(255);
			textSize(30);
			text("You Win!", 400, 200);
			break;
		}
	}
	
	public void parallax()
	{
		
	}
	 
	public void keyPressed()
	{
		controls.keyPress(this);
		
		if(key == CODED)
		{
			if(keyCode == UP)
			{
				clip2.start();
			}
		}
			if(key == '1')
			{
				subStageNum = 1;
			}
			if(key == '2')
			{
				subStageNum = 2;
			}
			if(key == '3')
			{
				subStageNum = 3;
			}
			if(key == '4')
			{
				subStageNum = 4;
			}
			if(key == '5')
			{
				subStageNum = 5;
			}
			if(key == '6')
			{
				subStageNum = 6;
			}
	}
	
	public void mousePressed()
	{
		
	}
	
	public void gameOver()
	{
		if(Player.posY > 500 && !(stageNum == 3 && subStageNum == 2))
		{
				imageMode(CORNER);
				image(gameOverScreen, 0, 0);
			
				textAlign(CENTER);
				fill(255);
				textSize(30);
				text("Game Over", 400, 200);
			
				clip.stop();
				gameOver = true;
		}
	}
	
	public void intface()
	{
		if(stageNum > 0)
		{
			textSize(16);
			text("stage " + stageNum, 400, 30);
			text("score " + score, 729, 30);
			
		}
	}

}
