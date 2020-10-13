package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Direction;
import utilities.Pair;
import utilities.Raycast;

public class Bishop extends Piece {

	public Bishop(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position= position;
	}
	public Piece clonePiece(){
		Piece ret = new Bishop(this.isWhite, new Pair(this.position));
		return ret;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_bishop.png");
		} else {
			return new ImageIcon("img/black_bishop.png");
		}
	}

	public ArrayList<Move> generateMoves(Game game, boolean fake){
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.addAll(Raycast.raycast(game, this, Direction.NORTHEAST));
		moves.addAll(Raycast.raycast(game, this, Direction.NORTHWEST));
		moves.addAll(Raycast.raycast(game, this, Direction.SOUTHEAST));
		moves.addAll(Raycast.raycast(game, this, Direction.SOUTHWEST));
		return moves;
	}
}
