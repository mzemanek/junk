// 2011-02-07
// package pattern.model-view-controller;

import java.io.*;

public class WurzelController
{
	WurzelModel model = null;
	WurzelView view = null;
	
	public WurzelController(WurzelModel model, WurzelView view)
	{
		this.model = model;
		this.view = view;
		
		this.view.setModel(model);
	}
	
	public boolean run()
	{
		this.view.read();
		if (0.0d != this.model.getValue())
		{
			this.model.calculate();
			this.view.write();
			return true;
		}
		
		return false;
	}
}
