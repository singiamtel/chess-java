import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;


public class square extends JLayeredPane{

    private static final long serialVersionUID = 2642336035089268095L;

    Boolean isWhite;
    Boolean isCheck;
    Boolean isEatable;
	Pieces piece;
    ImageIcon image;

	JPanel squarePanel;
	JPanel modPanel;
	JPanel piecePanel;

    public void initUI(){
    }
    square(Boolean isWhite){
        if(isWhite){
            //squarePanel.add(new ImageIcon("img/whiteTile.jpg"));
            this.isWhite = true;
        }
        else {
            //this.image = new ImageIcon("");
            this.isWhite = false;
        }
//        this.setIcon(image);
    }

	void updateCheck(){
		if(this.piece == Pieces.KING){

		}
	}
	void updateEatable(){

	}
}
