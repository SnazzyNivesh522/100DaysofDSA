/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

 

Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation: 
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation: We cannot reach the target without getting stuck.
 

Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;

public class OpenTheLock {
    private List<String> getChildren(String par){
        List<String> childs=new ArrayList<String>();
        StringBuilder parent=new StringBuilder(par);
        for(int i=0;i<parent.length();i++){
            int digit=parent.charAt(i)-'0';
            parent.setCharAt(i,(char)(((digit+1)%10)+'0'));
            childs.add(parent.toString());
            parent.setCharAt(i,(char)(((digit-1+10)%10)+'0'));
            childs.add(parent.toString());
            parent.setCharAt(i, (char) (digit + '0'));
        }
        return childs;
    }
    public int openLock(String[] deadends, String target) {
        for(String dead:deadends){
            if(dead.equals("0000")){
                return -1;
            }
        }
        HashSet<String> visited=new HashSet<>(Arrays.asList(deadends));
        Queue<Pair<String,Integer>> queue=new LinkedList<Pair<String,Integer>>();
        queue.add(new Pair<String,Integer>("0000", 0));
        while(!queue.isEmpty()){
            Pair<String,Integer> lock_turns=queue.poll();
            String lock=lock_turns.getKey();
            int turns=lock_turns.getValue();
            if(lock.equals(target)){
                return turns;
            }
            for(String child:getChildren(lock)){
                if(!visited.contains(child)){
                    visited.add(child);
                    queue.add(new Pair<String,Integer>(child,turns+1));
                }
            }
        }
        return -1;        
    }

}
