public class MinimumNumberOfChairs {
    public int minimumChairs(String s) {
        int minChairs=0;
        int chairs=0;
        for(char c:s.toCharArray()){
            if(c=='E'){
                chairs++;
            }
            else{
                chairs--;
            }
            minChairs=Math.max(minChairs,chairs);
        }
        return minChairs;
    }
}
