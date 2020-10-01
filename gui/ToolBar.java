package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel{
	private static final long serialVersionUID = -78930801111296287L;
	JButton button;
	public ToolBar(){
	
		button = new JButton("click me");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PromotionPopUp promotionPopUp = new PromotionPopUp();
				promotionPopUp.setPromotion();
			}
		});
		add(button);
	}
}