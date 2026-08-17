class TimeMap {
    HashMap<String,List<List<String>>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       map.computeIfAbsent(key, k -> new ArrayList<>())
   .add(Arrays.asList(value, Integer.toString(timestamp)));
    }
    
    public String get(String key, int timestamp) {
if (!map.containsKey(key)) {
    return "";
}

List<List<String>> res = map.get(key);int low = 0;
int high = res.size() - 1;
String ans = "";

while (low <= high) {

    int mid = low + (high - low) / 2;

    int time = Integer.parseInt(res.get(mid).get(1));

    if (time <= timestamp) {
        ans = res.get(mid).get(0);
        low = mid + 1;
    } 
    else {
        high = mid - 1;
    }
}

return ans;
        }
        
    }

