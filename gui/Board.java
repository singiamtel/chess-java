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
						false, false, new Pair(i, j));
				this.add(squares[i][j]);
			}
		}
	}

	public void clearMoveMarks(){
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(squares[i][j].clear()) flag=true;
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

	public void makeMove(Move move) {
		Piece piece = squares[move.getFrom().getFirst()][move.getFrom().getSecond()].getPiece();

		Square squareFrom = squares[move.getFrom().getFirst()][move.getFrom().getSecond()];
		Square squareTo = squares[move.getTo().getFirst()][move.getTo().getSecond()];
		squareFrom.setPiece(null);
		squareTo.setPiece(piece);
		
		squareFrom.repaintSquare();
		squareTo.repaintSquare();
		
		repaintBoard();

	}
}
