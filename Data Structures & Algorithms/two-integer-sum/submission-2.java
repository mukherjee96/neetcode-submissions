class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>(nums.length);

        for (int i=0; i<nums.length; i++) {
            int num1 = nums[i];
            Integer indexed = index.get(target - num1);
            if (indexed != null && !indexed.equals(i)) {
                return new int[] {i, indexed};
            }
            for (int j=i+1; j<nums.length; j++) {
                int num2 = nums[j];
                int sum = num1 + num2;
                if (sum == target) {
                    return new int[] {i, j};
                }
                index.put(num2, j);
            }
        }

        return new int[] {};
    }
}
