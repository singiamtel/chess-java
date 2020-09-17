package gui;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import controller.Game;
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
                        false, false);
                this.add(squares[i][j]);
            }
        }
    }
    public void repaint() {
    	this.removeAll();
    	 for (int i = 7; i >= 0; --i) {
             for (int j = 0; j < 8; ++j) {
                 this.add(squares[i][j]);
             }
         }
    }
    public Square getSquareAt( Pair<Integer, Integer> at){
    	return squares[at.getFirst()][at.getSecond()];
    }
	public void setSquareAt(Pair<Integer, Integer> at, Square square) {
		squares[at.getFirst()][at.getSecond()] = square;
	}     
}
