package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Controller;


public class MainWindow extends JFrame{
    JPanel mainpanel;
    JPanel toolBar;
    Board board;

    private static final long serialVersionUID = -1049840817772719800L;

    private void initUI(Controller controller) {
        setTitle("Chess-java");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // TODO: Fullscreen 
        setSize(1000,1000);

        JPanel mainpanel = new JPanel(new BorderLayout());
        JPanel toolBar = new ToolBar();
        board = new Board(controller.getGame());
        mainpanel.add(toolBar, BorderLayout.NORTH);
        mainpanel.add(board, BorderLayout.CENTER);

        // toolbar.add(buttonchulo);

        setContentPane(mainpanel);
        setVisible(true);
    }

    public MainWindow(Controller controller){
        this.initUI(controller);
    }

	public Board getBoard() {
		return board;
		
	}
}
