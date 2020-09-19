package pieces;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class noPiece extends Piece{
	public noPiece(Boolean isWhite, Pair<Integer, Integer> position) {
		this.isWhite = isWhite;
		this.position= position;
	}

	@Override
	public ArrayList<Move> generateMoves(Game game) {
		return null;
	}
	
}
