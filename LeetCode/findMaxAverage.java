class Solution {
	public double findMaxAverage(int[] nums, int k) {
		int[] sumlist = new int[nums.length];
		int sum = 0;
		double res = 0;
		//sum all the number in the array
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sumlist[i] = sum;
		}
		res = sumlist[k - 1] * 1.0 / k;
		for(int i = k; i < nums.length; i++) {
			res = Math.max(res, ( sumlist[i] - sumlist[i - k] ) * 1.0 / k);
		}
		return res ;
	}
}