package pranav.java.thread;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null && i!=map.get(target - nums[i])) {
				result[0] = i;
				result[1] = map.get(target - nums[i]);
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(twoSum(new int[] { 3, 2, 4 }, 6)[0] + " " + twoSum(new int[] { 3, 2, 4 }, 6)[1]);
	}

}
