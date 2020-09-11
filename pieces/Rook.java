package pieces;

import javax.swing.ImageIcon;

public class Rook extends Piece{
public ImageIcon getImage() {
	if(isWhite) {
		return new ImageIcon("img/white_rook.png");
	}else {
		return new ImageIcon("img/black_rook.png");
	}
	}
}
