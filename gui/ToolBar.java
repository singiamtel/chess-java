package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel{
	private static final long serialVersionUID = -78930801111296287L;
	JButton button;
	ToolBar(){
		button = new JButton("click me");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("THX");
			}
		});
		add(button);
	}
}