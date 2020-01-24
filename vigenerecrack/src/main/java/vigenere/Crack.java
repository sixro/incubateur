package vigenere;

import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class Crack {

	private static final int MIN_LENGTH = 3;

	static List<String> repetitions(String cipherText) {
		List<String> repetitions = new LinkedList<>();
		int worstKeyLength = cipherText.length() / 2 +1;
		for (int length = worstKeyLength; length >= MIN_LENGTH; length--)
			addCandidatesWithLength(length, cipherText, repetitions);
		return repetitions;
	}

	private static void addCandidatesWithLength(int length, String cipherText, List<String> repetitions) {
		int maxStartForCandidate = cipherText.length() - length;
		for (int i = 0; i < maxStartForCandidate; i++) {
			String candidate = StringUtils.substring(cipherText, i, i + length);
			if (isSubpartOfOthers(repetitions, candidate))
				continue;
			if (isRepeated(cipherText, candidate))
				repetitions.add(candidate);
		}
	}

	private static boolean isSubpartOfOthers(List<String> list, String text) {
		for (String each : list)
			if (each.indexOf(text) >= 0)
				return true;
		return false;
	}

	static boolean isRepeated(String text, String part) {
		int first = text.indexOf(part);
		int second = text.indexOf(part, first + part.length());
		return second >= 0;
	}

	static int distance(String cipherText, String repetition) {
		int first = cipherText.indexOf(repetition);
		int second = cipherText.indexOf(repetition, first + repetition.length());
		return second - first;
	}

	static int[] factors(int n) {
		List<Integer> results = new LinkedList<>();
		for (int i = n; i > 0; i--) {
			BigDecimal remainder = new BigDecimal(n).remainder(new BigDecimal(i));
			if (remainder.compareTo(BigDecimal.ZERO) == 0)
				results.add(i);
		}
		
		return toArray(results);
	}

	private static int[] toArray(List<Integer> list) {
		int[] a = new int[list.size()];
		int i = 0;
		for (Integer each : list) a[i++] = each.intValue();
		return a;
	}

}

