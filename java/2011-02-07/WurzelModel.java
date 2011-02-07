// 2011-02-07
// package pattern.model-view-controller;

public class WurzelModel
{
	private double result = 0.0d;
	private double value = 0.0d;

	public double getResult()
	{
		return this.result;
	}
	
	public void setResult(double value)
	{
		this.result = value;
	}
	
	public double getValue()
	{
		return this.value;
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public void calculate()
	{
		this.result = Math.sqrt(this.value);
	}
}
