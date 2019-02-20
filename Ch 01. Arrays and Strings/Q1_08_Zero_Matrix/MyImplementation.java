package Q1_08_Zero_Matrix;

import java.util.ArrayList;
import java.util.List;

public class MyImplementation {

    public static void setZeros(int[][] matrix) {

        List<Integer> nullifyList = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    nullifyList.add(i);
                    nullifyList.add(j);
                }
            }
        }
        int k = 1;
        for (Integer nullifyRowColumn : nullifyList) {

            if (k % 2 == 0) {  // Column

                int len = matrix.length - 1;
                while (len > -1) {
                    matrix[len--][nullifyRowColumn] = 0;
                }

            } else {        // Row

                int len = matrix[0].length - 1;
                while (len > -1) {
                    matrix[nullifyRowColumn][len--] = 0;
                }
            }
            k++;
        }
    }
}
