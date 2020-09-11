package gui;

import pieces.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Dimension;

import pieces.*;

public class Square extends JPanel {

	private static final long serialVersionUID = 2642336035089268095L;

	Boolean isWhite;
	Boolean isCheck;
	Boolean isEatable;

	Piece piece;
	
	JLayeredPane stack;

	JLabel squareLabel;
	JLabel moveLabel;
	JLabel checkLabel;
	JButton pieceLabel;

	Square(Boolean isWhite,Piece piece,Boolean canMove,Boolean isCheck, Boolean canEat) {
		this.stack = new JLayeredPane();
		stack.setPreferredSize(new Dimension(110, 110));

		ImageIcon squareImage;
		ImageIcon pieceImage;
		ImageIcon checkImage;
		ImageIcon moveImage;

		if (isWhite) {
			this.isWhite = true;
			squareImage = new ImageIcon("img/white_tile_wood.png");
		} else {
			this.isWhite = false;
			squareImage = new ImageIcon("img/black_tile_wood.png");
		}

		squareLabel = new JLabel(squareImage);
		squareLabel.setBounds(0, 0, squareImage.getIconWidth(), squareImage.getIconHeight());

		if(canEat || canMove){
			if(canEat){
				moveImage= new ImageIcon("img/can_eat.png");
			}else{
				moveImage= new ImageIcon("img/can_move_here.png");
			}
			moveLabel = new JLabel(moveImage);
			moveLabel.setBounds(0, 0, moveImage.getIconWidth(), moveImage.getIconHeight());
			stack.add(moveLabel);
		}

		if (piece != null) {
			pieceImage = piece.getImage();
			pieceLabel = new JButton(pieceImage);
			pieceLabel.setBounds(0, 0, pieceImage.getIconWidth(), pieceImage.getIconHeight());
			stack.add(pieceLabel);

			pieceLabel.setBorderPainted(false);
			pieceLabel.setFocusPainted(false);
			pieceLabel.setContentAreaFilled(false);

			// pieceLabel.setDragEnabled(true);
		}




		if(isCheck){
			if(isWhite){
				checkImage= new ImageIcon("img/king_threatened_white.png");
			}else{
				checkImage= new ImageIcon("img/king_threatened_black.png");
			}
			checkLabel = new JLabel(checkImage);
			checkLabel.setBounds(0, 0, checkImage.getIconWidth(), checkImage.getIconHeight());
			stack.add(checkLabel);
		}
		
		stack.add(squareLabel);

		this.add(stack);

		// this.setIcon(image);
	}

	void updateCheck() {
		// if(this.piece == Pieces.KING){

		// }
	}

	void updateEatable() {

	}
}
