class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[] {};
        }

        Map<Integer, Integer> index = new HashMap<>(nums.length);

        for (int num : nums) {
            int count = index.getOrDefault(num, 0);
            index.put(num, ++count);
        }

        Map<Integer, Integer> sortedIndex = new LinkedHashMap<>(index.size());

        List<Map.Entry<Integer, Integer>> list =
            new ArrayList<>(index.entrySet());

        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        
        return result;
    }
}
