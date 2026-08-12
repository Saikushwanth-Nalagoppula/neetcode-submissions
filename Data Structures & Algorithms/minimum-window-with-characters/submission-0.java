class Solution {
    public String minWindow(String s, String t) {
        // Frequency required from t
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int required = t.length();
        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0;
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            // Add character to window
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            // This occurrence satisfies a required occurrence
            if (need.containsKey(ch)
                    && window.get(ch) <= need.get(ch)) {
                have++;
            }
            // Window contains everything required
            while (have == required) {
                // Update minimum window
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                // If removing this character makes
                // the window invalid
                if (need.containsKey(leftChar)
                        && window.get(leftChar) <= need.get(leftChar)) {

                    have--;
                }
                // Remove left character
                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );
                l++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}