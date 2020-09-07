import javax.swing.JButton;
import javax.swing.ImageIcon;

public class square extends JButton{

    private static final long serialVersionUID = 2642336035089268095L;

    Boolean isWhite;
    ImageIcon image;
    public void initUI(){
    }
    square(Boolean isWhite){
        if(isWhite){
            this.image = new ImageIcon("/home/sergio/Desktop/iu.png");
            this.isWhite = true;
        }
        else {
            this.image = new ImageIcon("/home/sergio/Desktop/iu2.png");
            this.isWhite = false;
        }
        this.setIcon(image);
    }
}