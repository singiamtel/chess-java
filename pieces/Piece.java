package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Pair;

public abstract class Piece {
	protected boolean isWhite;
	protected Pair<Integer, Integer> position;
	protected ImageIcon image;

	public boolean isWhite() {
		return this.isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}

	public void setPosition(Pair<Integer, Integer> position) {
		this.position = position;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public abstract ArrayList<Move> generateMoves(Game game);

	public ImageIcon getImage() {
		return null;
	}

	public boolean validateMove(Game game, Move move) {
		if (move.getFrom() < 0 || move.getFrom() >= 8 || move.getTo() < 0 || move.getTo() >= 8) {
			return false;
		} else if (game.getPieceAtSquare(move.getTo()) == null) {
			return true;
		} else if (game.getPieceAtSquare(move.getTo()).isWhite() != this.isWhite()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isMoveEating(Game game, Move move) {
		if(game.getPieceAtSquare(move.getTo()) == null){
			return false;
		}
		if (game.getPieceAtSquare(move.getTo()).isWhite() != this.isWhite()) {
			return true;
		}
		else {
			return false;
		}
	}
}
