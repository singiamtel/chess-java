public class Move {
	private int from;
	private int to;

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
