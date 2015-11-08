package Question2;
import javax.swing.*;

/**
 * Created by aviad on 07/11/2015.
 */
public class Rectangle extends JComponent
{

private int _x, _y, _height, _width;

public Rectangle(int x, int y, int height, int width)
	{
		_x = x;
		_y = y;
		_height = height;
		_width = width;
	}
}





/*
// Member instance field
private .Double sphere;
private int radius;
double circumference, area;


// Default constructor
public Circle()
	{
		sphere = new Ellipse2D.Double();
	}

public void setSphere(Ellipse2D.Double sphere) {
	this.sphere = sphere;
	repaint();
}

// User defined constructor
public Circle(int xAxis, int yAxis, int rad)
	{
		sphere = new Ellipse2D.Double(xAxis, yAxis, rad, rad);
	}

// Accessor methods
public double calcCircumference()
	{
		return circumference = 2 * Math.PI * radius;
	}

public double calcArea()
	{
		return area = Math.PI * radius * radius;
	}

// Methods
public void inputX()
	{
		int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
		double y = sphere.y; // why is there a double y here when it asks for x?
		Ellipse2D.Double newSphere = new Ellipse2D.Double(x, y, size, size);
		setSphere(newSphere);
	}

public void inputY()
	{
		int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));
		double x = sphere.x;
		Ellipse2D.Double newSphere = new Ellipse2D.Double(x, y, size, size);
		setSphere(newSphere);
	}



@Override
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;

	g2.setColor(Color.BLUE); // set circle color to blue
	g2.fill(sphere);
	g2.draw(sphere);

	g2.drawString("Circumference: " + calcCircumference(), 5, 490);

}

@Override
public Dimension getPreferredSize() {
	return new Dimension(600, 500);
}
}*/
