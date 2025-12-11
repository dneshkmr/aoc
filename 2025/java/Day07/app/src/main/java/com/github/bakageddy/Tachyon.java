package com.github.bakageddy;

/**
 * Tachyon
 */
public class Tachyon {
	public static int count = 0;
	public Point origin;
	public Manifold parent;

	public Tachyon(Point origin, Manifold parent) {
		this.origin = origin;
		this.parent = parent;
		count++;
	}
}
