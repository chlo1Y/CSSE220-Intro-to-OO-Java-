
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * Draws some Faces on a graphics area.
 * 
 * @author Curt Clifton, modified by David Mutchler. Created September 14, 2008.
 *         Modified December 9, 2009.
 */
public class FacesComponent extends JComponent {

	/**
	 * Draws Faces.
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D graphics2 = (Graphics2D) graphics;

		//When ready to test with faces, comment out this line, and comment in the testFaceDrawing 
		//line and method below
//		this.testDrawing(graphics2);s
		this.testFaceDrawing(graphics2);

		//this.testTransforming(graphics2);
	}

	/*
	 * Tests that two circles (one drawn, one filled) appear on the given
	 * Graphics2D object.
	 */
//	private void testDrawing(Graphics2D graphics2) {
//		// A red circle for testing
//		Ellipse2D.Double circle = new Ellipse2D.Double(10, 10, 100, 100);
//
//		graphics2.setColor(Color.red);
//		graphics2.draw(circle);
//
//		// A smaller filled blue circle for testing
//		circle.x += 150;
//		circle.width -= 50;
//		circle.height -= 50;
//		graphics2.setColor(Color.blue);
//		graphics2.fill(circle);
//	}

	/*
	 * Tests that Faces are drawn correctly on the given Graphics2 object.
	 */
	private void testFaceDrawing(Graphics2D graphics2) {
		Face face = new Face();
		face.drawOn(graphics2);

		face = new Face(25, 25, 25, 0, Color.red, Color.green, Color.blue,
				Color.black);
		face.drawOn(graphics2);

		face = new Face(125, 100, 25, 0, Color.black, Color.blue, Color.red,
				Color.blue);
		face.drawOn(graphics2);

		face = new Face(200, 100, 50, 0, Color.black, Color.red, Color.green,
				Color.yellow);
		face.drawOn(graphics2);

		face = new Face(300, 100, 25, 0, Color.black, Color.yellow, Color.blue,
				Color.green);
		face.drawOn(graphics2);
	}

	/*
	 * Tests that Faces are tranlated and rotated and then drawn correctly on
	 * the given Graphics2 object.
	 */
/*	private void testTransforming(Graphics2D graphics2) {
		final int numberOfFacesToTransform = 7;
		final Point2D center = new Point2D.Double(50, 200);
		final double radius = 25;
		final double angleToRotate = 0;
		Face face = new Face(center.getX(), center.getY(), radius,
				angleToRotate, Color.yellow, Color.black, Color.black,
				Color.black);

		for (int k = 0; k < numberOfFacesToTransform; ++k) {
			face.drawOn(graphics2);
			face.translate(2 * radius + 10, 20);
			face.rotate(30);
		}
	}*/
}
