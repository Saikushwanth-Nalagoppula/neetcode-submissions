class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {

            int x = points[i][0];
            int y = points[i][1];

            int distance = x * x + y * y;

            pq.add(new int[]{distance, i});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            int index = curr[1];

            result[i][0] = points[index][0];
            result[i][1] = points[index][1];
        }

        return result;
    }
}