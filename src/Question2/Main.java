package Question2;
import javax.swing.*;
import java.awt.*;

/**
 * Created by aviad on 04/11/2015.
 */
public class Main
{

protected static Data _data = new Data();

public static void main(String[] args)
	{
		ShowUserDialog();
		GraphPanel mainPanel = new GraphPanel(_data);

		mainPanel.setPreferredSize(new Dimension(800, 800));

		JFrame frame = new JFrame("Temperatures Graphs");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

protected static void ShowUserDialog()
	{
		final JPanel panel = new JPanel();
		String year = JOptionPane.showInputDialog("Please input the year:");
		_data.setYear(year);
		for (int i = 1; i < 13; i++)
			{
			String input = JOptionPane.showInputDialog("Please input degrees for month " + i + ":");
			while (!isValidInput(input))
				{
				JOptionPane.showMessageDialog(panel, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
				input = JOptionPane.showInputDialog("Please input degrees for month " + i + ":");
				}
			_data.addToList(new MonthlyTemperature((i), Integer.parseInt(input)));
			}
	}

private static boolean isValidInput(String input)
	{
		if (input.length() == 0 || input.contains(" ") || input.isEmpty()) return false;
		String validChars = "0123456789";
		for (int i = 0; i < input.length(); i++)
			{
			if (!validChars.contains(input.substring(i, i + 1))) return false;
			}
		return true;

	}
}
