package sim;

import java.awt.Graphics;

import utils.Position;

public class Ant {
	public static final byte up = 0, right = 1, down = 2, left = 3;
	private byte Direction = 0;
	private Position Position = new Position((int)(Math.random()*World.Size), (int)(Math.random()*World.Size));
	
	public Ant() {}
	public Ant(byte startdirection) {Direction = startdirection;}
	public Ant(byte startdirection, Position startposition) {
		Direction = startdirection;
		Position = startposition;
	}

	public void tick() {
		if (World.getCell(Position.X, Position.Y)) 
			rotateLeft();
		else
			rotateRight();
		World.setCell(Position.X, Position.Y, !World.getCell(Position.X, Position.Y));
		moveForward();
		checkBounds();
	}
	
	
	private void moveForward() {
		switch(Direction) {
		case up:
			Position.Y--; break;
		case right: 
			Position.X++; break;
		case down:
			Position.Y++; break;
		case left:
			Position.X--; break;
		}
	}
	
	private void checkBounds() {
		if (Position.X>=World.Size) Position.X=0;
		if (Position.X<0) Position.X=World.Size-1;
		if (Position.Y>=World.Size) Position.Y=0;
		if (Position.Y<0) Position.Y=World.Size-1;
	}
	
	private void rotateLeft() {
		switch(Direction) {
		case up:
			Direction = left; break;
		case right:
			Direction = up; break;
		case down:
			Direction = right; break;
		case left:
			Direction = down; break;
		}
	}
	
	private void rotateRight() {
		switch(Direction) {
		case up:
			Direction = right; break;
		case right: 
			Direction = down; break;
		case down:
			Direction = left; break;
		case left:
			Direction = up; break;
		}
	}
	
	public void render(Graphics canvas) {
		canvas.fillRect(Position.X*World.RenderSize, Position.Y*World.RenderSize, World.RenderSize, World.RenderSize);
	}
}