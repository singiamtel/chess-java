package controller;

import pieces.Piece;
import utilities.Pair;

public class Move {
	private Pair<Integer, Integer> from;
	private Pair<Integer, Integer> to;
	private Piece promotion;

	private boolean castle;
	private boolean isEating;
	private boolean check;

	public boolean isCheck() {
		return this.check;
	}

	public Move(Pair<Integer, Integer> from, Pair<Integer, Integer> to){
		this.from = from;
		this.to = to;
	}
	public Pair<Integer,Integer> getFrom() {
		return this.from;
	}

	public Move(Pair<Integer,Integer> from, Pair<Integer,Integer> to, Piece promotion, Boolean castle, boolean isEating) {
		this.from = from;
		this.to = to;
		this.promotion = promotion;
		this.castle = castle;
		this.isEating = isEating;
	}

	public boolean isOutOfBounds(){
		if (this.to.getFirst() < 0 || this.to.getFirst() >= 8){
		return true;
		}
		if (this.to.getSecond() < 0 || this.to.getSecond() >= 8){
		return true;
		}
		return false;
	}
	public static boolean isOutOfBounds(Move move){
		if (move.getTo().getFirst() < 0 || move.getTo().getFirst() >= 8){
		return true;
		}
		if (move.getTo().getSecond() < 0 || move.getTo().getSecond() >= 8){
		return true;
		}
		return false;
	}

	public static boolean isOutOfBounds(Pair<Integer, Integer> pair){
		if (pair.getFirst() < 0 || pair.getFirst() >= 8){
		return true;
		}
		if (pair.getSecond() < 0 || pair.getSecond() >= 8){
		return true;
		}
		return false;
	}

	public boolean getCheck() {
		return this.check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	public void setFrom(Pair<Integer,Integer> from) {
		this.from = from;
	}

	public Pair<Integer,Integer> getTo() {
		return this.to;
	}

	public void setTo(Pair<Integer,Integer> to) {
		this.to = to;
	}

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

	public boolean isEating() {
		return this.isEating;
	}

	public void setIsEating(boolean isEating) {
		this.isEating = isEating;
	}
}