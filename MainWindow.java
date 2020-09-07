import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MainWindow extends JFrame{

    private static final long serialVersionUID = -1049840817772719800L;

    private void initUI() {
        setTitle("Chess-java");

        // TODO: Fullscreen 
        setSize(1000,1000);

        JPanel mainpanel = new JPanel(new BorderLayout());
        JPanel toolbar = new JPanel();
        JPanel board = new board();
        mainpanel.add(toolbar, BorderLayout.NORTH);
        mainpanel.add(board, BorderLayout.CENTER);

        // toolbar.add(buttonchulo);

        setContentPane(mainpanel);
        setVisible(true);
    }

    MainWindow(){
        this.initUI();
    }
}