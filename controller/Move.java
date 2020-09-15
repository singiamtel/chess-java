package controller;

import pieces.Piece;
import utilities.Pair;

public class Move {
	private Pair<Integer, Integer> fromTo;
	private Piece promotion;

	private Boolean castle;
	private boolean isEating;
	// private bool check;

	public Move(int from, int to) {
		this.fromTo = new Pair<Integer, Integer>(from, to);
	}

	public Move(Pair<Integer, Integer> fromTo) {
		this.fromTo = fromTo;
	}

	public Move(Pair<Integer,Integer> fromTo, Piece promotion, Boolean castle, boolean isEating) {
		this.fromTo = fromTo;
		this.promotion = promotion;
		this.castle = castle;
		this.isEating = isEating;
	}

	public Pair<Integer,Integer> getFromTo() {
		return this.fromTo;
	}

	public Piece getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Piece promotion) {
		this.promotion = promotion;
	}
	public int getFrom(){
		return this.fromTo.getFirst();
	}
	public int getTo(){
		return this.fromTo.getSecond();

	}

	public void setFromTo(Pair<Integer,Integer> fromTo) {
		this.fromTo = fromTo;
	}

	public boolean isEating() {
		return this.isEating;
	}

	public boolean getIsEating() {
		return this.isEating;
	}


	public Move fromTo(Pair<Integer,Integer> fromTo) {
		this.fromTo = fromTo;
		return this;
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

	public void setIsEating(boolean isEating) {
		this.isEating = isEating;
	}
}