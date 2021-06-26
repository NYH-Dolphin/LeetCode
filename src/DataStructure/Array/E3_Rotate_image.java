package DataStructure.Array;

public class E3_Rotate_image {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};

        int[][] matrix1 = new int[1][1];
        matrix1[0][0] = 1;
        rotate(matrix1);

        int[][] matrix2 = new int[2][2];
        matrix2[0] = new int[]{1, 2};
        matrix2[1] = new int[]{3, 4};

        int[][] matrix3 = new int[4][4];
        matrix3[0] = new int[]{5, 1, 9, 11};
        matrix3[1] = new int[]{2, 4, 8, 10};
        matrix3[2] = new int[]{13, 3, 6, 7};
        matrix3[3] = new int[]{15, 14, 12, 16};

        rotate(matrix3);
        System.out.println(1);

        for (int[] ints : matrix3) {
            System.out.println(ints[0] + " ");
        }
    }


    public static void rotate(int[][] matrix) {
        //先转置矩阵
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < i; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        //再镜像对称
        int left = 0;
        int right = matrix.length - 1;
        while (left < right){
            for (int i = 0; i < matrix.length; ++i){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }
}
