package pieces;

import javax.swing.ImageIcon;

public class Pawn extends Piece {

	public Pawn(Boolean isWhite, int LERF){
		this.isWhite = isWhite;
		this.positionLERF = LERF;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_pawn.png");
		} else {
			return new ImageIcon("img/black_pawn.png");
		}
	}
}
