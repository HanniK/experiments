
public class PrintArray {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        int orgCols = 4;
        boolean reverse = false;

        for (int lines = 1; lines < (rows + orgCols + 1); lines++) {
            int num = 0;
            if (reverse) {
                if (orgCols > cols) {
                    cols += 1;
                }
            }
            if (!reverse) {
                cols -= 1;
                if (cols == 0) {
                    reverse = true;
                }
            }
            for (int j = 0; j <= orgCols; j++) {
                int num2 = cols + j;
                if (!reverse) {
                    System.out.print("[" + (num) + "," + (num2) + "]");
                } else {
                    if (num2 < rows) {
                        System.out.print("[" + (num2) + "," + (num) + "]");
                    }
                }
                if ((num += 1) == lines) {
                    break;
                }
            }
            System.out.println();
        }
    }
}
