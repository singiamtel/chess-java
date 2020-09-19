package gui;

import java.awt.GridLayout;

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
				// White squares are odd, black squares are even // TODO: sure?
				squares[i][j] = new Square((i + j) % 2 == 0 ? false : true, game.getPieceAtSquare(8 * i + j), false,
						false, false, new Pair<Integer, Integer>(i, j));
				this.add(squares[i][j]);
			}
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

	public Square getSquareAt(Pair<Integer, Integer> at) {
		return squares[at.getFirst()][at.getSecond()];
	}

	public void setSquareAt(Pair<Integer, Integer> at, Square square) {
		squares[at.getFirst()][at.getSecond()] = square;
		repaintBoard();
	}

	public void makeMove(Move move) {
		// Square to = squares[move.getFrom().getFirst()][move.getFrom().getSecond()];
		// Square from = new Square(to.isWhite(), null, false, false, false,to.getPosition());
		// squares[move.getTo().getFirst()][move.getTo().getSecond()] = to;
		// squares[move.getFrom().getFirst()][move.getFrom().getSecond()] = from;

		Piece piece = squares[move.getFrom().getFirst()][move.getFrom().getSecond()].getPiece();
		if(piece != null) System.out.println("piece: " + piece.toString());
		squares[move.getFrom().getFirst()][move.getFrom().getSecond()].setPiece(null);
		squares[move.getTo().getFirst()][move.getTo().getSecond()].setPiece(piece);
		
		squares[move.getFrom().getFirst()][move.getFrom().getSecond()].repaintSquare();
		squares[move.getTo().getFirst()][move.getTo().getSecond()].repaintSquare();
		
		repaintBoard();

	}
}
