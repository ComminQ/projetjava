package net.stri.fdjava.views;

import lombok.Getter;

/**
 * Direction 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public enum Direction {

	NORD("N"),
	EST("E"),
	SUD("S"),
	OUEST("O");

	public static Direction getForDonjon(int i) {
		switch (i) {
		case 0:
			return Direction.NORD;
		case 1:
			return Direction.OUEST;
		case 2:
			return Direction.EST;
		case 3:
			return Direction.SUD;
		default:
			return null;
		}
	}

	public static Direction getByTag(String tag) {
		for (Direction direction : Direction.values()) {
			if (direction.tag.equals(tag)) return direction;
		}
		return null;
	}

	@Getter
	private String tag;

	private Direction(String tag) {
		this.tag = tag;
	}

	public Direction opposite() {
		return Direction.values()[(this.ordinal() + 2) % 4];
	}

}
