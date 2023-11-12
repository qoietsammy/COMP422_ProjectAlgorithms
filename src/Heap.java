import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
//        int[] nums = {1, 2};
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 2, 3,4};
//        int[] nums = {1, 2, 3,4,5};
//        int[] nums = {1, 2, 3,4,5,6};
//        int[] nums = {1, 2, 3,4,5,6,7};
//        int[] nums = {1, 2, 3,4,5,6,7,8};
//        int[] nums = {1, 2, 3,4,5,6,7,8,9};
//        int[] nums = {1, 2, 3,4,5,6,7,8,9,10};
//        int[] nums = {1, 2, 3,4,5,6,7,8,9,10,11};
        int[] nums = {1, 2, 3,4,5,6,7,8,9,10,11,12};

        int k = nums.length;
        long start = System.currentTimeMillis();
        heapsAlgorithm(k, nums);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }


    public static void heapsAlgorithm(int k, int[] A) {
        if (k == 1) System.out.println(Arrays.toString(A));
        for (int i = 0; i < k; i++) {
            heapsAlgorithm(k-1, A);
            if (k % 2 == 1) {
                int swap = A[0];
                A[0] = A[k - 1];
                A[k - 1] = swap;
            }
            else {
                int swap = A[i];
                A[i] = A[k-1];
                A[k-1] = swap;
            }
        }
    }
}


