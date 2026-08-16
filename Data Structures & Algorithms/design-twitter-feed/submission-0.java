class Twitter {

    // userId -> list of tweets
    HashMap<Integer, List<Tweet>> tweets;

    // followerId -> people they follow
    HashMap<Integer, HashSet<Integer>> follow;

    int time;

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        follow = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        time++;

        tweets
            .computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new Tweet(tweetId, time));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Add tweets of people user follows
        if (follow.containsKey(userId)) {

            for (int followee : follow.get(userId)) {

                if (tweets.containsKey(followee)) {
                    pq.addAll(tweets.get(followee));
                }
            }
        }

        // Get latest 10
        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        follow
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}