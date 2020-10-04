package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ToolBar extends JPanel{
	private static final long serialVersionUID = -78930801111296287L;
	JButton button;
	public ToolBar(){
	
		button = new JButton("click me");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("THANKS");
			}
		});
		add(button);
	}
}