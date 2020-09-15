package pieces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class Knight extends Piece {

	public static final ArrayList<Pair<Integer, Integer>> moves = new ArrayList<Pair<Integer, Integer>>(List.of(
		new Pair<Integer, Integer>(2,1),
		new Pair<Integer, Integer>(2,-1),
		new Pair<Integer, Integer>(1,2),
		new Pair<Integer, Integer>(1,-2),
		new Pair<Integer, Integer>(-2,1),
		new Pair<Integer, Integer>(-2,-1),
		new Pair<Integer, Integer>(1,-2),
		new Pair<Integer, Integer>(-1,-2)
		));

	public Knight(Boolean isWhite, Pair<Integer, Integer> position) {
		this.isWhite = isWhite;
		this.position= position;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_knight.png");
		} else {
			return new ImageIcon("img/black_knight.png");
		}
	}
	public ArrayList<Move> generateMoves(Game game){
		ArrayList<Move> generatedMoves = new ArrayList<Move>();
		for (Pair<Integer, Integer> move : moves) {
			Pair<Integer, Integer> attempt = this.position.substractPair(move);
			if(! this.validateMove(game, new Move(attempt))){
				continue;
			} else {
				if (this.isMoveEating(game, new Move(attempt))) {
					generatedMoves.add(new Move(attempt, null, false, true));
				} else
					generatedMoves.add(new Move(attempt, null, false, false));
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