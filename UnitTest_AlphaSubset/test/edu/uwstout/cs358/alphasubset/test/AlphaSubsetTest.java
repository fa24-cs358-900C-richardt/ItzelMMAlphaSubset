/**
 * 
 */
package edu.uwstout.cs358.alphasubset.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import edu.uwstout.cs358.alphasubset.*;

/**
 * @author jocelyn
 *
 */
class AlphaSubsetTest {


	@Test
	/**
	 * test a simple case:
	 *   all uppercase letters
	 *   no duplicates
	 *   no special characters
	 *   no numbers
	 *   letters are already in order
	 *   
	 */
	void simpleTest() {
		
		AlphaSubset trivial = new AlphaSubset("ABCD");
		
		//verify that the phrase validated
		assertEquals("ABCD", trivial.getPhrase());
		
		//verify that the correct subset is returned
		String expectedAsString = "ABCD";
		
		//map expected string to an array list of characters
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
	 *   all uppercase letters
	 *   no duplicates
	 *   no special characters
	 *   no numbers
	 *   letters are already in order
	 *   
	 *   Comparing to phrase using a diferent order
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


}
