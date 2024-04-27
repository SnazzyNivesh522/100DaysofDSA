package DynamicProgramming;

import java.util.HashMap;
import javafx.util.Pair;

/*
In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring" and use the dial to spell a specific keyword to open the door.

Given a string ring that represents the code engraved on the outer ring and another string key that represents the keyword that needs to be spelled, return the minimum number of steps to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at the "12:00" direction. You should spell all the characters in key one by one by rotating ring clockwise or anticlockwise to make each character of the string key aligned at the "12:00" direction and then by pressing the center button.

At the stage of rotating the ring to spell the key character key[i]:

You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. The final purpose of the rotation is to align one of ring's characters at the "12:00" direction, where this character must equal key[i].
If the character key[i] has been aligned at the "12:00" direction, press the center button to spell, which also counts as one step. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.
 

Example 1:


Input: ring = "godding", key = "gd"
Output: 4
Explanation:
For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
Also, we need 1 more step for spelling.
So the final output is 4.
Example 2:

Input: ring = "godding", key = "godding"
Output: 13
 

Constraints:

1 <= ring.length, key.length <= 100
ring and key consist of only lower case English letters.
It is guaranteed that key could always be spelled by rotating ring.
 */
public class FreedomTrail {

    //brute force for large inputs TLE
    // private int rotate(int curr,int next,int ringlen){
    //     int clockwise=Math.abs(curr-next);
    //     int anticlockwise=ringlen-clockwise;
    //     return Math.min(clockwise,anticlockwise);
    // }
    // private int spell(int ridx,String ring,int kidx,String key,int steps){
    //     if(kidx==key.length()) return 0;
    //     for(int i=0;i<ring.length();i++){
    //         if(ring.charAt(i)==key.charAt(kidx)){
    //             int next=spell(i,ring,kidx+1,key,steps);
    //             int rotSteps=rotate(ridx,i,ring.length())+1+next;
    //             steps=Math.min(steps,rotSteps);
    //         }
    //     }
    //     return steps;
    // }
    // public int findRotateSteps(String ring, String key) {
    //     int steps=Integer.MAX_VALUE;
    //     return spell(0,ring,0,key,steps);
    // }
    private String ring, key;
    private HashMap<Pair<Integer, Integer>, Integer> memo;
    // r- index of ring, k - index of key
    private int stepSpell(int r, int k) {
        if (k == key.length()) return 0;
        if (memo.containsKey(new Pair<>(r, k))) {
            return memo.get(new Pair<>(r, k));
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(k)) {
                int min_dist=Math.min(
                    Math.abs(r-i),              //distance between
                    ring.length()-Math.abs(r-i) //distance around
                );
                minSteps = Math.min(minSteps, min_dist + 1 + stepSpell(i, k + 1));
            }
        }
        memo.put(new Pair<>(r, k), minSteps);
        return minSteps;
    }
    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        this.memo = new HashMap<>();
        return stepSpell(0, 0);
    }
    public static void main(String[] args) {
        System.out.println(new FreedomTrail().findRotateSteps("godding","godding"));

        System.out.println(new FreedomTrail().findRotateSteps("godding","gd"));

        System.out.println(new FreedomTrail().findRotateSteps("caotmcaataijjxi","oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));

        System.out.println(new FreedomTrail().findRotateSteps("bicligfijg","cgijcjlgiggigigijiiciicjilicjflccgilcflijgigbiifiggigiggibbjbijlbcifjlblfggiibjgblgfiiifgbiiciffgbfl"));
    }
}
