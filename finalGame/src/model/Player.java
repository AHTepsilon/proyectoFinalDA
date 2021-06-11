package model;

import processing.core.PApplet;
import processing.core.PImage;
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
	
	boolean subiendo,saltoBloqueado, colisionAbajo;
	int saltoYinicial, frameAereosMaximos, framesAereos, velocidadY, velocidadMovimiento;
	
	int velocidadTerminal, velocidadCaida;
	
	PImage siamese, calico, blackCat, ginger, garfield;
	public static int randomCatValue;
	
	PApplet app;	

	public Player(PApplet app) 
	{
		posX = 132;
		posY = 324;
		
		velocityX = 0;
		velocityY = 0;
		speed = 9;
		jumpVel = 5;
		gravity = 1.8;
		
		randomCatValue = (int)app.random(0, 5);
		
		size = 25;
		
		jumpable = 1;
		
		subiendo= false;  //si gana altura
		saltoBloqueado= false; //para no saltar infinitamente
		saltoYinicial=0; //altura para saltar
		frameAereosMaximos=12; //cuanto va a saltar
		framesAereos= frameAereosMaximos;  //cuanto lleva saltando
		
		velocidadTerminal=10; //velocidad en que cae el personaje
		velocidadCaida=0; //para que el personaje caiga mas rapido
		velocidadMovimiento=12;
		
		velocidadY=0;
		
		siamese = app.loadImage("catSiamese.gif");
		calico = app.loadImage("catCalico.gif");
		blackCat = app.loadImage("catBlack.gif");
		ginger = app.loadImage("catGinger.gif");
		garfield = app.loadImage("catGarfield.gif");
		
		if(posY == 324) {
			colisionAbajo=true;
		} else {
			colisionAbajo=false;
		}
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
		app.imageMode(app.CENTER);
		
		switch(randomCatValue)
		{
		case 0:
			app.image(siamese, posX, posY);
			siamese.resize(0, 100);
			break;
		case 1:
			app.image(ginger, posX, posY);
			ginger.resize(0,  100);
			break;
		case 2:
			app.image(blackCat, posX, posY);
			blackCat.resize(0,  100);
			break;
		case 3:
			app.image(calico, posX, posY);
			calico.resize(0,  100);
			break;
		case 4:
			app.image(garfield, posX, posY);
			garfield.resize(0,  100);
			break;
			
			//switching the images with random values
		}
		
	}
	
	public void movement(PApplet app)
	{
		System.out.println(randomCatValue);
		
		velocityY += gravity;
		
		if(velocityY > 100)
		{
			velocityY = 99;
		}
		
		velocityX = (rightKey - leftKey) * speed;
		float nextY = posY + velocityY;
		float nextX = posX;		
		boolean onGroundTemp = false;
		
		posX += velocityX;
		posY += velocityY;
		onGround = onGroundTemp;
		
		/*if(velocityY > 0 && posY < (351-(size/2)))
			{
				velocityY = 0;
				onGroundTemp = true;
			}*/

	}
	
	public void obstacles()
	{
		
	}
	
	public void collisions(PApplet app)
	{
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 0)
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 1 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 2 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 3 && (posX < 120 || posX > 773))
		{
			posY = (350-(size/2));
		}
		else if(posY > (334-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 3 && (posX > 232 && posX < 288))
		{
			posY = (333-(size/2));
		}
		else if(posY > (334-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 3 && (posX > 432 && posX < 488))
		{
			posY = (333-(size/2));
		}
		else if(posY > (334-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 3 && (posX > 632 && posX < 688))
		{
			posY = (333-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 4 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 5 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 1 && Main.subStageNum == 6)
		{
			posY = (350-(size/2));
		}
		
		if(posY > (351-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 0)
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 1 && (posX < 120 || posX > 773))
		{
			posY = (350-(size/2));
		} 
		else if(posY > (320-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 1 && (posX > 260 && posX < 316))
		{
			posY = (319-(size/2));
		}
		else if(posY > (224-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 1 && (posX > 460 && posX < 516))
		{
			posY = (223-(size/2));
		}
		else if(posY > (124-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 1 && (posX > 660 && posX < 716))
		{
			posY = (123-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 2 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 3 && (posX < 120 || posX > 773))
		{
			posY = (350-(size/2));
		} 
		else if(posY > (316-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 3 && (posX > 252 && posX < 302))
		{
			posY = (315-(size/2));
		}
		else if(posY > (316-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 3 && (posX > 451 && posX < 583))
		{
			posY = (315-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 4 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 5 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 2 && Main.subStageNum == 6)
		{
			posY = (350-(size/2));
		}
		
		if(posY > (351-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 0)
		{
			posY = (350-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 1 && (posX < 120 || posX > 773))
		{
			posY = (350-(size/2));
		} 
		else if(posY > (320-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 1 && (posX > 250 && posX < 326))
		{
			posY = (319-(size/2));
		}
		else if(posY > (224-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 1 && (posX > 450 && posX < 526))
		{
			posY = (223-(size/2));
		}
		else if(posY > (124-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 1 && (posX > 650 && posX < 726))
		{
			posY = (123-(size/2));
		}
		else if(posY > (26-(size/2)) && (posY < (28-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 1 && (posX > 450 && posX < 526)))
		{
			posY = (25-(size/2));
		}
		
		if(posY > (489-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 2 && posX > 666)
		{
			posY = (488-(size/2));
		}
		if(posY > (489-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 3 && posX < 113)
		{
			posY = (488-(size/2));
		}
		if(posY > (389-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 3 && posX > 164 && posX < 372)
		{
			posY = (388-(size/2));
		}
		if(posY > (289-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 3 && posX > 413)
		{
			posY = (288-(size/2));
		}
		
		if(posY > (351-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 4 && (posX < 359 || posX > 565))
		{
			posY = (350-(size/2));
		}
		
		if(posY > (351-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 5 && (posX < 120 || posX > 773))
		{
			posY = (350-(size/2));
		} 
		else if(posY > (320-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 5 && (posX > 250 && posX < 326))
		{
			posY = (319-(size/2));
		}
		else if(posY > (224-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 5 && (posX > 450 && posX < 526))
		{
			posY = (223-(size/2));
		}
		else if(posY > (124-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 5 && (posX > 650 && posX < 726))
		{
			posY = (123-(size/2));
		}
		if(posY > (351-(size/2)) && Main.stageNum == 3 && Main.subStageNum == 6 && (posX < 359 || posX > 565))
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
		
		if(app.key == app.CODED && !Main.gameOver)
		{
			if(app.keyCode == app.LEFT)
			{
				leftKey = 1;
			}
			
			if(app.keyCode == app.RIGHT)
			{
				rightKey = 1;
			}
			
			if(app.keyCode == app.UP && velocityY > 0)
			{
				upKey = 1;
				saltoBloqueado=false;
				velocidadCaida=0;
				System.out.println("jumps");
				
//				if(jumpable == 1)
//				{
//					posY -= 200;
//				}
				
				if(saltoBloqueado==false && app.keyCode == app.UP ) {
					subiendo=true;
					saltoBloqueado=true;
				}
				
				if(subiendo) {
					
					framesAereos--;
					velocityY = -25;
					
				}
				if (framesAereos<=0)
				{
					subiendo=false;
					framesAereos=frameAereosMaximos;
				}	
				
				if(colisionAbajo==false && subiendo == false) {
					posY= (int) --velocidadCaida;
					System.out.println(velocidadY);
					if(velocidadCaida <velocidadTerminal) {
						velocidadCaida+=0.3;
					}
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