package gui;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

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

        mainpanel = new JPanel(new GridBagLayout());
        toolBar = new ToolBar();
        board = new Board(game);
        GridBagConstraints toolbarConstraints = new GridBagConstraints();
        GridBagConstraints boardConstraints = new GridBagConstraints();
        toolbarConstraints.gridx = 0;
        toolbarConstraints.gridy = 0;
        toolbarConstraints.gridwidth = 100;
        toolbarConstraints.gridheight = 100;

        boardConstraints.gridx = 0;
        boardConstraints.gridy = 220;
        boardConstraints.gridwidth = mainpanel.getWidth();
        boardConstraints.gridheight = mainpanel.getHeight();
        // mainpanel.add(toolBar, toolbarConstraints);
        mainpanel.add(board, boardConstraints);

        setContentPane(mainpanel);
        setVisible(true);
    }

	public Board getBoard() {
		return board;
	}
}
