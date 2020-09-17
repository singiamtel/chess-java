package controller.command;

import java.util.ArrayList;

import controller.Controller;
import controller.Game;
import controller.Move;
import gui.Square;
import utilities.Pair;

public class SelectPiece extends Command{
	Pair<Integer, Integer> coor;
	public SelectPiece(Pair<Integer, Integer> coor) {
		super();
		this.coor = coor;
	}

	public void execute() {
		Game game = context.getGame();
		ArrayList<Move> moves = game.getPieceAtSquare(coor).generateMoves(game);
		for (Move move : moves) {
			//System.out.println(Controller.getController().getMainWindow().getBoard());
			Square oldSquare = Controller.getController().getMainWindow().getBoard().getSquareAt(move.getTo());
			Square newSquare = new Square(oldSquare.isWhite(), oldSquare.getPiece(), true, move.isCheck(),move.isEating());
			context.getMainWindow().getBoard().setSquareAt(move.getTo(), newSquare);
			// context.getMainWindow().getBoard().getSquareAt(move.getTo());
			
		}
	}

}
