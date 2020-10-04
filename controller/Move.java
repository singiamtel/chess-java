package controller;

import utilities.Pair;

public class Move {
	private Pair from;
	private Pair to;
	private promotions promotion;
	private boolean enPassant;
	private boolean makesEnPassant;


	public static enum promotions{
		BISHOP,
		KNIGHT,
		ROOK,
		QUEEN
	}

	private boolean castle;
	private boolean isEating;
	private boolean check;

	public boolean isCheck() {
		return this.check;
	}

	public Move(Pair from, Pair to){
		this.from = from;
		this.to = to;
	}

	public Move(Pair from, Pair to, boolean isEating){
		this.from = from;
		this.to = to;
		this.isEating = isEating;
	}
	
	public Move(Pair from, Pair to, promotions promotion){
		this.from = from;
		this.to = to;
		this.promotion = promotion;
	}
	
	public Pair getFrom() {
		return this.from;
	}

	public Move(Pair from, Pair to, promotions promotion, Boolean castle, boolean isEating) {
		this.from = from;
		this.to = to;
		this.promotion = promotion;
		this.castle = castle;
		this.isEating = isEating;
	}

	public Move(Pair from, Pair to, promotions promotion, Boolean castle, boolean isEating, boolean enPassant, boolean makesEnPassant) {
		this.from = from;
		this.to = to;
		this.promotion = promotion;
		this.castle = castle;
		this.isEating = isEating;
		this.enPassant = enPassant;
		this.makesEnPassant = makesEnPassant;
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

	public static boolean isOutOfBounds(Pair pair){
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
	public boolean isEnPassant() {
		return this.enPassant;
	}
	public void setEnPassant(boolean enPassant) {
		this.enPassant = enPassant;
	}
	
	public boolean makesEnPassant() {
		return this.makesEnPassant;
	}

	public void setMakesEnPassant(boolean makesEnPassant) {
		this.makesEnPassant = makesEnPassant;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	public void setFrom(Pair from) {
		this.from = from;
	}

	public Pair getTo() {
		return this.to;
	}

	public void setTo(Pair to) {
		this.to = to;
	}

	public promotions getPromotion() {
		return this.promotion;
	}

	public void setPromotion(promotions promotion) {
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
	@Override
	public String toString(){
		return "Move@" + this.hashCode() + ": {(" + from.getFirst() + "," + from.getSecond() + "), (" + to.getFirst()
				+ "," + to.getSecond() + ")}";
	}
}