package pieces;

import javax.swing.ImageIcon;

public class Pawn extends Piece{
public ImageIcon getImage() {
	if(isWhite) {
		return new ImageIcon("img/white_pawn.png");
	}else {
		return new ImageIcon("img/black_pawn.png");
	}
	}
}
