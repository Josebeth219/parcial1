import javax.swing.JOptionPane;
import java.util.Random;

class Problema1 {


    public static void main(String[] args) {
        int[][] matrix = new int[2][4];
        Random rand = new Random();

        // Fill matrix with random numbers
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = rand.nextInt(10); // values from 0 to 9
            }
        }

        // Print original matrix
        String original = printMatrix(matrix);
        // Print transpose matrix
        String transposed = printTranspose(matrix);

        JOptionPane.showMessageDialog(null,
                "Original Matrix:\n" + original +
                        "\nTransposed Matrix:\n" + transposed);
    }

    // Function to print the matrix
    public static String printMatrix(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : m) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Function to print the transposed matrix
    public static String printTranspose(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < m[0].length; col++) {
            for (int row = 0; row < m.length; row++) {
                sb.append(m[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


class Problema2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 7, 6},
                {7, 12, 9},
                {4, 3, 8}
        };

        StringBuilder output = new StringBuilder();
        output.append("Matrix:\n").append(printMatrix(matrix)).append("\n");

        boolean found = false;

        // Search for saddle point
        for (int i = 0; i < matrix.length; i++) {
            int minRow = matrix[i][0];
            int colIndex = 0;

            // Find the minimum value in the row
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < minRow) {
                    minRow = matrix[i][j];
                    colIndex = j;
                }
            }

            // Check if minRow is the maximum in its column
            boolean isSaddle = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][colIndex] > minRow) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                output.append("Saddle point found: ").append(minRow)
                        .append(" at position [").append(i).append(", ").append(colIndex).append("]\n");
                found = true;
                break;
            }
        }

        if (!found) {
            output.append("No saddle point found in the matrix.");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    // Function to return a string representation of the matrix
    public static String printMatrix(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : m) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

class Problema3 {
    public static void main(String[] args) {
        int size;
        do {
            size = Integer.parseInt(JOptionPane.showInputDialog(
                    "Enter the size of the square matrix (must be 3, 5, 7, or 9):"));
        } while (size < 3 || size > 9 || size % 2 == 0);

        int[][] matrix = new int[size][size];

        // Fill matrix with unique values via input
        JOptionPane.showMessageDialog(null, "Enter values for the " + size + "x" + size + " matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                        "Value at position [" + i + "][" + j + "]:"));
            }
        }

        StringBuilder output = new StringBuilder("Matrix:\n" + printMatrix(matrix));
        boolean isMagic = true;
        int targetSum = 0;

        // Sum of first row
        for (int j = 0; j < size; j++) {
            targetSum += matrix[0][j];
        }

        // Check rows
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += matrix[i][j];
            }
            output.append("Sum of row ").append(i).append(": ").append(rowSum).append("\n");
            if (rowSum != targetSum) isMagic = false;
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += matrix[i][j];
            }
            output.append("Sum of column ").append(j).append(": ").append(colSum).append("\n");
            if (colSum != targetSum) isMagic = false;
        }

        // Check diagonals
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < size; i++) {
            diag1 += matrix[i][i];
            diag2 += matrix[i][size - 1 - i];
        }
        output.append("Sum of main diagonal: ").append(diag1).append("\n");
        output.append("Sum of secondary diagonal: ").append(diag2).append("\n");
        if (diag1 != targetSum || diag2 != targetSum) isMagic = false;

        // Final result
        if (isMagic) {
            output.append("\nThe matrix IS magic. All sums = ").append(targetSum);
        } else {
            output.append("\nThe matrix is NOT magic.");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static String printMatrix(int[][] m) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : m) {
            for (int val : row) {
                sb.append(String.format("%3d", val)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
class Problema4 {

    public static void main(String[] args) {
        final int SIZE = 10;
        int[][] sumMatrix = new int[SIZE][SIZE];

        // Fill matrix with sums of indices
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sumMatrix[i][j] = i + j;
            }
        }

        // Build matrix string
        StringBuilder matrixStr = new StringBuilder("Sum Matrix (i + j):\n");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixStr.append(String.format("%3d", sumMatrix[i][j])).append(" ");
            }
            matrixStr.append("\n");
        }

        // Show matrix
        JOptionPane.showMessageDialog(null, matrixStr.toString());

        // Simulate sum
        int a = Integer.parseInt(JOptionPane.showInputDialog("Enter first number (0 to 9):"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Enter second number (0 to 9):"));

        if (a >= 0 && a < SIZE && b >= 0 && b < SIZE) {
            int resultSum = sumMatrix[a][b];
            JOptionPane.showMessageDialog(null, "Simulated Sum: " + a + " + " + b + " = " + resultSum);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input for sum.");
        }

        // Simulate subtraction
        int result = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter result to find in matrix (must be value inside the matrix):"));
        int index = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter the index used in the sum (0 to 9):"));

        boolean found = false;
        int subtracted = -1;

        // Try row-wise (simulate result - index = ?)
        for (int i = 0; i < SIZE && !found; i++) {
            if (index < SIZE && sumMatrix[i][index] == result) {
                subtracted = i;
                found = true;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, "Simulated Subtraction: " + result + " - " + index + " = " + subtracted);
        } else {
            JOptionPane.showMessageDialog(null, "Could not simulate subtraction. Check your inputs.");
        }
    }
}
