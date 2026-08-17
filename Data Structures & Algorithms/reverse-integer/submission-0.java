class Solution {
    public int reverse(int x) {
        String s=Integer.toString(x);
        StringBuilder sb=new StringBuilder();
        boolean negative=false;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='-'){
                negative=true;
                break;
            }
            sb.append(s.charAt(i));
        }
        long y=(long)(Long.parseLong(sb.toString()));
        if(negative==true){
            y=0-y;
        }
        if(y<Integer.MIN_VALUE|y>Integer.MAX_VALUE){
            return 0;
        }
        return (int)y;
    }
}
