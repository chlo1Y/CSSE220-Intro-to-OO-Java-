import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

/**
 * 
 */

/**
 * @author yangz
 *
 */
public class Face {
	int centerX;
	int centerY;
	int circleRadius;
	int trans;
	Color faceColor;
	Color eyeColor;
	Color outlineColor;
	Color mouthColor;
//create a face constructor
	public Face(int i, int j, int k, int l, Color red, Color green, Color blue,
			Color black) {
		this.centerX=i;
		this.centerY=j;
		this.circleRadius=k;
		this.trans=l;
		this.faceColor=red;
		this.outlineColor=green;
		this.eyeColor=blue;
		this.mouthColor=black;
	}
 // create a default face construction
	public Face() {
		this.centerX=50;
		this.centerY=100;
		this.circleRadius=50;
		this.trans=0;
		this.faceColor=Color.yellow;
		this.eyeColor=Color.black;
		this.outlineColor=Color.blue;
		this.mouthColor=Color.red;
		
	}
// a draw on method to draw every part of the face: face, eyes, mouth
	public void drawOn(Graphics2D graphics2) {
		graphics2.translate(centerX, centerY);  //translate graphics2D object 
		//to the given x,y coordinates
		justface(graphics2); //draw face function
		justEyes(graphics2);
		justMouth(graphics2);
		graphics2.translate(-centerX, -centerY); //translate back
		
	}
	
// a method that draws the face
	public void justface(Graphics2D g2){
		
		Ellipse2D faces= new Ellipse2D.Double(-this.circleRadius, -this.circleRadius, 
				this.circleRadius*2, this.circleRadius*2);  //draw the face 
		
		
		g2.setColor(this.faceColor); //set and fill color 
		g2.fill(faces);
		g2.setColor(outlineColor);
	    g2.setStroke(new BasicStroke(3.0f));  // Make lines 3 times their default thickness
	    g2.draw(faces);
		
	}
// a method that draws the eyes
	public void justEyes(Graphics2D g2){
		double x= Math.sqrt(2)*this.circleRadius/4; //this is the distance that is from the circle center
		// to the eyes
		Ellipse2D oneeye= new Ellipse2D.Double(x-0.28*this.circleRadius, 
				-x-0.28*this.circleRadius, 
				this.circleRadius*0.28*2, this.circleRadius*0.28*2);
		Ellipse2D twoeye= new Ellipse2D.Double(-x-0.28*this.circleRadius, 
				-x-0.28*this.circleRadius, 
				this.circleRadius*0.28*2, this.circleRadius*0.28*2);
		
		g2.setColor(this.eyeColor);
		g2.fill(oneeye);
		g2.fill(twoeye);
	}
	
	// a method that draws the mouth
	public void justMouth(Graphics2D g2){
		Arc2D mouth= new Arc2D.Double(-0.7*this.circleRadius, -0.7*this.circleRadius, 
				0.7*this.circleRadius*2, this.circleRadius*0.7*2, 
				-15, -150, Arc2D.CHORD);
		g2.setColor(this.mouthColor);
		g2.setStroke(new BasicStroke(2.0f));
		g2.draw(mouth);
		
		
	}
	

}
