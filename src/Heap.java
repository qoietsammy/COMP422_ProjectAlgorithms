import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = nums.length;
        heapsAlgorithm(k, nums);
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


