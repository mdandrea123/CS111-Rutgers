/*************************************************************************
 * Compilation: javac HadamardMatrix.java Execution: java HadamardMatrix 2
 *
 * @author:
 *
 *          The program HadamardMatrix prints H(n)
 *
 *          % java HadamardMatrix 2 T T T F
 *
 *************************************************************************/

public class HadamardMatrix {

    public static void main(String[] args) {
        // WRITE YOUR CODE HERE
        int n = Integer.parseInt(args[0]);
        boolean[][] matrix = new boolean[n][n];

        matrix[0][0] = true;
        for (int k = 1; k < n; k+= k){
          for (int i = 0; i < k; i++){
              for (int j = 0; j < k; j++){
                  matrix[i + k][j] = matrix[i][j];
                  matrix[i][j + k] = matrix[i][j];
                  matrix[i + k][j + k] = !matrix[i][j];
              }
          }  
        }

        for (int i = 0; i < n; i++){
            for (int x = 0; x < n; x++){
                if (matrix[i][x]){
                    System.out.print("T");
                }else{
                    System.out.print("F");
                }
            }
            System.out.println();
        }
    }
}
