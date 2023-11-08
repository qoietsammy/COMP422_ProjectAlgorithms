public class JT {

    public static void main(String[] args) {
        int n = 3;
        SJT(n);
    }

    public static int search(int[] array, int n, int k) {
        for (int i = 0; i < n - 1; i++) {
            if (A[n] == k) {
                return n + 1;
            }
        }
        return 0;
    }

    public static int findMobile(int[] A, int[] B, int n) {
        int last = 0;
        int mobile = 0;
        for (int i = 0; i < n - 1; i++) {
            if (B[A[n] - 1] == false && i != 0) {
                if (A[i] > A[i - 1] && A[i] > last) {
                    mobile = A[i];
                    last = mobile;
                }
            }
            if (B[A[n] - 1] == true && i != n - 1) {
                if (A[i] > A[i + 1] && A[i] > last) {
                    mobile = A[i];
                    last = mobile;
                }
            }
        }
        if (mobile = 0 && last = 0) {
            return 0;
        } else {
            return mobile;
        }
    }


    public static void printPermutation(int[] A, int[] B, int n) {
        mobile = findMobile(A, B, n);
        position = search(A, n, mobile);
        if (B[A[position - 1] - 1] == false) {
            int temp = A[position - 1];
            A[position - 1] = A[position - 2];
            A[position - 2] = temp;

        } else {
            int temp = A[position];
            A[position] = A[position - 1];
            A[position - 1] = temp;
        }

        for (int i = 0; i < n - 1; i++) {
            if (A[i] > mobile) {
                if (B[A[i] - 1] == false) {
                    B[A[i] - 1] = true;
                } else if (B[A[i] - 1] == true) {
                    B[A[i] - 1] = false;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.println(A[i]);
        }
    }

    public static void SJT(int n) {
        int A[] = new int[n];
        int B[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            A[i] = i + 1;
            print(A[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            B[i] = false;
        }
        for (int i = 0; i < n - 1; i++) {
            printPermutation(A, B, n);
        }

    }


}
