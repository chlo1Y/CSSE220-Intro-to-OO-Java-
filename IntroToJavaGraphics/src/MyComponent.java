import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D.Double;

import javax.swing.JComponent;

/**
 * 
 */

/**
 * @author yangz
 *
 */
public class MyComponent extends JComponent {
	@Override
	
	
	protected void paintComponent(Graphics g){
		//Ask the superclass to do it wrok
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		
		//Draw a simple rectangle
		Rectangle box= new Rectangle(10,20,30,40);
		g2.draw(box);
		
		for(int i=0; i<(this.getWidth()-10); i+=10){
			box= new Rectangle(10,10,i,i);
			g2.draw(box);
		}
		//draw a circle 
		Ellipse2D myEllipse= new Ellipse2D.Double(50, 25, 90, 40);
		g2.draw(myEllipse);
		
		
		//draw a text
		g2.setFont(new Font("Times New Roman", Font.PLAIN,72));
		g2.drawString("Someone like you",80 , 430);
		
		
		//change colors
		Color c= new Color(128,0,120,120);
		g2.setColor(c);
		box= new Rectangle(5,5,this.getWidth(),this.getHeight());
		g2.fill(box);
		
		//use Arc2D
		double degreeStepSize=15.0;
		double colorStepSize =degreeStepSize*256/360.0;
		int colorValue =0;
		
		//Note: arc Angles increse n counter clockwise directions
		// they are measured in degrees
		for(double degree=0; degree<360; degree+= degreeStepSize){
			g2.setColor(new Color(colorValue,255-colorValue,0));
			Arc2D.Double arcer=new Arc2D.Double(250,450,100,100,
					degree,degreeStepSize,Arc2D.PIE);
			g2.fill(arcer);
			colorValue+= colorStepSize;
		}
		
	}

}
