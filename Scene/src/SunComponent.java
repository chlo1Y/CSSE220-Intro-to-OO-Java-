import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * 
 */

/**
 * @author yangz
 *
 */
public class SunComponent extends JComponent {
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D graphics2 = (Graphics2D) graphics;
		this.testFaceDrawing(graphics2);
	}
	
	private static final double LITTLE_SUN_SIZE = 30.0;
	private static final double LITTLE_SUN_SEPARATION = 100.0;
	private static final int NUM_LITTLE_SUNS = 5;
	private static final double LITTLE_SUNS_Y = 400.0;
	private static final Color LITTLE_SUN_COLOR = Color.RED;
	private static final double LITTLE_SUNS_X_OFFSET = 50;
	
	
	
	private void testFaceDrawing(Graphics2D g2) {
		Sun s =new Sun();
		s.drawOn(g2);
		//draws a rectangle around the default sun
		g2.drawRect(30, 30, 240, 240);
				
		//draws a rectangle around a new sun in a particular position
		s= new Sun(550, 100, 50, Color.BLUE);
		s.drawOn(g2);
		g2.drawRect(515, 65, 120, 120);
		
		for(int i=0; i<NUM_LITTLE_SUNS; i++){
			s=new Sun((i+1)*LITTLE_SUNS_X_OFFSET*1+LITTLE_SUN_SIZE*i*1.5,LITTLE_SUNS_Y,LITTLE_SUN_SIZE,LITTLE_SUN_COLOR);
			s.drawOn(g2);
		}
	}

}
	
