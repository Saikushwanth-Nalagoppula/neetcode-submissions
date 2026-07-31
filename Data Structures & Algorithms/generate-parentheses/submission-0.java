class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        func(0,0,n,"",res);
        return res;
    }
    void func(int open,int close,int n,String s,List<String> res){
        //base case
        if(s.length()==2*n){
            res.add(new String(s));
            return;
        }
        //open
        if(open<n){
            func(open+1,close,n,s+"(",res);
        }
        //close
        if(close<open){
            func(open,close+1,n,s+")",res);
        }
    }
}
