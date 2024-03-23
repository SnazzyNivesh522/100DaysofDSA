public class Pattern {
    public void square(int n){
        System.out.println("Square pattern");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    
    }
    public void triangle(int n){
        System.out.println("Triangle pattern");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    public void numbertriangle(int n){
        System.out.println("Number Triangle pattern");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                System.out.print(j+1+" ");
            }
            System.out.println();
        }
    }
    public void rownumbertriangle(int n){
        System.out.println("Row Number Triangle pattern");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                System.out.print(i+1+" ");
            }
            System.out.println();
        }
    }
    public void reversetriangle(int n){
        System.out.println("Reverse Triangle pattern");
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n-i+1; j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=5;
        Pattern p = new Pattern();
        p.square(n);
        p.triangle(n);
        p.numbertriangle(n);
        p.rownumbertriangle(n);
        p.reversetriangle(n);
        
    }
    
}
