package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Game;


public class MainWindow extends JFrame{
    private JPanel mainpanel;
    private JPanel toolBar;
    private Board board;

    private static final long serialVersionUID = -1049840817772719800L;

    public MainWindow(Game game) {
        setTitle("Chess-java");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // TODO: Fullscreen 
        setSize(1000,1000);

        JPanel mainpanel = new JPanel(new BorderLayout());
        JPanel toolBar = new ToolBar();
        board = new Board(game);

        mainpanel.add(toolBar, BorderLayout.NORTH);
        mainpanel.add(board, BorderLayout.CENTER);

        setContentPane(mainpanel);
        setVisible(true);
    }

	public Board getBoard() {
		return board;
	}
}
