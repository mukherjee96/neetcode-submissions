class Solution {
    private static final String OUTER_DELIMETER = "_";
    private static final String INNER_DELIMETER = "-";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "0";
        }

        Map<String, String> index = 
            new HashMap<>(strs.size());

        List<String> encoded = new ArrayList<>();

        for (String str : strs) {

            if (str.isEmpty()) {
                encoded.add("0");
                continue;
            }

            String indexed = index.get(str);

            if (indexed != null) {
                encoded.add(indexed);
                continue;
            }

            char[] strArray = str.toCharArray();
            List<String> encodedCharList = new ArrayList<>(str.length());
            for (char c : strArray) {
                int ascii = (int) c;
                encodedCharList.add(String.valueOf(ascii));
            }
            String encodedStr = String.join(INNER_DELIMETER, encodedCharList);

            index.put(str, encodedStr);
            encoded.add(encodedStr);
        }

        if (encoded.size() == 1) {
            return encoded.get(0) + OUTER_DELIMETER;
        }

        return String.join(OUTER_DELIMETER, encoded);
    }

    public List<String> decode(String str) {
        if (str.equals("0")) {
            return new ArrayList<>();
        }

        String[] parts = str.split(OUTER_DELIMETER);
        List<String> decoded = new ArrayList<>(parts.length);
        Map<String, String> index = new HashMap<>(parts.length);

        for (String part : parts) {

            if (part.equals("0")) {
                decoded.add("");
                continue;
            }

            String indexed = index.get(part);

            if (indexed != null) {
                decoded.add(indexed);
                continue;
            }

            String[] innerParts = part.split(INNER_DELIMETER);
            
            StringBuilder sb = new StringBuilder();
            for (String innerPart : innerParts) {
                int ascii = Integer.valueOf(innerPart);
                char originalChar = (char) ascii;
                sb.append(originalChar);
            }

            String originalString = sb.toString();
            index.put(part, originalString);
            decoded.add(originalString);
        }

        return decoded;
    }
}
