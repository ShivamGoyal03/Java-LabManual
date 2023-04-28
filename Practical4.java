// Strassen’s matrix 
// Shivam
// 21CSU090

import java.util.*;

public class Practical4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of 1st Matrix : ");
        int size = sc.nextInt();

        // int[][] arr1 = new int[size1][size1]; // 1st array
        // int[][] arr2 = new int[size2][size2]; // 2nd array
        // int[][] arr3 = new int[size1][size1];

        // System.out.println("\n 1st Array : ");
        // for (int i = 0; i < size1; i++) {
        // for (int j = 0; j < size2; j++) {
        // arr1[i][j] = sc.nextInt();
        // }
        // }

        // System.out.println("\n 2nd Array : ");
        // for (int i = 0; i < size1; i++) {
        // for (int j = 0; j < size2; j++) {
        // arr2[i][j] = sc.nextInt();
        // }
        // }

        int[][] A, B;
        int[][] C = new int[size][size];
        int[][] Ans = new int[size][size];

        A = GenerateMatrix(size);
        B = GenerateMatrix(size);
        C = strassen(A, B, size);
        printMat(size, A);
        printMat(size, B);
        naiveMethod(A, B, Ans, size);
        System.out.println("\nStrassenn :");
        printMat(size, C);
    }

    /**
     * Display the Matrix
     * 
     * @param size
     *             The size of the Matrix
     * @param arr
     *             Matrix required to display
     */

    private static void printMat(int size, int[][] arr) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Basic Method To Multiply 2 Given Matrixes {@code arr1} & {@code arr2}, and
     * {@code arr3} as the resultant matrix
     * 
     * @param arr1
     *             First Matrix to be multiplied
     * @param arr2
     *             Second Matrix to be multiplied
     * @param arr3
     *             The Result Of Matrix Multiplication
     * @param size
     *             The size of the matrix
     */
    static void naiveMethod(int[][] arr1, int[][] arr2, int[][] arr3, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    arr3[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        System.out.println("\nNaive Approach :");
        printMat(size, arr3);
    }

    /**
     * Generate Matrix with random inputs from 0 - 10
     * 
     * @param n Size of the Matrix
     * @return Returns the generated matrix of n x n
     */
    static int[][] GenerateMatrix(int n) {
        Random r = new Random();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = r.nextInt(10);
            }
        }
        return mat;
    }

    /**
     * Addition of 2 Matrix {@code A} & {@code B}
     * 
     * @param A
     *          First Matrix to be Added
     * @param B
     *          Second Matrix to be Added
     * @return The resultant matrix
     */
    private static int[][] addMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = A[i][j] + B[i][j];
            }
        }
        return mat;
    }
    
    /**
     * Subtraction of 2 Matrix {@code A} & {@code B}
     * 
     * @param A
     *          First Matrix to be Subtracted
     * @param B
     *          Second Matrix to be Subtracted
     * @return The resultant matrix
     */
    private static int[][] subMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = A[i][j] - B[i][j];
            }
        }
        return mat;
    }

    static int[][] strassen(int[][] a, int[][] b, int n) {
        int[][] c = new int[n][n];
        strassenMM(a, b, c, n);
        return c;
    }

    /**
     * Strassen's Method Matrix Multiplication
     * 
     * @param a First Matrix to be multiplied
     * @param b Second Matrix to be multiplied
     * @param c Result of matrix multiplication
     * @param n Size of the matrix n x n
     * @return The resultant matrix
     */
    static void strassenMM(int[][] a, int[][] b, int[][] c, int n) {
        if (n <= 2) {
            c[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0]));
            c[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1]));
            c[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0]));
            c[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1]));
        } else {
            int[][] a11 = new int[n / 2][n / 2];
            int[][] a12 = new int[n / 2][n / 2];
            int[][] a21 = new int[n / 2][n / 2];
            int[][] a22 = new int[n / 2][n / 2];

            int[][] b11 = new int[n / 2][n / 2];
            int[][] b12 = new int[n / 2][n / 2];
            int[][] b21 = new int[n / 2][n / 2];
            int[][] b22 = new int[n / 2][n / 2];

            int[][] p = new int[n / 2][n / 2];
            int[][] q = new int[n / 2][n / 2];
            int[][] r = new int[n / 2][n / 2];
            int[][] s = new int[n / 2][n / 2];
            int[][] t = new int[n / 2][n / 2];
            int[][] u = new int[n / 2][n / 2];
            int[][] v = new int[n / 2][n / 2];

            // Initial Mat, new Mat, position in mat
            split(a, a11, 0, 0);
            split(a, a12, 0, n / 2);
            split(a, a21, n / 2, 0);
            split(a, a22, n / 2, n / 2);

            split(b, b11, 0, 0);
            split(b, b12, 0, n / 2);
            split(b, b21, n / 2, 0);
            split(b, b22, n / 2, n / 2);

            strassenMM(addMatrix(a11, a22), addMatrix(b11, b22), p, n / 2);
            strassenMM(addMatrix(a21, a22), b11, q, n / 2);
            strassenMM(a11, subMatrix(b12, b22), r, n / 2);
            strassenMM(a22, subMatrix(b21, b11), s, n / 2);
            strassenMM(addMatrix(a11, a12), b22, t, n / 2);
            strassenMM(subMatrix(a21, a11), addMatrix(b11, b12), u, n / 2);
            strassenMM(subMatrix(a12, a22),addMatrix(b21, b22), v, n / 2);

            int[][] c11 = addMatrix(subMatrix(addMatrix(p, s), t), v);
            int[][] c12 = addMatrix(r, t);
            int[][] c21 = addMatrix(q, s);
            int[][] c22 = addMatrix(subMatrix(addMatrix(p, r), q), u);

            join(c11, c, 0, 0);
            join(c12, c, 0, n / 2);
            join(c21, c, n / 2, 0);
            join(c22, c, n / 2, n / 2);
        }
    }

    /**
     * Dividing the matrix in {@code n / 2} terms
     * 
     * @param init   Initial Matrix to be divided
     * @param newMat The new matrix created from the initial matrix
     * @param a      Initial row position of Initial Matrix
     * @param b      Initial column position of Initial Matrix
     */
    static void split(int[][] init, int[][] newMat, int a, int b) {
        for (int i = 0, i2 = a; i < newMat.length; i++, i2++) {
            for (int j = 0, j2 = b; j < newMat.length; j++, j2++) {
                newMat[i][j] = init[i2][j2];
            }
        }
    }

    /**
     * Constructing / joining the new matrix from 2 matrixes
     * 
     * @param init   Initial Matrix to be joined
     * @param newMat The new matrix created from the initial matrix
     * @param a      Initial row position of Initial Matrix
     * @param b      Initial column position of Initial Matrix
     */
    // Joining Matrix
    static void join(int[][] init, int[][] newMat, int a, int b) {
        for (int i = 0, i2 = a; i < init.length; i++, i2++) {
            for (int j = 0, j2 = b; j < init.length; j++, j2++) {
                newMat[i2][j2] = init[i][j];
            }
        }
    }
}
