package gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import controller.Game;
import pieces.King;

public class Board extends JPanel {

    private static final long serialVersionUID = 5071359096090410155L;

    private JPanel[][] squares = new JPanel[8][8];

    // private void initUI(){
    // }
    Board(Game game) {
        this.setLayout(new GridLayout(8, 8));
        for (int i = 7; i >= 0; --i) {
            for (int j = 0; j < 8; ++j) {
                // White squares are odd, black squares are even // TODO: sure?
                squares[i][j] = new Square((i + j) % 2 == 0 ? false : true, game.getPieceAtSquare(8 * i + j), false,
                        false, false);
                this.add(squares[i][j]);
            }
        }
        // for(int i=7; i>=0; --i){
        // for(int j=0; j<8; ++j){
        // // White squares are odd, black squares are even // TODO: sure?
        // squares[i][j] = new Square((i+j) % 2 ==0 ? false:true,new
        // King(),true,false,false);
        // this.add(squares[i][j]);
        // }
        // }
    }
}
