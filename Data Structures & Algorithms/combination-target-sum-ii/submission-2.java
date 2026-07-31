

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), res);

        return res;
    }

    void backtrack(int start, int target, int[] candidates,
                   List<Integer> temp, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int j = start; j < candidates.length; j++) {

            // Skip duplicates at the same recursion level
            if (j > start && candidates[j] == candidates[j - 1]) {
                continue;
            }

            // Pruning
            if (candidates[j] > target) {
                break;
            }

            // Choose
            temp.add(candidates[j]);

            // Explore
            backtrack(j + 1, target - candidates[j], candidates, temp, res);

            // Undo (Backtrack)
            temp.remove(temp.size() - 1);
        }
    }
}