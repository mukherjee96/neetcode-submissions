class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String section = str.length() + "#" + str;
            sb.append(section);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrList = new ArrayList<>();
        int pointer = 0;

        while (pointer < str.length()) {
            int delimIndex = pointer;
            while (str.charAt(delimIndex) != '#') {
                delimIndex++;
            }

            int size = Integer.parseInt(str.substring(pointer, delimIndex));

            if (size == 0) {
                decodedStrList.add("");
                pointer = delimIndex + 1;
                continue;
            }

            pointer = delimIndex + size + 1;
            decodedStrList.add(str.substring(delimIndex+1, pointer));
        }

        return decodedStrList;
    }
}
