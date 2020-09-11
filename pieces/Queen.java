package pieces;

import javax.swing.ImageIcon;

public class Queen extends Piece {

	public Queen(Boolean isWhite, int LERF) {
		this.isWhite = isWhite;
		this.positionLERF = LERF;
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_queen.png");
		} else {
			return new ImageIcon("img/black_queen.png");
		}
	}
}
