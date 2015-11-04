package Question2;
import javax.swing.*;
import java.awt.*;

/**
 * Created by aviad on 04/11/2015.
 */
public class JpanelTemperature extends JPanel
{

public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.cyan);
		g.drawRect(50, 50, 100, 150);
		g.setColor(Color.green);
		g.fillOval(150, 100, 200, 201);
		g.setColor(Color.black);
		int width = getWidth();
		int height = getHeight();
		g.fillRect((width / 2) - 25, (height / 2) - 25, 50, 50);
	}

}
