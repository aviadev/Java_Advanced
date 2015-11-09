package Question2;
import java.util.ArrayList;

/**
 * Created by aviad on 04/11/2015.
 */
public class Data
{

public static ArrayList<MonthlyTemperature> _data;
private String _year;

public Data()
	{
		_data = new ArrayList();
	}

protected String getYear() {return _year;}

public void setYear(String year)
	{
		this._year = year;
	}

protected int size() {return _data.size();}



protected void addToList(MonthlyTemperature mt)
	{
		_data.add(mt);
	}

protected int getHighestDegree()
	{
		int max = Integer.MIN_VALUE;

		for (MonthlyTemperature mt : _data)
			{
			max = Math.max(max, mt._degree);
			}
		return max;
	}

public int getDegree(int index)
	{
		return _data.get(index)._degree;
	}

public int getLowestDegree()
	{
		{
		int min = Integer.MAX_VALUE;

		for (MonthlyTemperature mt : _data)
			{
			min = Math.min(min, mt._degree);
			}
		return min;
		}
	}
}
