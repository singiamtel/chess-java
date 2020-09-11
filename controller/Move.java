package controller;

import pieces.Piece;

public class Move {
	private int from;
	private int to;
	private Piece promotion;
	private Boolean castle;
	// private bool eating;
	// private bool check;

	public Piece getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Piece promotion) {
		this.promotion = promotion;
	}

	public Boolean isCastle() {
		return this.castle;
	}

	public Boolean getCastle() {
		return this.castle;
	}

	public void setCastle(Boolean castle) {
		this.castle = castle;
	}

	public int getFrom() {
		return this.from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return this.to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public Move(int from, int to, Piece promotion, Boolean castle){
		this.setFrom(from);
		this.setTo(to);
		this.promotion = promotion;
		this.castle = castle;
	}
}
