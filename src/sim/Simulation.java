package sim;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Simulation extends JPanel {
	private static final long serialVersionUID = -8910413487881266807L;
	ArrayList<Ant> Ants = new ArrayList<Ant>();
	
	public Simulation() {
		World.init();
		
		for (int n=0; n<100; n++) 
			Ants.add(new Ant((byte)(Math.random()*4)));
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {repaint();}
		}, 0, 1000/60);
	}

	public void paintComponent(Graphics canvas) {
		for (Ant ant : Ants) 
			ant.tick();
		
		World.render(canvas);
		canvas.setColor(Color.green);
		for (Ant ant : Ants) 
			ant.render(canvas);
	}
}