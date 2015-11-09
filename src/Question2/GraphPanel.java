package Question2;
import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel
{

private static Data _data;
private int padding = 50;

public GraphPanel(Data data)
	{
		_data = data;

	}

@Override
protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics g2 = g;
		g2.setColor(Color.cyan);
		g2.drawString("" + _data.getYear(), getWidth() / 2, getHeight() / 2);
		g2.setColor(Color.PINK);
		g2.fillRect(padding, padding, getWidth() - (2 * padding), getHeight() - 2 * padding);
		g2.setColor(Color.BLACK);

		g2.drawLine(padding, getHeight() - padding, getWidth() - padding, getHeight() - padding);
		g2.setColor(Color.black);
		g2.drawString("" + _data.getYear(), getWidth() - (getWidth() / 2), getHeight() - (getHeight() / 2));
		g2.drawString("Month", getWidth() - (getWidth() / 2), getHeight() - 5);
		g2.drawString("Temperature", +5, getHeight() - (getHeight() / 2));
		for (int i = 0; i < _data.size(); i++)
			{
			int highest = _data.getHighestDegree();
			int lowest = _data.getLowestDegree();
			int x = (i * (getWidth() - padding * 2) / (_data.size())) + padding;
			int y = getHeight() - padding;
			g2.setColor(Color.gray);
			if (_data.getDegree(i) < highest && _data.getDegree(i) > lowest)
				{
				g2.fillRect(x, y, 25, -_data.getDegree(i) * 5);
				g2.setColor(Color.black);
				g2.drawString("" + (i + 1), x, getHeight() - (padding / 2) - 10);
				g2.setColor(Color.black);
				g2.drawString("" + _data.getDegree(i), x, y - (_data.getDegree(i) * 5) - padding);

				}
			else if (_data.getDegree(i) == highest)
				{
				g2.setColor(Color.red);
				g2.fillRect(x, y, 25, -_data.getDegree(i) * 5);
				g2.setColor(Color.black);
				g2.drawString("" + (i + 1), x, getHeight() - (padding / 2) - 10);

				}
			else if (_data.getDegree(i) == lowest)
				{
				g2.setColor(Color.blue);
				g2.fillRect(x, y, 25, -_data.getDegree(i) * 5);
				g2.setColor(Color.black);
				g2.drawString("" + (i + 1), x, getHeight() - (padding / 2) - 10);

				}
			g2.setColor(Color.black);
			g2.drawString("" + _data.getDegree(i), x, y - (_data.getDegree(i) * 5) - padding);
			}

	}
}