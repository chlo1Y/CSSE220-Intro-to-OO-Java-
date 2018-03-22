import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JComponent;


public class SceneComponent extends JComponent{
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g2 = (Graphics2D) graphics;
		drawScene(g2);
		
	
	}
	// the frame's height and width
	private static final double FrameHeight=600;
	private static final double FrameWidth=750;
	
	
	
	private void drawScene(Graphics2D g2){
		Rectangle2D sky= new Rectangle2D.Double(0, 0, FrameWidth, 375);// draw the sky
		g2.setColor(Color.BLUE);
		g2.draw(sky);
		g2.fill(sky);
		
		Rectangle2D ground= new Rectangle2D.Double(0,375,FrameWidth,FrameHeight-375);// draw the ground
		g2.setColor(Color.GREEN);
		g2.draw(ground);
		g2.fill(ground);
		
		Sun mysun= new Sun(); //add sun object 
		mysun.drawOn(g2);
		Face myface= new Face(450,350,30,30,Color.yellow,Color.black,Color.blue,Color.red); // add face object
		myface.drawOn(g2);
		
	}

}
