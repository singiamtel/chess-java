package utilities;

import java.util.Objects;

public class Pair {
	private int first;
	private int second;

	public Pair(Pair pair){
		this.first = pair.first;
		this.second = pair.second;
	}

	public Pair() {
	}

	public Pair addPair(Pair pair) {
		return new Pair(this.getFirst() + pair.getFirst(), this.getSecond() + pair.getSecond());
	}

	public Pair clone(){
		return new Pair(this.getFirst(), this.getSecond());
	}

	public boolean isOutOfBounds() {
		if (this.getFirst() < 0 || this.getFirst() >= 8) {
			return true;
		}
		if (this.getSecond() < 0 || this.getSecond() >= 8) {
			return true;
		}
		return false;
	}

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return this.first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return this.second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public Pair first(int first) {
		this.first = first;
		return this;
	}

	public Pair second(int second) {
		this.second = second;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Pair)) {
			return false;
		}
		Pair pair = (Pair) o;
		return first == pair.first && second == pair.second;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public String toString() {
		return "{" +
			" first='" + getFirst() + "'" +
			", second='" + getSecond() + "'" +
			"}";
	}
}