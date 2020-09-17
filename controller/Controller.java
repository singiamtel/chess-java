package controller;

import controller.command.Command;
import gui.MainWindow;

public class Controller {
	private static Controller controller;
	private Game game;
	private MainWindow mainWindow;
	private Controller() {
		game = new Game();
		mainWindow = new MainWindow(this);
	}
	public static Controller getController() {
		if(controller != null) return controller;
		return new Controller();
	}
	
	public void handleRequest(Command command) {
		command.setContext(this);
		command.execute();
	}

	public Game getGame() {
		return game;
	}
    
	public MainWindow getMainWindow() {
		return mainWindow;
	}
}
