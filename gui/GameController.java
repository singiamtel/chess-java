package gui;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class GameController {
	private Game game;
	private Board board;
	private boolean isPieceSelected;
	private Pair<Integer, Integer> pieceSelected;

	public void checkIfSync(){
		//TODO: exception
	}
	public boolean makeMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to){
		Move move = new Move(from, to);
		if(game.validateMove(move)){
			game.makeMove(move);
			board.makeMove(move);
			// change turn
			return true;
		}
		return false;
	}

	private void update(){
		board.clearMoveMarks();
		game.update();
	}
	private void generateMoveMarks(){
		
	}

	public void handleClick(Pair<Integer, Integer> on){
		if(!isPieceSelected && board.getSquareAt(on) != null){
			this.isPieceSelected = true;
			this.pieceSelected = on;
			generateMoveMarks();

			// Make green marks
		}
	}
}