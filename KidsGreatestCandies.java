import java.util.ArrayList;
import java.util.List;

public class KidsGreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> boolarrCandies=new ArrayList<>();
        int maximumCandies=candies[0];
        for(int i=1;i<candies.length;i++){
            maximumCandies=Math.max(maximumCandies,candies[i]);
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=maximumCandies) boolarrCandies.add(true);
            else boolarrCandies.add(false);
        }
        return boolarrCandies;
        
    }
    public static void main(String[] args) {
        KidsGreatestCandies kgc = new KidsGreatestCandies();
      
        // Test case 1: Simple scenario with one kid having the most candies
        int[] candies1 = {2, 3, 5, 1};
        int extraCandies1 = 3;
        List<Boolean> result1 = kgc.kidsWithCandies(candies1, extraCandies1);
        System.out.println("Test 1: " + result1); // Expected output: [false, false, true, false]
      
        // Test case 2: Multiple kids with the most candies after adding extra
        int[] candies2 = {1,2,2};
        int extraCandies2 = 1;
        List<Boolean> result2 = kgc.kidsWithCandies(candies2, extraCandies2);
        System.out.println("Test 2: " + result2); // Expected output: [true, true, true]
      
        // Test case 3: Edge case with empty candy list
        int[] candies3 = {1};
        int extraCandies3 = 1;
        List<Boolean> result3 = kgc.kidsWithCandies(candies3, extraCandies3);
        System.out.println("Test 3: " + result3); // Expected output: [] (empty list)
      }
}
