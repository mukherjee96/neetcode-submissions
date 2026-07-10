class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Map<Integer, Boolean> tracker = new HashMap<>(nums.length);
        for (int i=0; i<nums.length; i++) {
            Integer item = nums[i];
            if (tracker.containsKey(item)) {
                return true;
            }
            tracker.put(item, true);
        }
        return false;
    }
}