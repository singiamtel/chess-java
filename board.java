import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class board extends JPanel{

    private static final long serialVersionUID = 5071359096090410155L;

    private JButton[][] squares = new JButton[8][8];
    private void initUI(){
    }
    board(){
        this.setLayout(new GridLayout(8,8));
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                // White squares are even, black squares are odd
                squares[i][j] = new square((i+j) % 2 ==0 ? true:false) ;
                System.out.println("square");
                this.add(squares[i][j]);
            }
        }
    }
}