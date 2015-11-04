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
		JPanelTemperatureeeeeeee jpanelTemperature = new JPanelTemperatureeeeeeee();
		jFrame.add(jpanelTemperature);
		jFrame.setVisible(true);
		CustomDialog customDialog = new CustomDialog(jFrame, "CustomDialog");
		customDialog.setVisible(true);
		customDialog.setSize(100, 100);
		customDialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
}
