package controller.command;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import gui.Board;
import gui.Square;
import utilities.Pair;

public class SelectPiece extends Command{
	Pair<Integer, Integer> coor;
	public SelectPiece(Pair<Integer, Integer> coor) {
		this.coor = coor;
	}

	public void execute() {
		Game game = context.getGame();
		ArrayList<Move> moves = game.getPieceAtSquare(coor).generateMoves(game);
		for (Move move : moves) {
			Square oldSquare = context.getMainWindow().getBoard().getSquareAt(move.getTo());
			context.getMainWindow().getBoard().setSquareAt(move.getTo(),new Square(oldSquare.isWhite(), oldSquare.getPiece(), true, move.isCheck(),move.isEating()));
			// context.getMainWindow().getBoard().getSquareAt(move.getTo());
			
		}
	}

}