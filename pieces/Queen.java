package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Direction;
import utilities.Pair;
import utilities.Raycast;

public class Queen extends Piece {

	public Queen(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position= position;
	}

	public Piece clonePiece() {
		Piece ret = new Queen(this.isWhite, new Pair(this.position));
		return ret;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_queen.png");
		} else {
			return new ImageIcon("img/black_queen.png");
		}
	}
	public ArrayList<Move> generateMoves(Game game, boolean fake){
		ArrayList<Move> moves = new ArrayList<Move>();
		for (Direction direction : Direction.values()) {
			moves.addAll(Raycast.raycast(game, this, direction));
		}
		return moves;
	}
}
