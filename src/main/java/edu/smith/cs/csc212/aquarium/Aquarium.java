package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
	}

	int fish1X = getWidth() + 100;
	int fish2X = getWidth() + 300;
	int fish3X = -100;
	
	Fish nemo = new Fish(Color.magenta, 200, 200, true, true);
	Fish marlin = new Fish(Color.orange, 100, 100, false, false);
	Fish dory = new Fish(Color.cyan, 400, 100, true, false);
	Fish goldie = new Fish(Color.yellow, 300, 400, false, true);

	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		//Draw fish
		nemo.draw(g);
		marlin.draw(g);
		dory.draw(g);
		goldie.draw(g);

		
		// Draw our snail!
		algorithm.draw(g);

		// Move the fish!
		nemo.swim();
		fish1X -= 1;
		fish2X -= 2;
		fish3X += 3;
		
		//wrap the fish around the screen
		
		if (fish3X > getWidth() + 100) {
			fish3X = -100;
		}
		
		if (fish2X > getWidth() + 100) {
			fish2X = -300;
		}
		
		if (fish1X > getWidth() + 100) {
			fish1X = -100;
		}
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
