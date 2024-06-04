class Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One {
       private void binaryAdd(StringBuilder s) {
              int i = s.length() - 1;
              while (i >= 0 && s.charAt(i) != '0') {
                     s.setCharAt(i, '0');
                     i--;
              }
              if (i < 0) {
                     s.insert(0, '1');
              } else {
                     s.setCharAt(i, '1');
              }
       }

       public int numSteps(String s) {
              StringBuilder result = new StringBuilder(s);

              int steps = 0;
              while (result.length() > 1) {
                     int n = result.length();
                     if (result.charAt(n - 1) == '0') {
                            // means even divide by 2
                            // we will to right shift by 1 letter means deleting letter from end
                            result.deleteCharAt(n - 1);
                     } else {
                            // we will have to add one
                            // if LSB is 1 we will have to add one and take into account carry
                            // we will keep setting 1 until we encounter 0
                            binaryAdd(result);
                     }
                     steps++;
              }
              return steps;
       }
}