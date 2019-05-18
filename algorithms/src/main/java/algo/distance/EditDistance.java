package algo.distance;

public class EditDistance {
    public int getDistance(String a, String b) {
        if (a.equals(b)) {
            return 0;
        }
        int m = a.length();
        int n = b.length();
        int[][] martrix = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            martrix[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            martrix[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    martrix[i][j] = martrix[i - 1][j - 1];
                } else {
                    martrix[i][j] = Math.min(martrix[i - 1][j] + 1, Math.min(martrix[i][j - 1] + 1, martrix[i - 1][j - 1] + 1));
                }
            }
        }
        return martrix[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String a = "海蓝之家";
        String b = "海澜家";
        System.out.println(editDistance.getDistance(a, b));

    }


}
