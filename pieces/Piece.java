package pieces;

import javax.swing.ImageIcon;

public class Piece {
	protected boolean isWhite;
	protected int positionLERF;
	protected ImageIcon image;

	public boolean isWhite() {
		return this.isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public int getPositionLERF() {
		return this.positionLERF;
	}

	public void setPositionLERF(int positionLERF) {
		this.positionLERF = positionLERF;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public void generateMoves() {

	}

	public ImageIcon getImage() {
		return null;
	}
}
