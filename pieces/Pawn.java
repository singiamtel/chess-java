package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.text.Position;

import controller.Game;
import controller.Move;
import gui.GameController;
import utilities.Pair;

public class Pawn extends Piece {

	public Pawn(Boolean isWhite, Pair<Integer, Integer> position) {
		this.isWhite = isWhite;
		this.position = position;
	}

	public ArrayList<Move> generateMoves(Game game) {
		ArrayList<Move> moves = new ArrayList<Move>();
		Piece piece;
		if(GameController.getCurrent().getEnPassant() != null) {
			
		}
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
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
				}
			}

			// Left
			if (position.getSecond() - 1 >= 0) {
				piece = game.getPieceAtSquare(
						new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond() - 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
							new Pair<Integer, Integer>(position.getFirst() + 1, position.getSecond() - 1)));
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
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
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
							new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond() + 1)));
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
				}
			}

			// Left
			if(position.getSecond() - 1 >= 0){
				piece = game.getPieceAtSquare(
						new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond() - 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
							new Pair<Integer, Integer>(position.getFirst() - 1, position.getSecond() - 1)));
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair<Integer, Integer>(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
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
