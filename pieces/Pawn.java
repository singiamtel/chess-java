package pieces;

import javax.swing.ImageIcon;

import utilities.Pair;

public class Pawn extends Piece {

	public Pawn(Boolean isWhite, Pair<Integer, Integer> position){
		this.isWhite = isWhite;
		this.position= position;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_pawn.png");
		} else {
			return new ImageIcon("img/black_pawn.png");
		}
	}
}
