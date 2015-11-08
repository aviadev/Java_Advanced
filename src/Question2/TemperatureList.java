package Question2;
import java.util.ArrayList;

/**
 * Created by aviad on 04/11/2015.
 */
public class TemperatureList
{

//protected int size = _temperatureList.size();
public ArrayList<MonthlyTemperature> _temperatureList = new ArrayList();
private MonthlyTemperature lowest;
private MonthlyTemperature highest;

public TemperatureList()
	{

	}

public ArrayList<MonthlyTemperature> getTemperatureList()
	{return _temperatureList;}

protected int size() {return _temperatureList.size();}

protected void sortListByMonth()
	{
		_temperatureList.sort((o1, o2) -> o1.getMonth() - o2.getMonth());
	}

protected void addToList(MonthlyTemperature mt)
	{
		_temperatureList.add(mt);
	}
/*protected MonthlyTemperature findMax()
	{
		Optional <MonthlyTemperature> max;
		//max = _temperatureList.stream().mapToDouble((x) -> x.getDegree()).max();
		//_temperatureList.stream().max((o1, o2) -> o1.getDegree() - o2.getMonth())
		//.get().compare();



		return null;
	}*/

protected MonthlyTemperature getHighestMonthlyTemperature()
	{
		for (int i = 0; i < size(); i++)
			{
			MonthlyTemperature current = _temperatureList.get(i);
			MonthlyTemperature next = _temperatureList.get(i + 1);
			if (current._degree > next._degree && current._degree > highest._degree)
				{
				highest = current;
				}

			}
		return highest;
	}

private double findMax(double... values)
	{
		double max = Double.NEGATIVE_INFINITY;

		for (double d : values)
			{
			if (d > max) max = d;
			}

		return max;
}

public double getData(int i)
	{
		return _temperatureList.get(i)._degree;
	}
}
