package gui;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class GameController {
	private Game game;
	private Board board;
	private boolean isPieceSelected;

	public void checkIfSync(){
		//TODO: exception
	}
	public boolean makeMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to){
		if(game.validateMove(new Move(from, to))){
			game.makeMove(new Move(from, to));
			board.makeMove(new Move(from, to));
			// change turn
			return true;
		}
		return false;
	}

	public void update(){
		board.clearMoveMarks();
		game.update();
	}
}