package pieces;

import javax.swing.ImageIcon;

public class Rook extends Piece {

	public Rook(Boolean isWhite, int LERF) {
		this.isWhite = isWhite;
		this.positionLERF = LERF;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_rook.png");
		} else {
			return new ImageIcon("img/black_rook.png");
		}
	}
}
