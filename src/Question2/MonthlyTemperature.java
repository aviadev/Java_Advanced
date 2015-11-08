package Question2;
/**
 * Created by aviad on 04/11/2015.
 */
public class MonthlyTemperature
{

protected double _degree;
protected int _month;

public MonthlyTemperature(double degree)
	{
		_degree = degree;
	}

public MonthlyTemperature(int month, double degree)
	{
		_month = month;
		_degree = degree;
	}

protected double getDegree()
	{
		return _degree;
	}

protected int getMonth()
	{
		return _month;
	}

public double compare(MonthlyTemperature mt1, MonthlyTemperature mt2)
	{
		return Double.compare(mt1.getDegree(), mt2.getDegree());
	}
}
