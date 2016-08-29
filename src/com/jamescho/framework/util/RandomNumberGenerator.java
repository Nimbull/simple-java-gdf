package com.jamescho.framework.util;

// Imports.
import java.util.Random;

/*
 * <p>RandomNumberGenerator.java - Handles random number generation calls.</p>
 */
public class RandomNumberGenerator {
	// Private members.
	private static Random rand = new Random();

	/**
	 * <p>Get a random integer between x and y.</p>
	 * 
	 * @param int that is the lower bound.
	 * @param int that is the upper bound.
	 * 
	 * @return int that is the number generated.
	 */
	public static int getRandIntBetween(int inL, int inU) {
		return rand.nextInt(inU - inL) + inL;
	}

	/**
	 * <p>Get a random number up to x.</p>
	 * 
	 * @param int that is the upper bound.
	 * 
	 * @return int that is the number generated.
	 */
	public static int getRandInt(int inN) {
		return rand.nextInt(inN);
	}
}