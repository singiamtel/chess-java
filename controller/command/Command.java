package controller.command;

import controller.Game;

public abstract class Command {
	private Object data;
	protected Game context;
	public Command() {
		
	}
	public Command(Object object) {
		data = object;
	}
	public void setContext(Game game) {
		context = game;
	}

	public abstract void execute();
}
