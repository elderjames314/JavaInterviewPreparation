package preparation;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 1;

        System.out.println(rotateArray(arr, k));

    }

    private static String rotateArray(int[] arr, int k) {
        if(k > arr.length) k = k % arr.length;
        //{1234567}
        //k = 3
        int[] results = new int[arr.length];
        int j = 0;
        for (int i = k + 1 ; i < arr.length; i++) {
            results[j++] = arr[i];
        }
        int formal = (arr.length - k) - 1;
        for (int i = 0; i <=k; i++) {
            results[formal++] = arr[i];
        }
        return Arrays.toString(results);

    }
}
