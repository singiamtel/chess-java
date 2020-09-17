package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class Pawn extends Piece {

	public Pawn(Boolean isWhite, Pair<Integer, Integer> position) {
		this.isWhite = isWhite;
		this.position = position;
	}

	public ArrayList<Move> generateMoves(Game game) {
		ArrayList<Move> moves = new ArrayList<Move>();
		Piece piece;
		if (isWhite()) {
			// Attempt to move one square
			piece = game.getPieceAtSquare(new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond()));
			if (piece == null) {
				moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
						new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond())));

				if (position.getFirst() == 1) {
					// Attempt to move two squares
					piece = game.getPieceAtSquare(
							new Pair<Integer, Integer>(position.getFirst() + 2, position.getSecond()));
					if (piece == null) {
						moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
								new Pair<Integer, Integer>(position.getFirst() + 2, position.getSecond())));

					}
				}
			}
			// Right
			if (position.getSecond() + 1 < 8) {
				piece = game.getPieceAtSquare(
						new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond() + 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
							new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond() + 1)));
				}
			}

			// Left
			if (position.getSecond() - 1 >= 0) {
				piece = game.getPieceAtSquare(
						new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond() - 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
							new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond() - 1)));
				}
			}

		} else {
			// Attempt to move one square
			piece = game.getPieceAtSquare(new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond()));
			if (piece == null) {
				moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
						new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond())));

				if (position.getFirst() == 6) {
					// Attempt to move two squares
					piece = game.getPieceAtSquare(
							new Pair<Integer, Integer>(position.getFirst() - 2, position.getSecond()));
					if (piece == null) {
						moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
								new Pair<Integer, Integer>(position.getFirst() - 2, position.getSecond())));

					}
				}
			}
			// Right
			if(position.getSecond() + 1 < 8){
				piece = game.getPieceAtSquare(
						new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond() + 1));
				System.out.println(piece);
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
							new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond() + 1)));
				}
			}

			// Left
			if(position.getSecond() - 1 >= 0){
				piece = game.getPieceAtSquare(
						new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond() - 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
							new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond() - 1)));
				}
			}
		}
		return moves;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_pawn.png");
		} else {
			return new ImageIcon("img/black_pawn.png");
		}
	}
}
