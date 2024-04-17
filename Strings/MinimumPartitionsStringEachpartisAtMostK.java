/*
Given a string S of size N consisting of numerical digits 1-9 and a positive integer K, the task is to minimize the partitions of the string such that each part is at most K. If it’s impossible to partition the string print -1.

Examples:

Input: S = “3456”, K = 45
Output: 2
Explanation: One possible way is to partition as 3, 45, 6. 
Another possibility is 3, 4, 5, 6, which uses 3 partition. 
No configuration needs less than 2 partitions. Hence, the answer is 2.

Input: S = “7891634”, K = 21
Output: 5
Explanation: The minimum number of partitions is 
7, 8, 9, 16, 3, 4, which uses 5 partitions.

Input: S = “67142849”, K = 39
Output: 5


 */
public class MinimumPartitionsStringEachpartisAtMostK {
    public int minPartitions(String S, int K) {
        int part=0;
        int num=0;
        int n=S.length();
        for(int i=0;i<n;i++) {
            int curr=S.charAt(i)-'0';
            if(num*10+curr<=K) {
                num=num*10+curr;
            }
            else{
                part++;
                num=curr;
            }
        }
        return part;
    }
    public static void main(String[] args) {
        MinimumPartitionsStringEachpartisAtMostK mps=new MinimumPartitionsStringEachpartisAtMostK();
        System.out.println(mps.minPartitions("3456", 45));
        System.out.println(mps.minPartitions("7891634", 21));
        System.out.println(mps.minPartitions("67142849", 39));
    }
}
