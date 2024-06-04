class Compare_Version_Numbers {
       public int compareVersion(String version1, String version2) {
              char v1[] = version1.toCharArray();
              char v2[] = version2.toCharArray();
              int n = v1.length;
              int m = v2.length;
              int i = 0, j = 0;
              int rev1 = 0, rev2 = 0;
              while (i < n || j < m) {
                     while (i < n && v1[i] != '.') {
                            rev1 = rev1 * 10 + (v1[i] - '0');
                            i++;
                     }
                     while (j < m && v2[j] != '.') {
                            rev2 = rev2 * 10 + (v2[j] - '0');
                            j++;
                     }
                     if (rev1 > rev2)
                            return 1;
                     else if (rev2 > rev1)
                            return -1;
                     rev1 = 0;
                     rev2 = 0;
                     i++;
                     j++;
              }
              return 0;
       }
}