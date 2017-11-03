class Solution {
	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);

		search:
			for (int i = 0; i < s.length(); i++) {
				for (int j = s.length() - 1 - i; j > 0; j--) {
					if (s.charAt(i) == s.charAt(j)) {
						continue search;
					} else {
						return false;
					}
				}
			}
		return true;
	}
}