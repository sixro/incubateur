package vigenere;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class CrackTest {

	@Test public void findRepetitions() {
		hasRepetitions("ABCXABC", asList("ABC"));
		hasRepetitions("CSASTPKVSIQUTGQUCSASTPIUAQJB", asList("CSASTP"));
		hasRepetitions("VHVSSPQUCEMRVBVBBBVHVSURQGIBDUGRNICJQUCERVUAXSSR", asList("VHVS", "QUCE"));
	}

	private void hasRepetitions(String cipherText, List<String> repetitions) {
		assertEquals(repetitions, Crack.repetitions(cipherText));
	}

	@Test public void distances() {
		isDistant("ABCXABC", "ABC", 4);
		isDistant("CSASTPKVSIQUTGQUCSASTPIUAQJB", "CSASTP", 16);
		isDistant("VHVSSPQUCEMRVBVBBBVHVSURQGIBDUGRNICJQUCERVUAXSSR", "VHVS", 18);
		isDistant("VHVSSPQUCEMRVBVBBBVHVSURQGIBDUGRNICJQUCERVUAXSSR", "QUCE", 30);
	}
	
	private void isDistant(String cipherText, String repetition, int distance) {
		assertEquals(distance, Crack.distance(cipherText, repetition));
	}

	@Test public void factors() {
		assertArrayEquals(new int[]{ 2, 1 }, Crack.factors(2));
		assertArrayEquals(new int[]{ 4, 2, 1 }, Crack.factors(4));
		assertArrayEquals(new int[]{ 16, 8, 4, 2, 1 }, Crack.factors(16));
		assertArrayEquals(new int[]{ 30, 15, 10, 6, 5, 3, 2, 1 }, Crack.factors(30));
	}
	
	@Test public void isRepeated() {
		assertTrue(Crack.isRepeated("AB__AB", "AB"));
		assertTrue(Crack.isRepeated("CSASTPKVSIQUTGQUCSASTPIUAQJB", "CSASTP"));
	}
	
}
