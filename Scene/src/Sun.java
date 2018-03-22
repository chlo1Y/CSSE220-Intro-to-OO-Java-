import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 */

/**
 * @author yangz
 *
 */
public class Sun {
	
	private static final Color BORDER_COLOR = Color.BLACK;
	private static final int NUMBER_OF_RAYS = 8;
	private static final double RAY_LENGTH_SCALE = 0.5;
	private static final double RAY_WIDTH_SCALE = 0.1;
	private static final double RAY_DISTANCE_FROM_SUN_SCALE = .2;
	private static final double DEFAULT_SUN_DIAMETER = 100.0;
	private static final double DEFAULT_SUN_X = 100.0;
	private static final double DEFAULT_SUN_Y = 100.0;
	private static final Color DEFAULT_SUN_COLOR = Color.YELLOW;
	
	double xPosotion;
	double yPosition;
	double circleDiameter;
	double rayLength;
	double rayWidth;
	Color color;
	double initialAngle=0;
	Color borderColor=Color.black;
	
	//create a default sun constructor
	public Sun(){
		this.xPosotion=DEFAULT_SUN_X;
		this.yPosition=DEFAULT_SUN_Y;
		this.circleDiameter=DEFAULT_SUN_DIAMETER;
		this.rayLength=RAY_LENGTH_SCALE;
		this.rayWidth=RAY_WIDTH_SCALE;
		this.color=DEFAULT_SUN_COLOR;
	}
	
	//create a sun constructor 
	public Sun(double x, double y, double circleD,Color suncolor){
		this.xPosotion=x;
		this.yPosition=y;
		this.circleDiameter=circleD;
		this.rayLength=RAY_LENGTH_SCALE;
		this.rayWidth=RAY_WIDTH_SCALE;
		this.color=suncolor;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.translate(this.xPosotion+this.circleDiameter/2, this.yPosition+this.circleDiameter/2);
		sunNoRay(g2);
		double angleBetweenRays =2*Math.PI/NUMBER_OF_RAYS;
		for(int i=0; i<NUMBER_OF_RAYS+1; i++){
			double angle= this.initialAngle +i*angleBetweenRays;
			drawRay(g2, angle);	
		}
		g2.translate(-(this.xPosotion+this.circleDiameter/2), -(this.yPosition+this.circleDiameter/2));
	}
	// only draw the sun 
	public void sunNoRay(Graphics2D g2){
		Ellipse2D sun= new Ellipse2D.Double(-this.circleDiameter/2, -this.circleDiameter/2, this.circleDiameter, this.circleDiameter);
		g2.setColor(this.color);
		g2.fill(sun);
		g2.setColor(borderColor);
		g2.setStroke(new BasicStroke(0.2f));
		g2.draw(sun);
		
	}
	// only draw the ray 
	public void drawRay(Graphics2D g2, double angle){
		double rayFromSun= this.circleDiameter*RAY_DISTANCE_FROM_SUN_SCALE;
		double rayHeight= this.circleDiameter*RAY_LENGTH_SCALE;
		double rayWidth= this.circleDiameter*RAY_WIDTH_SCALE;
		Rectangle2D rays= new Rectangle2D.Double( this.circleDiameter/2+rayFromSun,-rayWidth/2
		, rayHeight, rayWidth);
		g2.rotate(angle);
		g2.setColor(this.color);
		g2.fill(rays);
		g2.setColor(BORDER_COLOR);
		g2.draw(rays);
		g2.rotate(-angle);
	}
	

}
