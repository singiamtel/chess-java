package pieces;

import javax.swing.ImageIcon;

public class Queen extends Piece{
public ImageIcon getImage() {
	if(isWhite) {
		return new ImageIcon("img/white_queen.png");
	}else {
		return new ImageIcon("img/black_queen.png");
	}
	}
}
