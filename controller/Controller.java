package controller;

import controller.command.Command;

public class Controller {
	private static Game game;
	public Controller() {
		game = new Game();
	}
	
	public static void handleRequest(Command command) {
		command.setContext(game);
		command.execute();
	}
}
