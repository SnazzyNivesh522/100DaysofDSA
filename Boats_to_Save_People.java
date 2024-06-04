import java.util.Arrays;

class Boats_to_Save_People {
       public int numRescueBoats(int[] people, int limit) {
              Arrays.sort(people);
              int boats = 0;
              int i = 0, j = people.length - 1;
              while (i <= j) {
                     boats++;
                     if (people[i] + people[j] <= limit) {
                            i++;
                     }
                     j--;
              }
              return boats;
       }
}