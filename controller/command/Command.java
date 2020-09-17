package controller.command;

import controller.Controller;
import controller.Game;

public abstract class Command {
	private Object data;
	protected Controller context;
	public Command() {
		context = Controller.getController();
	}
	public Command(Object object) {
		data = object;
	}
	public void setContext(Controller controller) {
		context = controller;
	}

	public abstract void execute();
}
