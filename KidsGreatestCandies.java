/*
 There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.

 

Example 1:

Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true] 
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
Example 2:

Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false] 
Explanation: There is only 1 extra candy.
Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
Example 3:

Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]
 */
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
