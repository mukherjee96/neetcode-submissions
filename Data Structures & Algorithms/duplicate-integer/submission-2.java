class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>(nums.length);
        for (int i=0; i<nums.length; i++) {
            numsSet.add(nums[i]);
        }
        return numsSet.size() < nums.length;
    }
}