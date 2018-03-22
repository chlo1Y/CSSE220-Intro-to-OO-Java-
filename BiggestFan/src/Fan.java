import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * This class is a graphics shape that draws a fan. It's an abstract fan that
 * just shows the fan blades.
 * 
 * @author Curt Clifton. Created Dec 8, 2010.
 */
public class Fan {
	/**
	 * Used to calculate blade width from the given blade length.
	 */
	private static final double BLADE_ASPECT_RATIO = 0.618033989;

	private static final Color BORDER_COLOR = Color.BLACK;

	private double centerX;
	private double centerY;
	private double bladeLength;
	private int numberOfBlades;
	private Color color;
	private double angleInRadians = 0.0;

	/**
	 * Constructs a new fan with the given parameters.
	 * 
	 * @param centerX
	 * @param centerY
	 * @param bladeLength
	 * @param numberOfBlades
	 * @param color
	 */
	public Fan(double centerX, double centerY, double bladeLength,
			int numberOfBlades, Color color) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.bladeLength = bladeLength;
		this.numberOfBlades = numberOfBlades;
		this.color = color;
	}

	/**
	 * Draws the fan onto the given Graphics2D object.
	 * 
	 * @param graphics2
	 *            Graphics object onto which to draw
	 */
	public void drawOn(Graphics2D graphics2) {
		// TODO: implement
		// move the origin (0,0) to the center of the fan
		//this allows us to avoid adding the center X and the centerY to all our graphics
		//coordinates
		
		//NOTE:the translate method that we called is of the the 
		//graphics area
		
		
		graphics2.translate(this.centerX, this.centerY);
		
		// paint the correct number of blades onto the graphics
		double angleBetweenBlades=2*Math.PI/this.numberOfBlades;
		for(int i=0; i<this.numberOfBlades; i++){
			//calculate angle at which to draw the next blade
			double angle =this.angleInRadians+i*angleBetweenBlades;
			// call a helper method to draw a single blade
			// this makes the code more concise and easier to view
			drawBlade(graphics2,angle);
			
		}
		graphics2.translate(-centerX, -centerY);
	}

	// TODO: Add a helper method for drawing fan blades.

	/**
	 * Draw a single blade to the given graphics area at the given angle 
	 * 
	 */
	private void drawBlade(Graphics2D g2, double angle) {
		
		//rotates the graphic area to give the impression
		//that we are drawing a horizontal rectangle, but 
		// get one that appears rotated in the window 
		//Note: we are calling the graphics area 's rotate 
		//method, not the fan's!
		
		//NOTE: rotating with a positive angle rotates points 
		// on the positive x axis toward the positive y axis 
		g2.rotate(angle);
		
		//Draw the blade
		Rectangle2D.Double blade = new Rectangle2D.Double(0,0,
				this.bladeLength,this.bladeLength*BLADE_ASPECT_RATIO);
		g2.setColor(this.color);
		g2.fill(blade);
		g2.setColor(BORDER_COLOR);
		
		g2.draw(blade);
		g2.rotate(-angle);
	}

	/**
	 * Translates the fan by the given amount.
	 * 
	 * @param translateX
	 *            Amount to translate in the x direction
	 * @param translateY
	 *            Amount to translate in the y direction
	 */
	public void translate(double translateX, double translateY) {
		this.centerX += translateX;
		this.centerY += translateY;
	}

	/**
	 * Rotates the fan by the given number of degrees.
	 * 
	 * @param degreesToRotate
	 *            Number of degrees to rotate the fan (e.g. 180 to turn the fan
	 *            upside down)
	 */
	public void rotate(double degreesToRotate) {
		double radiansToRotate = Math.toRadians(degreesToRotate);
		this.angleInRadians += radiansToRotate;
	}

}
