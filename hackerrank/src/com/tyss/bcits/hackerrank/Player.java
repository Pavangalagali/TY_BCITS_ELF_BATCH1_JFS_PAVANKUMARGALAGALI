package com.tyss.bcits.hackerrank;

public class Player implements Comparable<Player> {
	String name;
	int score;

	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public Player() {
		super();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + "]";
	}
	

	@Override
	public int hashCode() {
		return score;
	}

	@Override
	public int compareTo(Player o) {
		if(this.score==o.score) {
			return this.name.compareTo(o.name);
		}
		return this.score-o.score;
	}


	

}
