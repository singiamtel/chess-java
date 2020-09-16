package controller.command;

import java.util.ArrayList;

import controller.Move;
import utilities.Pair;

public class SelectPiece extends Command{
	Pair<Integer, Integer> coor;
	public SelectPiece(Pair<Integer, Integer> coor) {
		this.coor = coor;
	}

	public void execute() {
		
		ArrayList<Move> awd = context.getPieceAtSquare(coor).generateMoves(context);

		for (Move move : awd) {
			System.out.println("Move " + move.toString() + ": " +  move.getFrom() + " " + move.getTo());
		}
	}

}
