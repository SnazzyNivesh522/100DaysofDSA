import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        String result="";
        for(char si:s.toCharArray()){
            int exist=map.getOrDefault(si,0);
            map.put(si,exist+1);
        }
        for(char o:order.toCharArray()){
            if(map.containsKey(o)){
                for(int i=0;i<map.get(o);i++){
                result+=String.valueOf(o);
                }
                map.remove(o);
            }
        }
        for(char c:map.keySet()){
            for(int i=0;i<map.get(c);i++){
                result+=String.valueOf(c);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        CustomSortString css=new CustomSortString();
        System.out.println("Permutation that satisfies custom sort string:"+css.customSortString("cba","abcd"));
    }
    
}
