/*
You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.

 

Example 1:


Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
Example 2:


Input: land = [[1,1],[1,1]]
Output: [[0,0,1,1]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].
Example 3:


Input: land = [[0]]
Output: []
Explanation:
There are no groups of farmland.
 

Constraints:

m == land.length
n == land[i].length
1 <= m, n <= 300
land consists of only 0's and 1's.
Groups of farmland are rectangular in shape.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FindAllGroupsOfFarmLands
 */
public class FindAllGroupsOfFarmLands {

    int [][]moves={{-1,0},{0,-1},{0,1},{1,0}};
    private void search(int [][]land,List<int[]> farms,int r1,int c1){
        int r2=r1;
        int c2=c1;

        while(c2<land[0].length-1 && land[r1][c2+1]==1){
            land[r1][c2+1]=0; //marking visited
            c2++;
        }
        while(r2<land.length-1 && land[r2+1][c1]==1){
            land[r2+1][c1]=0; //marking visited
            r2++;
        }
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                land[i][j]=0; //makring inside ones visited
            }
        }
        //found the farm
        farms.add(new int[]{r1,c1,r2,c2});
    }
    public int[][] findFarmland(int[][] land) {
        int rows=land.length;
        int cols=land[0].length;
        List<int[]> farms=new ArrayList<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(land[i][j] == 1) {
                    search(land,farms,i,j);
                }
            }
        }
        return farms.toArray(new int[farms.size()][]);
    }
    public static void main(String[] args) {
        int land[][]=new int[][]{{1,0,0},{0,1,1},{0,1,1}};
        System.out.println(Arrays.deepToString(land));
        System.out.println(Arrays.deepToString(new FindAllGroupsOfFarmLands().findFarmland(land)));
        System.out.println();

        land=new int[][]{{1,1},{1,1}};
        System.out.println(Arrays.deepToString(land));
        System.out.println(Arrays.deepToString(new FindAllGroupsOfFarmLands().findFarmland(land)));
        System.out.println();
        
        land=new int[][]{{0}};
        System.out.println(Arrays.deepToString(land));
        System.out.println(Arrays.deepToString(new FindAllGroupsOfFarmLands().findFarmland(land)));
    }
}