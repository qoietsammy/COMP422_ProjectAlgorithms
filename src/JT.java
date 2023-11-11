public class JT {

    public static void main(String[] args) {
        int n = 4;
        SJT(n);
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

        //original that caused index out of bounds
//        int position = search(A, n, mobile);
//        if (!B[A[position - 1] - 1]) {
//            int temp = A[position - 1];
//            A[position - 1] = A[position - 2];
//            A[position - 2] = temp;
//
//        } else {
//            int temp = A[position];
//            A[position] = A[position - 1];
//            A[position - 1] = temp;
//        }
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
        for (int i = 0; i < n ; i++) {
            System.out.print(" "+ A[i] + " ");
        }
        System.out.println();
    }

    public static void SJT(int n) {
        int[] A = new int[n];
        boolean[] B = new boolean[n];
        for (int i = 0; i < n ; i++) {
            A[i] = i + 1;
            System.out.print(" "+ A[i] + " ");
        }
        System.out.println();
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



