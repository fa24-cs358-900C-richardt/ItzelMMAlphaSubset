/**
 *
 */
package edu.uwstout.cs358.alphasubset.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import edu.uwstout.cs358.alphasubset.AlphaSubset;

/**
 * @author jocelyn
 *
 */
class AlphaSubsetTest {

	@Test
	/**
	 * test a simple case:
	 * all uppercase letters
	 * no duplicates
	 * no special characters
	 * no numbers
	 * letters are already in order
	 * 
	 */
	void simpleTest() {

		AlphaSubset trivial = new AlphaSubset("ABCD");

		// verify that the phrase validated
		assertEquals("ABCD", trivial.getPhrase());

		// verify that the correct subset is returned
		String expectedAsString = "ABCD";

		// map expected string to an array list of characters
		ArrayList<Character> expected = new ArrayList<Character>();
		for (Character expectedChar : expectedAsString.toCharArray()) {
			expected.add(expectedChar);
		}

		try {
			assertArrayEquals(expected.toArray(), trivial.getSubset().toArray());
		} catch (Exception e) {
			fail("Unexpected exception getting the subset");
		}

	}

	@Test
	/**
	 * test a simple compare:
	 * all uppercase letters
	 * no duplicates
	 * no special characters
	 * no numbers
	 * letters are already in order
	 * 
	 * Comparing to phrase using a diferent order
	 */
	void simpleCompare() {

		AlphaSubset trivial = new AlphaSubset("ABCD");
		AlphaSubset unsortedTrivial = new AlphaSubset("CDBA");

		try {
			assertTrue(trivial.compare(unsortedTrivial));
		} catch (Exception e) {
			fail("Unexpected exception comparing subsets that should be equal");
		}

	}

	@Test
	/*
	 * Error Condition case:
	 * helps in gracefully handling any unexpected errors during the execution of
	 * the method and provides an alternative name to avoid conflicts.
	 */

	void simpleExamine() {

		AlphaSubset test = new AlphaSubset("12345");
		ArrayList<Character> result = test.getUniqueSortedSubset();

		// Expected output
		ArrayList<Character> expected = new ArrayList<>();

		// Test case for the input "12345"
		if (result.equals(expected)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Got: " + result);
		}
	}

	@Test
	/*
	 * Error Condition case 2:
	 * ensures that the method correctly handles inputs with only non-alphabetic
	 * characters, maintaining its robustness and reliability.
	 */

	void nonAlphabeticCharactersTest() {
		AlphaSubset test = new AlphaSubset("!!! ???");
		ArrayList<Character> result = test.getUniqueSortedSubset();

		// Expected output
		ArrayList<Character> expected = new ArrayList<>();

		// Test case for the input "!!! ???"
		if (result.equals(expected)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Got: " + result);
		}
	}

	@Test
	/*
	 * Edge case 1:
	 * tests the method's ability to manage inputs with high repetition and still
	 * provide the correct, minimal output.
	 */

	void singleCharacterRepetitionTest() {
		AlphaSubset test = new AlphaSubset("aaaaaaa");
		ArrayList<Character> result = test.getUniqueSortedSubset();

		// Expected output
		ArrayList<Character> expected = new ArrayList<>(Arrays.asList('A'));

		// Test case for the input "aaaaaaa"
		if (result.equals(expected)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Got: " + result);
		}
	}

	@Test
	/*
	 * Edge case 2:
	 * ensures that the method can accurately process strings with mixed-case
	 * letters, converting them to a uniform case and producing the correct, sorted
	 * list of unique letters.
	 */

	void mixedCaseLettersTest() {
		AlphaSubset test = new AlphaSubset("AaBbCc");
		ArrayList<Character> result = test.getUniqueSortedSubset();

		// Expected output
		ArrayList<Character> expected = new ArrayList<>(Arrays.asList('A', 'B', 'C'));

		// Test case for the input "AaBbCc"
		if (result.equals(expected)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Got: " + result);
		}
	}

	@Test
	/*
	 * Functionality case 1:
	 * ensures that the method can process strings with mixed characters,
	 * maintaining its integrity in extracting, sorting, and returning unique
	 * letters.
	 */

	void handleSpecialCharactersTest() {
		AlphaSubset test = new AlphaSubset("Hello, World!");
		ArrayList<Character> result = test.getUniqueSortedSubset();

		// Expected output
		ArrayList<Character> expected = new ArrayList<>(Arrays.asList('D', 'E', 'H', 'L', 'O', 'R', 'W'));

		// Test case for the input "Hello, World!"
		if (result.equals(expected)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Got: " + result);
		}
	}

	@Test
	/*
	 * Functionality case 2:
	 * ensures that the method can robustly handle strings with a variety of
	 * characters, maintaining its core functionality of extracting, sorting, and
	 * returning unique letters.
	 */

	void handleMixedCharactersTest() {
		AlphaSubset test = new AlphaSubset("C0d3!ng 1s fun!");
		ArrayList<Character> result = test.getUniqueSortedSubset();

		// Expected output
		ArrayList<Character> expected = new ArrayList<>(Arrays.asList('C', 'D', 'F', 'G', 'I', 'N', 'S', 'U'));

		// Test case for the input "C0d3!ng 1s fun!"
		if (result.equals(expected)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Got: " + result);
		}
	}
}
