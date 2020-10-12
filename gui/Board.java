package gui;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;

import controller.Game;
import controller.Move;
import pieces.Piece;
import utilities.Pair;

public class Board extends JPanel {

	private static final long serialVersionUID = 5071359096090410155L;

	private Square[][] squares = new Square[8][8];

	public Board(Game game) {
		this.setLayout(new GridLayout(8, 8));
		for (int i = 7; i >= 0; --i) {
			for (int j = 0; j < 8; ++j) {
				// White squares are odd, black squares are even
				squares[i][j] = new Square((i + j) % 2 == 0 ? false : true, game.getPieceAtSquare(8 * i + j), false,
						false, false, new Pair(i, j));
				this.add(squares[i][j]);
			}
		}
	}

	public void clearMoveMarks() {
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (squares[i][j].clear())
					flag = true;
			}
		}
		if (flag) {
			this.repaintBoard();
		}
	}

	public void repaintBoard() {
		this.removeAll();
		for (int i = 7; i >= 0; --i) {
			for (int j = 0; j < 8; ++j) {
				this.add(squares[i][j]);
			}
		}
		this.revalidate();
		this.repaint();
	}

	public Square getSquareAt(Pair at) {
		return squares[at.getFirst()][at.getSecond()];
	}

	public void setSquareAt(Pair at, Square square) {
		squares[at.getFirst()][at.getSecond()] = square;
		repaintBoard();
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d = super.getPreferredSize();
		Container c = getParent();
		if (c != null) {
			d = c.getSize();
		} else {
			return new Dimension(10, 10);
		}
		int w = (int) d.getWidth();
		int h = (int) d.getHeight();
		int s = (w < h ? w : h);
		return new Dimension(s, s);
	}

	public void makeMove(Move move) {
		Piece piece = squares[move.getFrom().getFirst()][move.getFrom().getSecond()].getPiece();

		Square squareFrom = squares[move.getFrom().getFirst()][move.getFrom().getSecond()];
		Square squareTo = squares[move.getTo().getFirst()][move.getTo().getSecond()];
		squareFrom.setPiece(null);
		if(move.getEnPassant() != null) {
			Square enPassantSquare = squares[move.getEnPassant().getFirst()-1][move.getEnPassant().getSecond()];
			enPassantSquare.setPiece(null);
			enPassantSquare.repaintSquare();
		}
		if(move.getCastle()) {
			Game game = GameController.getCurrent().getGame();
			switch (move.getWhich()) {
			case WHITEKING:
				squares[0][5].setPiece(game.getPieceAtSquare(new Pair(0,5)));
				squares[0][7].setPiece(null);
				squares[0][7].repaintSquare();
				break;
			case WHITEQUEEN:
				squares[0][3].setPiece(game.getPieceAtSquare(new Pair(0,3)));
				squares[0][0].setPiece(null);
				squares[0][0].repaintSquare();
				break;
			case BLACKKING:
				squares[7][5].setPiece(game.getPieceAtSquare(new Pair(7,5)));
				squares[7][7].setPiece(null);
				squares[7][7].repaintSquare();
				break;
			case BLACKQUEEN:
				squares[7][3].setPiece(game.getPieceAtSquare(new Pair(7,3)));
				squares[7][0].setPiece(null);
				squares[7][0].repaintSquare();
				break;
			default:
				break;
			}
			
		}
		if(move.getPromotion() != null) {
			squareTo.setPiece(Game.makePromotion(move.getPromotion(),!GameController.getCurrent().getGame().whitePlays(),move.getTo()));
		}else {
			squareTo.setPiece(piece);
		}
		squareFrom.repaintSquare();
		squareTo.repaintSquare();
		
		repaintBoard();
		GameController.getCurrent().getGame().setPromotion(null);

	}
}
