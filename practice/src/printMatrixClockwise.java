

public class printMatrixClockwise{

    public static String printMatrix(String[][] matrix, int rows, int columns){
        if(matrix.length == 0) return "";
        int start = 0;
        String r = "";
        while(start*2 < rows && start*2 < columns){
            r+= matrixCircle(matrix, rows, columns, start);
            start++;
        }
        return r;
    }

    public static String matrixCircle(String[][] matrix, int rows, int columns, int start){
        String r = "";
        int endRow = rows - 1 - start;
        int endColumn = columns - 1- start;

        for(int i = start; i <= endColumn; i++){
            r+= matrix[start][i];
        }
        if(endRow > start){
            for(int i = start+1; i <= endRow; i++){
                r+= matrix[i][endColumn];
            }
        }
        if(endColumn > start && endRow > start){
            for(int i = endColumn - 1; i >= start; i--){
                r+= matrix[endRow][i];
            }
        }
        if(endColumn > start && endRow-1 > start){
            for(int i = endRow -1; i > start; i--){
                r+= matrix[i][start];
            }
        }
        return r;
    }

    public static void main(String[] args){
        {
            String[][] m = {
                    {"a", "b", "c"},
                    {"1", "2", "3"},
                    {"d", "e", "f"},
            };
            System.out.println(printMatrix(m, 3, 3));
        }

        {
            String[][] m = {
                    {"a", "b", "c","d"},
                    {"1", "2", "3","4"},
                    {"e", "f", "g","h"},
            };
            System.out.println(printMatrix(m, 3, 4));
        }
        {
            String[][] m = {
                    {"a", "b"},
                    {"1", "2"},
                    {"e", "f"},
            };
            System.out.println(printMatrix(m, 3, 2));
        }
        {
            String[][] m = {
                    {"a"},
                    {"1"},
                    {"e"},
            };
            System.out.println(printMatrix(m, 3, 1));
        }

    }
}