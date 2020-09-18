package pieces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class King extends Piece {
	public static final ArrayList<Pair<Integer, Integer>> moves = new ArrayList<Pair<Integer, Integer>>(List.of(
			new Pair<Integer, Integer>(1, 0), 
			new Pair<Integer, Integer>(1, 1), 
			new Pair<Integer, Integer>(0, 1),
			new Pair<Integer, Integer>(-1, 1), 
			new Pair<Integer, Integer>(-1, 0), 
			new Pair<Integer, Integer>(-1, -1),
			new Pair<Integer, Integer>(0, -1), 
			new Pair<Integer, Integer>(1, -1)));

	public King(Boolean isWhite, Pair<Integer, Integer> position) {
		this.isWhite = isWhite;
		this.position = position;
	}

	public ArrayList<Move> generateMoves(Game game) {
		ArrayList<Move> generatedMoves = new ArrayList<Move>();

		for (Pair<Integer, Integer> move : moves) {
			Pair<Integer, Integer> attempt = this.position.addPair(move);
			if(Move.isOutOfBounds(attempt)){
				continue;
			}
			if (!this.validateMove(game, new Move(new Pair<Integer, Integer>(this.position.getFirst(), this.position.getSecond()), new Pair<Integer, Integer>(attempt.getFirst(), attempt.getSecond())))) {
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

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_king.png");
		} else {
			return new ImageIcon("img/black_king.png");
		}
	}
}