import java.util.Arrays;
import java.util.Scanner;

public class JT {

    public static void main(String[] args) {
        // Prompting for array size
        System.out.println("Enter n (size of the array)");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // Timing the algorithm
        long start = System.currentTimeMillis();
        SJT(n);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);

        // Exiting
        System.out.println("type a key to exit");
        scn.next();
    }

    public static int search(int[] A, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (A[i] == k) {
                return i + 1;
            }
        }
        return 0;
    }

    public static int findMobile(int[] A, boolean[] B, int n) {
        int last = 0;
        int mobile = 0;
        for (int i = 0; i < n; i++) {
            if (!B[A[i] - 1] && i != 0) {
                if (A[i] > A[i - 1] && A[i] > last) {
                    mobile = A[i];
                    last = mobile;
                }
            }
            if (B[A[i] - 1] && i != n - 1) {
                if (A[i] > A[i + 1] && A[i] > last) {
                    mobile = A[i];
                    last = mobile;
                }
            }
        }
        if (mobile == 0 && last == 0) {
            return 0;
        } else {
            return mobile;
        }
    }


    public static void printPermutation(int[] A, boolean[] B, int n) {
        int mobile = findMobile(A, B, n);
        int position = search(A, n, mobile) - 1;

        if (position != -1) {
            if (!B[A[position] - 1]) {
                int temp = A[position];
                A[position] = A[position - 1];
                A[position - 1] = temp;
            } else {
                int temp = A[position];
                A[position] = A[position + 1];
                A[position + 1] = temp;
            }
        }

        for (int i = 0; i < n ; i++) {
            if (A[i] > mobile) {
                if (!B[A[i] - 1]) {
                    B[A[i] - 1] = true;
                } else if (B[A[i] - 1]) {
                    B[A[i] - 1] = false;
                }
            }
        }
        System.out.println(Arrays.toString(A));

    }

    public static void SJT(int n) {
        int[] A = new int[n];
        boolean[] B = new boolean[n];
        for (int i = 0; i < n ; i++) {
            A[i] = i + 1;
        }
        System.out.println(Arrays.toString(A));
        for (int i = 0; i < n ; i++) {
            B[i] = false;
        }

        int temp = factorial(n);

        for (int i = 0; i < temp ; i++) {
            printPermutation(A, B, n);
        }

    }

    //factorial method
    public static int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }
}



