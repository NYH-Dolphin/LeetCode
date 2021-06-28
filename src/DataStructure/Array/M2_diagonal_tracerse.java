package DataStructure.Array;

import java.util.ArrayList;
import java.util.Collections;

public class M2_diagonal_tracerse {

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};


        int[][] matrix2 = new int[1][2];
        matrix2[0] = new int[]{2, 3};
        int[] ans = findDiagonalOrder(matrix2);
        StringBuilder output = new StringBuilder();
        for (int an : ans) {
            output.append(an).append(",");
        }
        System.out.println(output);

    }

    public static int[] findDiagonalOrder(int[][] mat) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> diagon;

        int m, n;
        boolean flag = false;
        // 按照上边画斜线下来
        for (int i = 0; i < mat[0].length; i++) {
            diagon = new ArrayList<>();
            m = 0; n = i;
            while(m <= mat.length - 1 && n >= 0){
                diagon.add(mat[m][n]);
                m++; n--;
            }
            // 正的顺序放
            if(flag){
                ans.addAll(diagon);
                flag = false;
                // 反的顺序放
            }else{
                Collections.reverse(diagon);
                ans.addAll(diagon);
                flag = true;
            }
        }
        // 按照右边画斜线下来
        for(int i = 1; i < mat.length; i++){
            diagon = new ArrayList<>();
            m = i; n = mat[i].length - 1;
            while(m <= mat.length - 1 && n >= 0){
                diagon.add(mat[m][n]);
                m++; n--;
            }
            // 正的顺序放
            if(flag){
                ans.addAll(diagon);
                flag = false;
                // 反的顺序放
            }else{
                Collections.reverse(diagon);
                ans.addAll(diagon);
                flag = true;
            }
        }

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }

}
