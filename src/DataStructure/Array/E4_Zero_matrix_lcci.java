package DataStructure.Array;

import java.util.Arrays;
import java.util.HashSet;

public class E4_Zero_matrix_lcci {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 1, 1};
        matrix[1] = new int[]{1, 0, 1};
        matrix[2] = new int[]{1, 1, 1};


        int[][] matrix1 = new int[3][4];
        matrix1[0] = new int[]{0, 1, 2, 0};
        matrix1[1] = new int[]{3, 4, 5, 2};
        matrix1[2] = new int[]{1, 3, 1, 5};
        setZeroes1(matrix1);
        for (int[] ints : matrix1) {
            System.out.println(ints[0] + "," + ints[1] + "," + ints[2] + "," + ints[2]);
        }

    }

    public static void setZeroes(int[][] matrix) {
        HashSet<String> zeroPos = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroPos.add(i + "," + j);
                    for (int m = 0; m < matrix.length; m++) {
                        zeroPos.add(m + "," + j);
                    }
                    for (int n = 0; n < matrix[i].length; n++) {
                        zeroPos.add(i + "," + n);
                    }
                }
            }
        }

        Object[] objPos = zeroPos.toArray();
        for (Object objPo : objPos) {
            String str = (String) objPo;
            String[] pos = str.split(",");
            matrix[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = 0;
        }
    }


    public static void setZeroes1(int[][] matrix) {
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int m = 0; m < matrix.length; m++) {
                        flag[m][j] = true;
                    }
                    for (int n = 0; n < matrix[i].length; n++) {
                        flag[i][n] = true;
                    }
                }
            }
        }

        for(int i = 0; i < flag.length; i++){
            for(int j = 0; j < flag.length; j++){
                if(flag[i][j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
