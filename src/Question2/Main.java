package Question2;
import javax.swing.*;

/**
 * Created by aviad on 04/11/2015.
 */
public class Main
{

public static void main(String[] args)
	{
		JFrame jFrame = new JFrame("Temperatures Graphs");
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setSize(500, 500);
		//Graphics g = null;
		//TemperatureList temperatureList = new TemperatureList();

		//String test1= JOptionPane.showInputDialog("Please input mark for test 1: ");
		//temperatureList.getHighestMonthlyTemperature();
		JpanelTemperature jpanelTemperature = new JpanelTemperature();
		//InputDialog inputDialog = new InputDialog();
		jFrame.add(jpanelTemperature);

		//jpanelTemperature.paintComponent();
		jpanelTemperature.showDialog();
		jFrame.add(new Rectangle(100, 150, 10, 20));
		jFrame.setVisible(true);
		//		jpanelTemperature.paintComponent(g);

		//CustomDialog customDialog = new CustomDialog(jFrame, "CustomDialog");

		//customDialog.setSize(100, 100);
		//customDialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//customDialog.setVisible(true);
		//jFrame.add(customDialog);

	}
}
