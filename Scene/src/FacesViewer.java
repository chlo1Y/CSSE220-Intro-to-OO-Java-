
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * A FacesViewer displays Face objects via a JFrame that has a FacesComponent.
 * 
 * @author Curt Clifton, modified by David Mutchler. Created September 14, 2008,
 *         modifed December 9, 2009.
 */
public class FacesViewer {

	public static final Dimension FACE_VIEWER_SIZE = new Dimension(500, 400);
	/**
	 * Constructs and displays the JFrame which displays Faces via a
	 * FacesComponent.
	 * 
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(FACE_VIEWER_SIZE);
		frame.setTitle("I see faces!");

		frame.add(new FacesComponent());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
