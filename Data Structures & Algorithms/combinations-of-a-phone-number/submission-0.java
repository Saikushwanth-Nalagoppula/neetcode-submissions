class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return res;

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, digits, new StringBuilder(), res, map);

        return res;
    }

    void backtrack(int index, String digits, StringBuilder current,
                   List<String> res, HashMap<Character, String> map) {

        if (index == digits.length()) {
            res.add(current.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));     // Choose

            backtrack(index + 1, digits, current, res, map); // Explore

            current.deleteCharAt(current.length() - 1); // Undo
        }
    }
}