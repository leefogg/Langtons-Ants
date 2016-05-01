package sim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class World {
	public static final int Size = 250,  RenderSize = 500/Size;
	private static boolean[][] Tiles = new boolean[Size][Size];

	private static BufferedImage scene = new BufferedImage(Size, Size, BufferedImage.TYPE_BYTE_BINARY);
	
	public static void init() {
		Graphics canvas = scene.getGraphics();
		canvas.setColor(Color.white);
		canvas.fillRect(0, 0, Size, Size);
	}
	
	public static boolean getCell(int x, int y) {
		if (!isInBounds(x, y)) 
			return false;
		
		return Tiles[x][y];
	}
	
	public static void setCell(int x, int y, boolean value) {
		if (!isInBounds(x, y)) 
			return;
		
		Tiles[x][y] = value;
		Graphics canvas = scene.getGraphics();
		if (value) 
			canvas.setColor(Color.black);
		else
			canvas.setColor(Color.white);
		canvas.fillRect(x, y, 1, 1);
	}
	
	public static boolean isInBounds(int x, int y) {
		if (x>=Size) 	return false;
		if (x<0) 		return false;
		if (y>=Size) 	return false;
		if (y<0) 		return false;
		return true;
	}
	
	public static void render(Graphics canvas) {
		canvas.drawImage(scene, 0, 0, 500, 500, null);
	}
}