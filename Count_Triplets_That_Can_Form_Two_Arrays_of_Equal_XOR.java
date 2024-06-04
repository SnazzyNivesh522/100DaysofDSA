class Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int triplets = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int a = 0;
                    int b = 0;
                    for (int index = i; index <= j - 1; index++) {
                        a ^= arr[index];
                    }
                    for (int index = j; index <= k; index++) {
                        b ^= arr[index];
                    }
                    if (a == b) {
                        triplets++;
                    }
                }
            }
        }
        return triplets;
    }
}