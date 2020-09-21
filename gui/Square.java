package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import pieces.Piece;
import utilities.Pair;

public class Square extends JPanel {

	private static final long serialVersionUID = 2642336035089268095L;

	private Boolean isWhite;
	private Boolean isCheck;
	private Boolean isEatable;
	private Boolean isMovable;

	private Piece piece;
	private Pair<Integer, Integer> position;

	private JLayeredPane stack;

	private JButton squareLabel;
	private JLabel moveLabel;
	private JLabel checkLabel;
	private JLabel pieceLabel;

	public Square() {
	}

	public Square(Boolean isWhite, Piece piece, Boolean canMove, Boolean isCheck, Boolean canEat,
			Pair<Integer, Integer> position) {
		this.position = position;

		this.isWhite = isWhite;
		this.isMovable = canMove;
		this.isCheck = isCheck;
		this.isEatable = canEat;
		this.piece = piece;

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

		squareLabel = new JButton(squareImage);
		squareLabel.setBounds(0, 0, squareImage.getIconWidth(), squareImage.getIconHeight());
		squareLabel.setBorderPainted(false);
		squareLabel.setFocusPainted(false);
		squareLabel.setContentAreaFilled(false);

		if (canEat || canMove) {
			if (canEat) {
				moveImage = new ImageIcon("img/can_eat.png");
			} else {
				moveImage = new ImageIcon("img/can_move_here.png");
			}
			moveLabel = new JLabel(moveImage);
			moveLabel.setBounds(0, 0, moveImage.getIconWidth(), moveImage.getIconHeight());
			stack.add(moveLabel);
		}

		if (piece != null) {
			pieceImage = piece.getImage();
			pieceLabel = new JLabel(pieceImage);
			pieceLabel.setBounds(0, 0, pieceImage.getIconWidth(), pieceImage.getIconHeight());
			stack.add(pieceLabel);

			// pieceLabel.setDragEnabled(true);
		}

		if (isCheck) {
			if (isWhite) {
				checkImage = new ImageIcon("img/king_threatened_white.png");
			} else {
				checkImage = new ImageIcon("img/king_threatened_black.png");
			}
			checkLabel = new JLabel(checkImage);
			checkLabel.setBounds(0, 0, checkImage.getIconWidth(), checkImage.getIconHeight());
			stack.add(checkLabel);
		}


		squareLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameController.getCurrent().handleClick(getPosition());
			}
		});
		stack.add(squareLabel);

		this.add(stack);

		// this.setIcon(image);
	}

	public Boolean isWhite() {
		return isWhite;
	}

	public Piece getPiece() {
		return piece;
	}

	public boolean isMoveable() {
		return isMovable;
	}

	public boolean canMoveHere() {
		return this.isEatable || this.isMoveable();
	}

	public void updateMoveable() {
		this.setVisible(false);
		moveLabel = new JLabel(new ImageIcon("img/can_move_here.png"));
		this.revalidate();
		this.repaint();
	}

	public Pair<Integer, Integer> getPosition() {
		return position;
	}

	public void setPosition(Pair<Integer, Integer> position) {
		this.position = position;
	}

	public void setPiece(Piece newPiece) {
		if (newPiece != null) {
			ImageIcon pieceImage = newPiece.getImage();
			pieceLabel = new JLabel(pieceImage);
			pieceLabel.setBounds(0, 0, pieceImage.getIconWidth(), pieceImage.getIconHeight());
		}
		this.piece = newPiece;
	}

	public void repaintSquare() {
		this.removeAll();
		stack.removeAll();
		if (isCheck || isEatable) {
			stack.add(moveLabel);
		}
		if (piece != null) {
			stack.add(pieceLabel);
		}
		if (isCheck) {
			stack.add(checkLabel);
		}
		// pieceLabel.setBounds(0, 0, pieceImage.getIconWidth(),
		// pieceImage.getIconHeight());
		stack.add(squareLabel);
		this.add(stack);
	}

	public boolean clear() {
		if(isEatable || isMovable){
			isEatable = false;
			isMovable = false;
			this.repaintSquare();
			return true;
		}
		return false;
	}

}