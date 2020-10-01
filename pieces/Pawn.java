package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import controller.Move.promotions;
import gui.GameController;
import utilities.Pair;

public class Pawn extends Piece {

	public Pawn(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position = position;
	}

	public Piece clonePiece() {
		Piece ret = new Pawn(this.isWhite, new Pair(this.position));
		return ret;
	}

	public ArrayList<Move> generateMoves(Game game) {
		ArrayList<Move> moves = new ArrayList<Move>();
		Piece piece;
		if(GameController.getCurrent().getEnPassant() != null) {
			
		}
		if (isWhite()) {
			// Attempt to move one square
			piece = game.getPieceAtSquare(new Pair(position.getFirst() + 1, position.getSecond()));
			if (piece == null) {
				if(this.position.getFirst() == 7) {
					addPromotionMoves(game, moves);
				}else {
				moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
						new Pair(position.getFirst() + 1, position.getSecond())));
				}

				if (position.getFirst() == 1) {
					// Attempt to move two squares
					piece = game.getPieceAtSquare(
							new Pair(position.getFirst() + 2, position.getSecond()));
					if (piece == null) {
						moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
								new Pair(position.getFirst() + 2, position.getSecond())));
					}
				}
			}
			// Right
			if (position.getSecond() + 1 < 8) {
				piece = game.getPieceAtSquare(
						new Pair(position.getFirst() + 1, position.getSecond() + 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
							new Pair(position.getFirst() + 1, position.getSecond() + 1)));
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
				}
			}

			// Left
			if (position.getSecond() - 1 >= 0) {
				piece = game.getPieceAtSquare(
						new Pair(position.getFirst() + 1, position.getSecond() - 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
							new Pair(position.getFirst() + 1, position.getSecond() - 1)));
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
				}
				
			}

		} else {
			// Attempt to move one square
			piece = game.getPieceAtSquare(new Pair(position.getFirst() - 1, position.getSecond()));
			if (piece == null) {
				if(this.position.getFirst() == 1) {
					addPromotionMoves(game, moves);
				}else {
				moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
						new Pair(position.getFirst() - 1, position.getSecond())));
				}
				if (position.getFirst() == 6) {
					// Attempt to move two squares
					piece = game.getPieceAtSquare(
							new Pair(position.getFirst() - 2, position.getSecond()));
					if (piece == null) {
						moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
								new Pair(position.getFirst() - 2, position.getSecond())));
					}
				}
			}
			// Right
			if(position.getSecond() + 1 < 8){
				piece = game.getPieceAtSquare(
						new Pair(position.getFirst() - 1, position.getSecond() + 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
							new Pair(position.getFirst() - 1, position.getSecond() + 1)));
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
				}
			}

			// Left
			if(position.getSecond() - 1 >= 0){
				piece = game.getPieceAtSquare(
						new Pair(position.getFirst() - 1, position.getSecond() - 1));
				if (piece != null && piece.isWhite() != this.isWhite()) {
					moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
							new Pair(position.getFirst() - 1, position.getSecond() - 1)));
				}else if(GameController.getCurrent().getEnPassant() != null) {
					if(GameController.getCurrent().getEnPassant().getFirst() == piece.getPosition().getFirst() &&
							GameController.getCurrent().getEnPassant().getSecond() == piece.getPosition().getSecond()) {
						moves.add(new Move(new Pair(position.getFirst(), position.getSecond()),
								GameController.getCurrent().getEnPassant()));
					}
				}
			}
		}
		return moves;
	}
	public void addPromotionMoves(Game game, ArrayList<Move> moves) {
		for (Move.promotions promotion : Move.promotions.values()) {
			moves.add(new Move(this.getPosition(), new Pair(this.getPosition().getFirst()+1,this.getPosition().getSecond()),promotion));
		}
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_pawn.png");
		} else {
			return new ImageIcon("img/black_pawn.png");
		}
	}
}
