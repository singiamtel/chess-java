package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Move;
import controller.Move.promotions;

public class PromotionPopUp extends JFrame {

	private static final long serialVersionUID = 1L;

	private Move.promotions promotion;
		
	private JPanel promotionPanel;
	private JButton queenPromotion;
	private JButton rookPromotion;
	private JButton bishopPromotion;
	private JButton knightPromotion;
	
	public PromotionPopUp() {
		promotionPanel = new JPanel();
		add(promotionPanel);
		promotionPanel.setLayout(new FlowLayout());
		
		queenPromotion = new JButton("Queen");
		rookPromotion= new JButton("Rook");
		bishopPromotion= new JButton("Bishop");
		knightPromotion = new JButton("Knight");
		
		promotionPanel.add(queenPromotion);
		promotionPanel.add(knightPromotion);
		promotionPanel.add(bishopPromotion);
		promotionPanel.add(rookPromotion);
		
		queenPromotion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				promotion = promotions.QUEEN;
			}
		});
		
		rookPromotion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				promotion = promotions.ROOK;
			}
		});
		
		bishopPromotion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				promotion = promotions.BISHOP;
			}
		});
		
		knightPromotion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				promotion = promotions.KNIGHT;	
			}
		});
	
		
	}
	public void setPromotion() {
		this.setVisible(true);
		GameController.getCurrent().getGame().setPromotion(promotion);;
	}
}
