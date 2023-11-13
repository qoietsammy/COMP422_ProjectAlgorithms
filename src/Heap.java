import java.util.Arrays;
import java.util.Scanner;

public class Heap {
    public static void main(String[] args) {
        // Prompting user for array size
        System.out.println("Enter n (size of the array)");
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        // Building array to permute
        int[] nums = new int[k];
        for (int i = 0; i < k; i++){
            nums[i] = i;
        }
        // Timing the algorithm
        long start = System.currentTimeMillis();
        heapsAlgorithm(k, nums);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
        // Exiting
        System.out.println("type a key to exit");
        scn.next();
    }


    public static void heapsAlgorithm(int k, int[] A) {
        if (k == 1) {
            System.out.println(Arrays.toString(A));
        }
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


