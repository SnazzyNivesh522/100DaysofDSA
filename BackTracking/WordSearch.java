
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
*/
public class WordSearch{
    private boolean search(char [][]board,char[] word,int x,int y,boolean [][]visited,int idx,int rows,int cols){
        if(idx>=word.length){
            return true;
        } 
        if(x<0 || x>=rows || y<0 || y>=cols || visited[x][y]){
            return false;
        }
        
        visited[x][y]=true;
        int directions[][]=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        if(board[x][y]==word[idx]){
            for(int k=0;k<4;k++){
                if(search(board,word,x+directions[k][0],y+directions[k][1],visited,idx+1,rows,cols)){
                    return true;
                }
            }
        }
            
        visited[x][y]=false;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        boolean visited[][]=new boolean[rows][cols];
        char []w=word.toCharArray();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==w[0]){
                    if(search(board,w,i,j,visited,0,rows,cols)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        WordSearch s = new WordSearch();
        char [][]board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));
        System.out.println(s.exist(board, "ABCB"));
    }
}