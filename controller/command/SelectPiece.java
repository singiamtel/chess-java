package controller.command;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class SelectPiece extends Command{
	Pair<Integer, Integer> coor;
	public SelectPiece(Pair<Integer, Integer> coor) {
		this.coor = coor;
	}

	public void execute() {
		
		System.out.println(context.getPieceAtSquare(coor).generateMoves(context).toString());
	}

}
