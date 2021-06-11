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
import controlP5.Textfield;
import controller.Controller;
import model.Items;
import model.Player;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet
{
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

	//////// Score thing
	String[] lines;
	String scoreList;
	public String userName, date;
	Textfield user;
	private ControlP5 cp5;
	private String[] saveName, saveDate, saveScore;
	////////
	
	//PImage background;
	
	Controller controls;
	
	@Override
	public void setup() //void Start
	{

		lines = loadStrings("./data/highScore.txt");
		cp5 = new ControlP5(this);
		createTextFields();

		saveName = new String[5];
		saveScore = new String[5];
		saveDate = new String[5];
		
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

		loadItems();
		
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
			user.setVisible(false);
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
			user.setVisible(false);
			break;
		case 1:
			controls.drawPlayer(this);
			controls.movement(this);
			controls.collision(this);
			controls.parallax(this);
			user.setVisible(false);
			break;
		case 2:
			controls.drawPlayer(this);
			controls.movement(this);
			controls.collision(this);
			controls.parallax(this);
			user.setVisible(false);
			break;
		case 3:
			controls.drawPlayer(this);
			controls.movement(this);
			controls.collision(this);
			controls.parallax(this);
			user.setVisible(false);
			break;
		case 4:
			int d = day(); // Values from 1 - 31
			int m = month(); // Values from 1 - 12
			int y = year(); // 2003, 2004, 2005, etc.

			String day = String.valueOf(d);
			text(day, 10, 28);
			String month = String.valueOf(m);
			text(month, 10, 56);
			String year = String.valueOf(y);
			text(year, 10, 84);

			date = " /" + day + " " + month + " " + year + "/";
			System.out.println(date);
			userName = user.getStringValue();
			user.setVisible(true);
			break;
		}
		
		intface();
		paintItems();
		catchItems();
		gameOver();
	}
	
	public void loadItems()
	{
		itemList.add(new Items(this, 450, 245)); //stage 1, substage 0
		itemList.add(new Items(this, 550, 245)); //stage 1, substage 0
		itemList.add(new Items(this, 650, 245)); //stage 1, substage 0
		itemList.add(new Items(this, 339, 245)); //stage 1, substage 1
		itemList.add(new Items(this, 648, 257)); //stage 1, substage 2
		itemList.add(new Items(this, 548, 257)); //stage 1, substage 2
		itemList.add(new Items(this, 352, 185)); //stage 1, substage 3
		itemList.add(new Items(this, 552, 185)); //stage 1, substage 3
		itemList.add(new Items(this, 193, 239)); //stage 1, substage 4
		itemList.add(new Items(this, 662, 239)); //stage 1, substage 4
		itemList.add(new Items(this, 446, 197)); //stage 1, substage 5
		itemList.add(new Items(this, 227, 190)); //stage 1, substage 6
		itemList.add(new Items(this, 527, 190)); //stage 1, substage 6
	}
	
	public void paintItems() 
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			Items actual = itemList.get(i);
			int stageNumTemporal = stageNum;
			int subStageNumTemporal = subStageNum;
			
			if(stageNumTemporal == 1)
			{
				switch(subStageNumTemporal)
				{
				case 0:
					itemList.get(0).paint(this);
					itemList.get(1).paint(this);
					itemList.get(2).paint(this);
					break;
				case 1:
					itemList.get(3).paint(this);
					break;
				case 2:
					itemList.get(4).paint(this);
					itemList.get(5).paint(this);
					break;
				case 3:
					itemList.get(6).paint(this);
					itemList.get(7).paint(this);
					break;
				case 4:
					itemList.get(8).paint(this);
					itemList.get(9).paint(this);
					break;
				case 5:
					itemList.get(10).paint(this);
					break;
				case 6:
					itemList.get(11).paint(this);
					itemList.get(12).paint(this);
					break;
				}
			}
		}
	}
	
	public void catchItems()
	{
		for(int i = 0; i < itemList.size(); i++)
		{
			Items actual = itemList.get(i);
			//System.out.println(actual.getPosX());
			
			
			if(stageNum == 1)
			{
				switch(subStageNum)
				{
				case 0:
					if(dist(Player.posX, Player.posY, itemList.get(0).getPosX(), itemList.get(0).getPosY()) < 50)
					{
						itemList.get(0).setPosX(-5000);
						score += 100;
					}
					if(dist(Player.posX, Player.posY, itemList.get(1).getPosX(), itemList.get(1).getPosY()) < 50)
					{
						itemList.get(1).setPosX(-5000);
						score += 100;
					}
					if(dist(Player.posX, Player.posY, itemList.get(2).getPosX(), itemList.get(2).getPosY()) < 50)
					{
						itemList.get(2).setPosX(-5000);
						score += 100;
					}
					break;
				case 1:
					if(dist(Player.posX, Player.posY, itemList.get(3).getPosX(), itemList.get(3).getPosY()) < 50)
					{
						itemList.get(3).setPosX(-5000);
						score += 100;
					}
					break;
				case 2:
					if(dist(Player.posX, Player.posY, itemList.get(4).getPosX(), itemList.get(4).getPosY()) < 50)
					{
						itemList.get(4).setPosX(-5000);
						score += 100;
					}
					if(dist(Player.posX, Player.posY, itemList.get(5).getPosX(), itemList.get(5).getPosY()) < 50)
					{
						itemList.get(5).setPosX(-5000);
						score += 100;
					}
					break;
				case 3:
					if(dist(Player.posX, Player.posY, itemList.get(6).getPosX(), itemList.get(6).getPosY()) < 50)
					{
						itemList.get(6).setPosX(-5000);
						score += 100;
					}
					if(dist(Player.posX, Player.posY, itemList.get(7).getPosX(), itemList.get(7).getPosY()) < 50)
					{
						itemList.get(7).setPosX(-5000);
						score += 100;
					}
					break;
				case 4:
					if(dist(Player.posX, Player.posY, itemList.get(8).getPosX(), itemList.get(8).getPosY()) < 50)
					{
						itemList.get(8).setPosX(-5000);
						score += 100;
					}
					if(dist(Player.posX, Player.posY, itemList.get(9).getPosX(), itemList.get(9).getPosY()) < 50)
					{
						itemList.get(9).setPosX(-5000);
						score += 100;
					}
					break;
				case 5:
					if(dist(Player.posX, Player.posY, itemList.get(10).getPosX(), itemList.get(10).getPosY()) < 50)
					{
						itemList.get(10).setPosX(-5000);
						score += 100;
					}
					break;
				case 6:
					if(dist(Player.posX, Player.posY, itemList.get(11).getPosX(), itemList.get(11).getPosY()) < 50)
					{
						itemList.get(11).setPosX(-5000);
						score += 100;
					}
					if(dist(Player.posX, Player.posY, itemList.get(12).getPosX(), itemList.get(12).getPosY()) < 50)
					{
						itemList.get(12).setPosX(-5000);
						score += 100;
					}
					break;
				}
			}
		}
	}
	
	public void createTextFields() { // create the fields and buttons

		cp5 = new ControlP5(this); // create an instance of the controlP5 object for this program

		user = cp5.addTextfield(" ").setPosition(57, 219).setColorActive(color(239, 149, 109))
				.setColorBackground(color(240, 221, 170));

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

			text("there are " + lines.length + " lines", 394, 100);
			text("Current score: " + score, 394, 120);
			for (int i = 0; i < lines.length; i++) {
				text(lines[i], 394, 140 + 35 * i);
			}

			textAlign(CENTER);
			fill(255);
			textSize(60);
			text("You Win!", 400, 80);
			break;
		}
	}
	
	public void parallax()
	{
		
	}
	 
	public void keyPressed()
	{
		controls.keyPress(this);
		
		if (key == CODED) {
			if (keyCode == UP) {
				
				if(stageNum == 4)
				{
				lines[lines.length - 1] = str(score); // agrega los puntajes

				for (int i = lines.length - 1; i > 0; i--) {
					if (parseInt(lines[i]) > parseInt(lines[i - 1])) // agrega solo los puntajes mayores
					{
						String setScoreLower = lines[i - 1]; // lo ordena de mayor a menor
						lines[i - 1] = lines[i] + " " + userName + " " + date;
						lines[i] = setScoreLower;

					}

					saveStrings("./data/highScore.txt", lines); // guarda los puntajes
				}

				sort(lines); // sort?
				}
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
	
	public void sortList(char key) {

		switch (key) {

		case 'n':

			sort(lines);

			for (int i = 0; i < lines.length; i++) {

				String line = userName + " " + score + " " + date;

				saveName[i] = line;

				//saveStrings(" ", saveName);
			}

		case 'm':

			sort(lines);

			for (int i = 0; i < lines.length; i++) {

				String line = date + " " + userName + " " + lines;

				saveDate[i] = line;

				///saveStrings(" ", saveDate);
			}

		case 'b':

			sort(lines);

			for (int i = 0; i < lines.length; i++) {

				String line = lines + " " + userName + " " + date;

				saveScore[i] = line;

				//saveStrings(" ", saveScore);
			}

			break;
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
			text("score " + score, 680, 30);
			
		}
	}

}
