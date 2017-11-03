import java.util.Arrays;

class solution {
	public String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);	
	}
	
	public boolean permutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		return sort(s1).equals(sort(s2));
	}
}