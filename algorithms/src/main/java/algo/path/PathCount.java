package algo.path;

//绕过障碍物（值为0则认为不可通过），统计下共有多少条路径从(0,0)到(m,n)
public class PathCount {
    public static int findWayCount(int[][] data, int m, int n) {
        if (m < 0 || n < 0 || data[m][n] == 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }

        return findWayCount(data, m - 1, n) + findWayCount(data, m, n - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1,1}, {0, 1,1}};
        System.out.println(findWayCount(matrix, matrix.length - 1, matrix[0].length - 1));
    }
}
