import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score =0;//initially
        int left=0;
        int right=tokens.length-1;
        while(left<=right){
            if(power>=tokens[left]){
                power-=tokens[left];
                score++;
                left++;
            }
            else if(score>=1 && left<right){
                power+=tokens[right];
                score--;
                right--;
            }
            else{
                return score;
            }

        }
        return score;
        
    }
    public static void main(String[] args) {
        BagOfTokens bof = new BagOfTokens();
        System.out.println("Bag  of Tokens Score for [100] power:50 score:" + bof.bagOfTokensScore(new int[]{100}, 50));
		System.out.println("Bag  of Tokens Score for [200,100] power:150 score: " + bof.bagOfTokensScore(new int[]{200,100}, 150));
        System.out.println("Bag  of Tokens Score for [100,200,300,400] power:200 score: " + bof.bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }
}
