public class FastExponentiation {
  public static long power(long base, int exponent) {
    if (exponent == 0) {
      return 1;
    } 
    else if (exponent % 2 == 0) { //squaring
      long x = power(base , exponent / 2);
      return (x * x);
    } 
    else { //multiplying
      return (base * power(base , exponent - 1));
    }
  }

  public static void main(String[] args) {
    long base = 3;
    int exponent = 7;
    System.out.println(base + "^" + exponent + " = " + power(base, exponent));
  }
}