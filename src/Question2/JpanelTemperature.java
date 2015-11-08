package Question2;
import javax.swing.*;
import java.awt.*;

/**
 * Created by aviad on 04/11/2015.
 */
public class JpanelTemperature extends JPanel
{

final int BAR_WIDTH = 10;
final int SKIP = 100;
TemperatureList tl = new TemperatureList();
private JTable table1;

public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int i = 0; i < tl.size(); i++)
			{
			String currentMonth = String.valueOf(i + 1);
			g.drawRect((i + 1) * SKIP, 150, BAR_WIDTH, (int) tl.getData(i));
			g.drawString(currentMonth, 149, 149);
			g.setColor(Color.gray);
			g.fillRect((i + 1) * SKIP, 150, BAR_WIDTH, (int) tl.getData(i));
			}

		//g.setColor(Color.cyan);
		//g.drawRect(50, 50, 100, 150);
		//g.setColor(Color.green);
		//g.fillOval(150, 100, 200, 201);
		//g.setColor(Color.black);
		//int width = getWidth();
		//int height = getHeight();
		//g.fillRect((width / 2) - 25, (height / 2) - 25, 50, 50);
	}

public void showDialog()
	{
		for (int i = 1; i < 3; i++)
			{
			String message = JOptionPane.showInputDialog("Please input degrees for month " + i + ":");
			tl.addToList(new MonthlyTemperature((i), Integer.parseInt(message)));
			}
	}

}
