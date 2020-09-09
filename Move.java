public class Move {
	private int from;
	private int to;
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
