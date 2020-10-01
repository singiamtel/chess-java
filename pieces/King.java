package pieces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class King extends Piece {
	public static final ArrayList<Pair> moves = new ArrayList<Pair>(List.of(
			new Pair(1, 0), 
			new Pair(1, 1), 
			new Pair(0, 1),
			new Pair(-1, 1), 
			new Pair(-1, 0), 
			new Pair(-1, -1),
			new Pair(0, -1), 
			new Pair(1, -1)));

	public King(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position = position;
	}
	public Piece clonePiece(){
		Piece ret = new King(this.isWhite, new Pair(this.position));
		return ret;
	}

	public ArrayList<Move> generateMoves(Game game) {
		ArrayList<Move> generatedMoves = new ArrayList<Move>();

		for (Pair move : moves) {
			Pair attempt = this.position.addPair(move);
			if(Move.isOutOfBounds(attempt)){
				continue;
			}
			if (!this.validateMove(game, new Move(new Pair(this.position.getFirst(), this.position.getSecond()), new Pair(attempt.getFirst(), attempt.getSecond())))) {
				continue;
			} else {
				if (game.isMoveEating(new Move(this.position, attempt))) {
					generatedMoves.add(new Move(this.position, attempt, null, false, true));
				} else {
					generatedMoves.add(new Move(this.position, attempt, null, false, false));
				}
			}

		}

		return generatedMoves;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_king.png");
		} else {
			return new ImageIcon("img/black_king.png");
		}
	}
}