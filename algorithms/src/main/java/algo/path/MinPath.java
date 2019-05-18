package algo.path;

public class MinPath {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(getMinPath(matrix,matrix.length-1,matrix[0].length-1));
    }

    public static int getMinPath(int[][] matrix, int x, int y) {
        int base = matrix[x][y];
        if (x == 0 && y == 0) {
            return base;
        }
        if (x==0&&y>0){
            return base+getMinPath(matrix,x,y-1);
        }
        if(x>0&&y==0){
            return base+getMinPath(matrix,x-1,y);
        }
        return base+Math.min(getMinPath(matrix,x-1,y),getMinPath(matrix,x,y-1));
    }
}
