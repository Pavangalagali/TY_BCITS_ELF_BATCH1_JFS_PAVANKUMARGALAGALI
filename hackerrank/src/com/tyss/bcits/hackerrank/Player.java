package com.tyss.bcits.hackerrank;

public class Player  {
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


	

}
