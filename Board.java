import javax.swing.JPanel;
import java.awt.GridLayout;

public class Board extends JPanel{

    private static final long serialVersionUID = 5071359096090410155L;

    private JPanel[][] squares = new JPanel[8][8];
    // private void initUI(){
    // }
    Board(){
        this.setLayout(new GridLayout(8,8));
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                // White squares are even, black squares are odd
                squares[i][j] = new Square((i+j) % 2 ==0 ? true:false,Pieces.WHITE_KING,true,true,true);
                this.add(squares[i][j]);
            }
        }
    }
}
