package pieces;

import javax.swing.ImageIcon;

public class Bishop extends Piece {

	public Bishop(Boolean isWhite, int LERF) {
		this.isWhite = isWhite;
		this.positionLERF = LERF;
	}

	public ImageIcon getImage() {

		if (isWhite) {
			return new ImageIcon("img/white_bishop.png");
		} else {
			return new ImageIcon("img/black_bishop.png");
		}
	}
}
