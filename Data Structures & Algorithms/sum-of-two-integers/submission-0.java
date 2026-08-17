class Solution {
    public int getSum(int a, int b) {

        int res = 0;
        int carry = 0;

        for (int i = 0; i < 32; i++) {

            int a1 = ((a & (1 << i)) != 0) ? 1 : 0;
            int b1 = ((b & (1 << i)) != 0) ? 1 : 0;

            // Calculate sum bit
            int sum = a1 ^ b1 ^ carry;

            // Calculate carry
            carry = (a1 & b1) | (a1 & carry) | (b1 & carry);

            // Set result bit if sum is 1
            if (sum == 1) {
                res = res | (1 << i);
            }
        }

        return res;
    }
}