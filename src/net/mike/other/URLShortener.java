package net.mike.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 12/14/14.
 */
public class URLShortener {

	private static final char[] TABLE = new char[]
			{'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z',
			 'A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z',
			 '2','3','4','5','6','7','8','9'
			};
	private static final Map<Character, Integer> INDEX = new HashMap<>();

	static {
		for (int i = 0; i < TABLE.length; i++) {
			INDEX.put(TABLE[i], i);
		}
	}

	/**
	 * Bijective fuction choice, f(x) = convert DB index ID to 54 based number with representation in above table
	 * Confusing characters are excluded, e.g. '0', 'O', '1', 'l', etc
	 * 6 characters is enough for integer range
	 */
	public String toShortForm(int id) {
		if (id < 0) return "";
		if (id == 0) return String.valueOf(TABLE[0]);
		StringBuilder sb = new StringBuilder();
		while (id > 0) {
			sb.append(TABLE[id % TABLE.length]);
			id /= TABLE.length;
		}
		sb.reverse();
		return sb.toString();
	}

	public int toId(String shortForm) {
		if (shortForm == null || shortForm.isEmpty()) return -1;
		int id = 0;
		for (int i = 0; i < shortForm.length(); i++) {
			id = id * TABLE.length + INDEX.get(shortForm.charAt(i));
		}
		return id;
	}
}
