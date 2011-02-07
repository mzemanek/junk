// 2011-02-07
// package pattern.model-view-controller;

public abstract class Wurzel
{
	public static void main(String[] args)
	{
		WurzelController controller = null;
		WurzelModel model = null;
		WurzelView view = null;
		
		model = new WurzelModel();
		view = new WurzelView();
		controller = new WurzelController(model, view);

		while (controller.run());
	}
}
