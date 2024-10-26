/**
 * 
 */
package edu.uwstout.cs358.alphasubset;

import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.TreeSet;
import java.lang.Character;

/**
 * 
 * TODO - add (not replace) yourself as an author and make this file follow our
 *        coding style guidelines with JavaDocs comments
 *        
 * @author jocelyn
 *
 */
public class AlphaSubset {private String mPhrase;private ArrayList<Character> mSubset;	public AlphaSubset(String phrase) {
		mPhrase = phrase;if (!validate()) {mPhrase = null;}
	}	public Boolean compare(AlphaSubset other) throws Exception {
		return this.getSubset().equals(other.getSubset());}
	
	public String getPhrase() { return mPhrase; }	public ArrayList<Character> getSubset() throws Exception { 
		if (mPhrase == null) {throw new Exception("Phrase was invalid");		}		//if the subset hasn't been found yet
		if (mSubset == null) {mSubset = new ArrayList<Character>();
			TreeSet<Character> uniqueCharsInPhrase = new TreeSet<Character>();
			for (int i = 0; i < mPhrase.length(); i++) {uniqueCharsInPhrase.add(mPhrase.charAt(i));}
			for (Character phraseChar : uniqueCharsInPhrase) {phraseChar = Character.toUpperCase(phraseChar.charValue());if (Character.isLetterOrDigit(phraseChar.charValue())) {					mSubset.add(phraseChar);
				}
			}
		}return mSubset; 
		
	}	private boolean validate() {return Pattern.matches("[a-zA-Z0-9!.?]+", mPhrase);
	}
}
	
