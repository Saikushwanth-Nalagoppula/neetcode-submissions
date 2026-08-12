class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            // Skip non-alphanumeric characters from left
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            // Skip non-alphanumeric characters from right
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare ignoring case
            if (Character.toLowerCase(s.charAt(i))
                    != Character.toLowerCase(s.charAt(j))) {

                return false;
            }

            // Move both pointers
            i++;
            j--;
        }

        return true;
    }
}