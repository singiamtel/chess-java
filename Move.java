public class Move {
	private int from;
	private int to;

	public Pieces getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Pieces promotion) {
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
	private Pieces promotion;
	private Boolean castle;
	// private bool eating;
	// private bool check;

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

	Move(int from, int to){
		this.setFrom(from);
		this.setTo(to);
	}
}
