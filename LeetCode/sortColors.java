import javax.naming.ldap.SortControl;

class Solution {
	public void sortColors(int[] nums) {
		int temp = -1;

		search:
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if ( nums[j] == 0) {
						temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
						continue search;
					}
				}
				
				for (int j = i + 1; j < nums.length; j++) {
					if ( nums[j] == 1 && nums[i] == 2 ) {

						temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
						continue search;
					}
				}
			}

	}
}