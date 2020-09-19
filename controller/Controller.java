package controller;

import controller.command.Command;
import gui.MainWindow;
import gui.Square;
import utilities.Pair;

public class Controller {
	private static Controller controller;
	private Game game;
	private MainWindow mainWindow;
	private boolean isPieceSelected;
	private Pair<Integer, Integer> lastPieceSelected;
	//private Square[] moves;
	
	
	private Controller() {
		game = new Game();
		mainWindow = new MainWindow(this);
		isPieceSelected = false;
	}
	public static Controller getController() {
		if(controller != null) return controller;
		controller = new Controller();
		return controller;
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
	
	public boolean isPieceSelected() {
		return isPieceSelected;
	}
	public void setPieceSelected(boolean isPieceSelected) {
		this.isPieceSelected = isPieceSelected;
	}
	
	public Pair<Integer, Integer> getLastPieceSelected() {
		return lastPieceSelected;
	}
	public void setLastPieceSelected(Pair<Integer, Integer> lastPieceSelected) {
		this.lastPieceSelected = lastPieceSelected;
	}
}
