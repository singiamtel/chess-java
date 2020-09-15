package utilities;

import java.util.Objects;

public class Pair<p, q> {
	private p first;
	private q second;

	public Pair() {
	}

	public Pair(p first, q second) {
		this.first = first;
		this.second = second;
	}

	public p getFirst() {
		return this.first;
	}

	public void setFirst(p first) {
		this.first = first;
	}

	public q getSecond() {
		return this.second;
	}

	public void setSecond(q second) {
		this.second = second;
	}

	public Pair<p,q> first(p first) {
		this.first = first;
		return this;
	}

	public Pair<p,q> second(q second) {
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
		Pair<p,q> pair = (Pair<p,q>) o;
		return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
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