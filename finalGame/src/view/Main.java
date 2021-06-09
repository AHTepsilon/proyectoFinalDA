package view;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

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
	
	public static Mixer mixer;
	public static Clip clip, clip2;
	
	int characterX, characterY;
	static public int landscapeX;
	static public int stageNum, subStageNum;
	
	//PImage background;
	
	Controller controls;
	
	@Override
	public void setup() //void Start
	{
		cp5 = new ControlP5(this);
		
		//background = loadImage("land.jpg");
		landscapeX = 0;
		stageNum = 0;
		subStageNum = 0;
		
		characterX = 31;
		characterY = 324;
		
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
		
		clip.start();
		
		/*do
		{
			try
			{
				Thread.sleep(50);
			}
			catch(InterruptedException err)
			{
				err.printStackTrace();
			}
		}*/
		
		//while(clip.isActive());
		
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
		//System.out.println(mouseX + ", " + mouseY);
		//image(background, landscapeX, -1300);
		noStroke();
		rectMode(CORNER);
		
		loadStages();
		
		switch(stageNum)
		{
		case 0:
			
			break;
		case 1:
			controls.drawPlayer(this);
			controls.movement(this);
			controls.collision(this);
			controls.parallax(this);
			break;
		}
		
		/*rectMode(CENTER);
		fill(255, 0, 0);
		square(characterX, characterY, 25);*/
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
	}
	
	public void mousePressed()
	{
		if(stageNum == 0)
		{
			stageNum = 1;
		}
	}

}
