package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Direction;
import utilities.Pair;
import utilities.Raycast;

public class Rook extends Piece {

	public Rook(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position= position;
	}

	public Piece clonePiece() {
		Piece ret = new Rook(this.isWhite, new Pair(this.position));
		return ret;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_rook.png");
		} else {
			return new ImageIcon("img/black_rook.png");
		}
	}

	public ArrayList<Move> generateMoves(Game game, boolean fake){
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.addAll(Raycast.raycast(game, this, Direction.EAST));
		moves.addAll(Raycast.raycast(game, this, Direction.WEST));
		moves.addAll(Raycast.raycast(game, this, Direction.NORTH));
		moves.addAll(Raycast.raycast(game, this, Direction.SOUTH));
		return moves;
	}
}
