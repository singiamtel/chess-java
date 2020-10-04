package pieces;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class noPiece extends Piece{
	public noPiece(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position= position;
	}


	public Piece clonePiece(){
		Piece ret = new noPiece(this.isWhite, new Pair(this.position));
		return ret;
	}
	@Override
	public ArrayList<Move> generateMoves(Game game, boolean fake) {
		return null;
	}
	
}
