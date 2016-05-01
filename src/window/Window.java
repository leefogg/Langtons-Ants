package window;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import sim.Simulation;


public class Window {
	
	public static void main(String arg[]) {
		new Window("Langton's Ants", 500, 500, new Simulation());
	}
	
	public Window(String Title, int Width, int Height, Component contents) {
		JFrame f = new JFrame();
		f.getContentPane().add(contents);
		contents.setFocusable(true);
		f.setSize(Width,Height);
		f.setResizable(false);
		f.setTitle(Title);
		f.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(screen.width/2-Width/2, screen.height/2-Height/2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
