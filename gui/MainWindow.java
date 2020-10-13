package gui;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Game;

public class MainWindow extends JFrame{
    private JPanel mainpanel;
    private Board board;

    private static final long serialVersionUID = -1049840817772719800L;

    public MainWindow(Game game) {
        setTitle("Chess-java");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,1000);

        mainpanel = new JPanel(new GridBagLayout());
        board = new Board(game);

        GridBagConstraints boardConstraints = new GridBagConstraints();

        boardConstraints.gridx = 0;
        boardConstraints.gridy = 220;
        boardConstraints.gridwidth = mainpanel.getWidth();
        boardConstraints.gridheight = mainpanel.getHeight();

        mainpanel.add(board, boardConstraints);

        setContentPane(mainpanel);
        setVisible(true);
    }

	public Board getBoard() {
		return board;
	}
}