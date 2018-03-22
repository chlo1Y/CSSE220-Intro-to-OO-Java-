import java.awt.Dimension;

import javax.swing.JFrame;


public class SceneViewer {
	
	public static final Dimension SCENE_VIEWER_SIZE = new Dimension(750, 600);
	/**
	 * Constructs and displays the JFrame which displays Suns via a
	 * SunComponent.
	 * 
	 * @param args
	 */
	// create a scene view
	public static void main(String[] args) {
		
		
			JFrame frame = new JFrame();

			frame.setSize(SCENE_VIEWER_SIZE);
			frame.setTitle("Scene!");

			frame.add(new SceneComponent());

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}

}
