class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> output = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            String currString = strs[i];
            char[] currStrCharArr = currString.toCharArray();
            Arrays.sort(currStrCharArr);
            String key = new String(currStrCharArr);

            List<String> existingValue = output.get(key);
            if (existingValue != null) {
                existingValue.add(currString);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(currString);
                output.put(key, anagrams);
            }
        }

        return new ArrayList(output.values());
    }
}
