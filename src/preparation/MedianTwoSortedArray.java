package preparation;

import java.util.Arrays;

public class MedianTwoSortedArray {
    public static void main(String[] args) {

        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10, 11};
        System.out.println(findMedianOfTwoSortedArray(arr1, arr2));

    }

    private static int findMedianOfTwoSortedArray(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        if((m+n)%2 == 0) {
            int first = kth(arr1, arr2, m, n)[(m+n)/2];
            int second = kth(arr1, arr2, m, n)[((m+n)/2)-1];
            int middle = (first+second)/2;
            return kth(arr1, arr2, m, n)[middle];
        }else {
            return kth(arr1, arr2, m, n)[(m+n)/2];

        }
    }

    static int[] kth(int arr1[], int arr2[], int m, int n) {
        int[] sorted1 = new int[m + n];
        int i=0, j = 0, d = 0;
        while (i < m && j < n) {
            if(arr1[i] < arr2[j]) {
                sorted1[d++] = arr1[i++];
            }else
                sorted1[d++] = arr2[j++];
        }
        while (i < m) sorted1[d++] = arr1[i++];
        while (j < n)  sorted1[d++] = arr2[j++];
        System.out.println(Arrays.toString(sorted1));
        return sorted1;
    }

}
