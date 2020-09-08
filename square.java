import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Dimension;

public class square extends JPanel {

	private static final long serialVersionUID = 2642336035089268095L;

	Boolean isWhite;
	Boolean isCheck;
	Boolean isEatable;
	Pieces piece;

	JLayeredPane stack;

	JLabel squareLabel;
	JLabel modLabel;
	JLabel pieceLabel;

	square(Boolean isWhite) {
		this.stack = new JLayeredPane();
		stack.setPreferredSize(new Dimension(110, 110));

		ImageIcon image;
		ImageIcon imagetwo;
		if (isWhite) {
			this.isWhite = true;
			image = new ImageIcon("img/white_tile_wood.png");
		} else {
			this.isWhite = false;
			image = new ImageIcon("img/black_tile_wood.png");
		}

		squareLabel = new JLabel(image);
		squareLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		imagetwo = new ImageIcon("img/black_queen.png");

		modLabel = new JLabel(imagetwo);
		modLabel.setBounds(0, 0, imagetwo.getIconWidth(), imagetwo.getIconHeight());
		// System.out.println("x");

		stack.add(modLabel);
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
