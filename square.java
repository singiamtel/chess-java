import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;


public class square extends JPanel{

    private static final long serialVersionUID = 2642336035089268095L;

    Boolean isWhite;
    Boolean isCheck;
    Boolean isEatable;
	Pieces piece;
    ImageIcon image;

	JLayeredPane stack;

	JButton cosa;

	JLabel squarelabel;
	JLabel modlabel;
	JLabel pieceLabel;

    square(Boolean isWhite){
		squarelabel = new JLabel();
		stack = new JLayeredPane();
		image = new ImageIcon("img/white_tile_wood.png");
		cosa = new JButton(image);

		squarelabel.setIcon(image);
		stack.add(cosa,new Integer(0));
        //if(isWhite){
        //    this.add(image,0);
        //    this.isWhite = true;
        //}
        //else {
        //    //this.image = new ImageIcon("");
        //    this.isWhite = false;
        //}
//        this.setIcon(image);
    }

	void updateCheck(){
		if(this.piece == Pieces.KING){

		}
	}
	void updateEatable(){

	}
}
