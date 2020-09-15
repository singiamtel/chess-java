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
		this.position= position;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public abstract ArrayList<Move> generateMoves(Game game);

	public ImageIcon getImage() {
		return null;
	}
}
