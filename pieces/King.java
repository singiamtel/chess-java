package pieces;

import javax.swing.ImageIcon;

public class King extends Piece {
	public King(Boolean isWhite, int LERF) {
		this.isWhite = isWhite;
		this.positionLERF = LERF;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_king.png");
		} else {
			return new ImageIcon("img/black_king.png");
		}
	}
}