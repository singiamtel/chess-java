package pieces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class Knight extends Piece {

	public static final ArrayList<Pair> moves = new ArrayList<Pair>(List.of(
			new Pair(1, 2),
			new Pair(1, -2), 
			new Pair(2, 1), 
			new Pair(2, -1), 
			new Pair(-1, 2), 
			new Pair(-1, -2),
			new Pair(-2, 1), 
			new Pair(-2, -1)));

	public Knight(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position = position;
	}

	public Piece clonePiece(){
		Piece ret = new Knight(this.isWhite, new Pair(this.position));
		return ret;
	}


	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_knight.png");
		} else {
			return new ImageIcon("img/black_knight.png");
		}
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
				if (this.isMoveEating(game, new Move(this.position, attempt))) {
					generatedMoves.add(new Move(this.position, attempt, null, false, true));
				} else {
					generatedMoves.add(new Move(this.position, attempt, null, false, false));
				}
			}

		}

		return generatedMoves;
	}
}
/*
 * -17 -15 -10 -6 +6 +10 +15 +17
 * 
 * (2,1)(2,-1) (1,2)(-1,2) (-2,1)(-2,-1) (1,-2)(-1,-2)
 */