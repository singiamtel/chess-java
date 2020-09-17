package controller.command;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import gui.Board;
import utilities.Pair;

public class SelectPiece extends Command{
	Pair<Integer, Integer> coor;
	public SelectPiece(Pair<Integer, Integer> coor) {
		this.coor = coor;
	}

	public void execute() {
		
		ArrayList<Move> moves = context.getPieceAtSquare(coor).generateMoves(context);
		for (Move move : moves) {
			//board.getSquareAt(move.getTo());
		}
	}

}
