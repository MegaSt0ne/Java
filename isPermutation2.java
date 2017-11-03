boolean permutation2 (String s1, String s2) {
	
	if (s1.length() != s2.length()) return false;
	
	int[] letters = new int[128];
	
	for (int i = 0; i < s1.length(); i++) {
		int val = s1.charAt(i);
		++letters[val];
	}
	
	for (int i = 0; i < t.length(); i++) {
		int val = s2.charAt(i);
		letters[val]--;
		if (letters[val] < 0) {
			return false;
		}
	}
	
	return true;

}
