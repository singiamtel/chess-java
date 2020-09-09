import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Dimension;

public class Square extends JPanel {

	private static final long serialVersionUID = 2642336035089268095L;

	Boolean isWhite;
	Boolean isCheck;
	Boolean isEatable;
	Pieces piece;

	JLayeredPane stack;

	JLabel squareLabel;
	JLabel moveLabel;
	JLabel checkLabel;
	JLabel pieceLabel;

	Square(Boolean isWhite,Pieces piece,Boolean canMove,Boolean isCheck, Boolean canEat) {
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
		
		switch (piece){
			case BLACK_ROOK:
				pieceImage = new ImageIcon("img/black_rook.png");
				break;
			case BLACK_KNIGHT:
				pieceImage = new ImageIcon("img/black_knight.png");
				break;
			case BLACK_BISHOP:
				pieceImage = new ImageIcon("img/black_bishop.png");
				break;
			case BLACK_QUEEN:
				pieceImage = new ImageIcon("img/black_queen.png");
				break;
			case BLACK_KING:
				pieceImage = new ImageIcon("img/black_king.png");
				break;
			case BLACK_PAWN:
				pieceImage = new ImageIcon("img/black_pawn.png");
				break;
			case WHITE_ROOK:
				pieceImage = new ImageIcon("img/white_rook.png");
				break;
			case WHITE_KNIGHT:
				pieceImage = new ImageIcon("img/white_knight.png");
				break;
			case WHITE_BISHOP:
				pieceImage = new ImageIcon("img/white_bishop.png");
				break;
			case WHITE_QUEEN:
				pieceImage = new ImageIcon("img/white_queen.png");
				break;
			case WHITE_KING:
				pieceImage = new ImageIcon("img/white_king.png");
				break;
			case WHITE_PAWN:
				pieceImage = new ImageIcon("img/white_pawn.png");
				break;
			default:
				pieceImage = new ImageIcon("img/white_pawn.png");
				break;
		}

		pieceLabel = new JLabel(pieceImage);
		pieceLabel.setBounds(0, 0, pieceImage.getIconWidth(), pieceImage.getIconHeight());

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

		stack.add(pieceLabel);

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
